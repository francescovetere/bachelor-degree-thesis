/**
 *  Programma C++ che presi in input una lista di casi di test con relativo esito ('testX_test_cases_specs.txt')
 *  ed un file di configurazione contenente gli insiemi e i vincoli espressi in JSetL con relative direttive di import ('testX_java_data.txt'),
 *  produce in output una serie di classi Java, una per ogni vincolo considerato.
 */ 

#include <iostream>
#include <string>
#include <fstream>
#include <ctype.h>
#include <vector>
#include <map>
#include <sstream> //int_to_string e string_to_int
#include <unistd.h> // getcwd()

#define MAX_SETS 10

using namespace std;

/**
In certe versioni di Windows, occorre ritornare string("\\")
*/
inline string separator() {
    #ifdef _WIN32 //Windows
        return string("\\");
    #else //Linux, MacOS
        return string("/");
    #endif
}

/**
Ritorna la directory di lavoro corrente
*/
string current_dir() {
    std::string cwd("\0", 1024);
    return getcwd(&cwd[0],cwd.capacity());
}

//---std::stoi  del C++ 11 adattata in C++ 98
int string_to_int(string str) {
    int result;          //number which will contain the result

    istringstream convert(str); // stringstream used for the conversion constructed with the contents of str
                                  // ie: the stream will start containing the characters of str
    convert >> result; //give the value to result using the characters in the stream

    return result;
}

//---std::to_string del C++ 11 adattata in C++ 98
string int_to_string(int number) {
    string result;          // string which will contain the result

    ostringstream convert;   // stream used for the conversion
    convert << number;      // insert the textual representation of number in the characters in the stream

    result = convert.str(); // set result to the contents of the stream
    return result;
}

//sostituisce tutte le occorrenze in str di old_pattern con new_pattern (utile per sostituire i "\\"  con "\\\\")
void replace_string(string& str, const string& old_pattern, const string& new_pattern) {
	size_t pos = 0;
	while((pos = str.find(old_pattern, pos)) != string::npos) {
		str.replace(pos, old_pattern.length(), new_pattern);
		pos += new_pattern.length();
	}
}	

struct set {
    string set_type;
    //leggo un numero di insiemi arbitrario, fino a quando non finisce la riga, e memorizzo ogni set nell'indice di questo campo array
    string set_array[MAX_SETS]; //{"", "", ...}
};

struct constr {
    string name; //eq
    string arity; //2
    string infix_prefix; //utile avere il prefix per i vincoli definiti da utente (es.: vincolo(A, B, C))
};

//puntatore a mappa tra nome del file e il suo relativo stream
map<string, ofstream*> files_map;

//due mappe usate per mappare gli insiemi e i vincoli nei loro valori
map<string, set> set_map;
map<string, constr> constr_map;

//stringa contenente le import ed eventualmente altre informazioni contenute in 'import_java.txt'
string header = "";

//directory in cui salvare i file JUnit generati
string directory = "";

//stringa contenente tutte le dichiarazioni Java in testa al file 'testX_java_data.txt'
string declarations = "";

//stringa contenente tutti i constraint definiti dall'utente, e che saranno inseriti in testa alle classi Java generate
string user_defined_constraints = "";

//se timer = true, i file Java finali conterranno anche le istruzioni per calcolare i tempi di esecuzione
bool timer;

/**
 * Funzione che presa una stringa, ritorna una copia della stringa col primo carattere maiuscolo
 */
string capitalize(const string& str) {
    string tmp = str.substr(1);
    char c = toupper(str.at(0));
    string s(1, c);

    tmp.insert(0, s);

    return tmp;
}

/**
 * Funzione usata per separare le linee lette dal file di input in piu' token separati da un delimitatore
 */
vector<string> split(const string& str, const string& delim) {
    vector<string> tokens;
    size_t prev = 0, pos = 0;

    do {
        pos = str.find(delim, prev);
        if (pos == string::npos) pos = str.length();
        string token = str.substr(prev, pos - prev);
        if (!token.empty()) tokens.push_back(token);
        prev = pos + delim.length();
    }

    while (pos < str.length() && prev < str.length());

    return tokens;
}

/**
 * Funzione che legge il file 'import_java.txt' e salva il suo contenuto nel parametro header, passato per riferimento
 */
void read_file_1(istream& import_java) {
    string line;
	
    while(getline(import_java, line)) {
        header.append(line).append("\n");
    }
}

/**
 * Funzione che legge il file 'testX_java_data.txt' e ne salva i valori in mappe 
 * Per gli insiemi: <string, set>  (es.: <"chiuso", s> dove s e' una struct set)
 * Per i vincoli: <string, string> (es.: <"eq","2">)
 * 
 * Inoltre, la funzione si occupa di aprire un file per ogni vincolo, e scrivervi l'header iniziale comune a tutti i file
 */
void read_file_2(istream& cases_java) {
    //booleano da impostare a true quando viene raggiunto il primo delimitatore ("$$$ global $$$") 
    //identifica l'inizio dei metodi che diventeranno globali nel .java generato
    bool delim_global_reached = false;

    //booleano da impostare a true quando viene raggiunto il secondo delimitatore ("$$$ local $$$") 
    //identifica l'inizio delle dichiarazioni locali ad ogni metodo nel .java generato
    bool delim_local_reached = false;

    //booleano da impostare a true quando viene raggiunto il terzo delimitatore ("$$$ sets $$$") 
    //identifica l'inizio degli insiemi
    bool delim_sets_reached = false;

    //booleano da impostare a true quando viene raggiunto il quarto delimitatore ("$$$ constraints $$$") 
    //identifica l'inizio dei vincoli
    bool delim_constraints_reached = false;

    string delim_global = "$$$ global $$$";
    string delim_local = "$$$ local $$$";
    string delim_sets = "$$$ args $$$";
    string delim_constraints = "$$$ constraints $$$";

    string line;

    for(; getline(cases_java, line); ) {

        if(line == "") continue;
        if(line.at(0) == '/' && line.at(1) == '/') continue;
		if(line == delim_global) { delim_global_reached = true; continue;}
        if(line == delim_local) { delim_local_reached = true; continue;}
        if(line == delim_sets) { delim_sets_reached = true; continue;}
        if(line == delim_constraints) { delim_constraints_reached = true; continue;}

        //Leggo dichiarazioni globali di vincoli definiti da utente
		if(delim_global_reached && !delim_local_reached && !delim_sets_reached && !delim_constraints_reached) {
			user_defined_constraints.append(line).append("\n\t");
		}

	    //Leggo dichiarazioni locali ai metodi
		if(delim_global_reached && delim_local_reached && !delim_sets_reached && !delim_constraints_reached) {
			declarations.append(line).append("\n\t\t");
		}

	    //Leggo insiemi
		else if(delim_global_reached && delim_local_reached && delim_sets_reached && !delim_constraints_reached) {
            vector<string> v = split(line, "$");
			set s;
                    
            s.set_type = v[0];

            /* ciclo per tutta la lunghezza di v, ossia il vettore contenente le stringhe "splittate" dai $
            * v[0] conterra il nome del set, mentre da v[1] in poi saranno presenti gli insiemi veri e propri, che vado
            * ad assegnare nel campo set_array[i]
            * Analogamente a setlog_generator.cpp, tratto in modo speciale i casi "***"
            */
            for(unsigned int i = 0; i < v.size() - 1; ++i) {
                if(v[i + 1] != "***") {

                    string curr_arg = v[i + 1];
                
                    //controllo se l'insieme/relazione attuale e' definito in modo parametrico, ovvero del tipo #LSetChiusoBound_10
                    if(curr_arg.at(0) == '#') {
                        string tmp = curr_arg.substr(1);

                        vector<string> tmp_vector = split(tmp, "_"); // es.: <"LSetChiusoBound", "10">
                        
                        string name = tmp_vector[0];
                        int n = string_to_int(tmp_vector[1]);

                        /* 8 casi possibili per name:
                         * LSet puo' essere LSetChiusoBound, LSetChiusoVar, LSetApertoBound, LSetApertoVar
                         * LRel puo' essere LRelChiusoBound, LRelChiusoVar, LRelApertoBound, LRelApertoVar
                         */


                        //LSET
                        if(name == "LSetFullySpecifiedGround") {
                            //int_to_string(i) serve solamente a dare un nome random all'insieme, altrimenti
                            //rischierei di avere variabili con lo stesso nome nel codice Java
                            
                            string genLSetFSGround = (string)"LSet genLSetFSGround(int n) {\n"
                            + "\t\tInteger[] values = new Integer[n];\n"
                            + "\t\tfor(int i = 0; i < n; ++i) {values[i] = i;}\n"
                            + "\t\tLSet res = LSet.empty().insAll(values);\n"
                            + "\t\treturn res;\n"
                            + "\t}\n";

                            user_defined_constraints.append(genLSetFSGround).append("\n\t");

                            curr_arg = "LSet LSetFullySpecifiedGround" + int_to_string(i) + " = genLSetFSGround(" + int_to_string(n) + ")";

                        }

                        else if(name == "LSetFullySpecifiedNotGround") {
                            curr_arg = "LSet LSetFullySpecifiedNotGround" + int_to_string(i) + " = LSet.mkSet(" + int_to_string(n) + ")";
                        }

                        else if(name == "LSetPartiallySpecifiedGround") {
                            string genLSetPSGround = (string)"LSet genLSetPSGround(int n) {\n"
                            + "\t\tInteger[] values = new Integer[n];\n"
                            + "\t\tfor(int i = 0; i < n; ++i) {values[i] = i;}\n"
                            + "\t\tLSet res = new LSet().insAll(values);\n"
                            + "\t\treturn res;\n"
                            + "\t}\n";

			    user_defined_constraints.append(genLSetPSGround).append("\n\t");

                            curr_arg = "LSet LSetPartiallySpecifiedGround" + int_to_string(i) + " = genLSetPSGround(" + int_to_string(n) + ")";
                            // for(int j = 0; j < n; ++j) {
                            //     curr_arg += ".ins(" + int_to_string(j) + ")";
                            // } 
                        }

                        else if(name == "LSetPartiallySpecifiedNotGround") {
                            string genLSetPSNotGround = (string)"LSet genLSetPSNotGround(int n) {\n"
                            + "\t\tLVar[] values = new LVar[n];\n"
                            + "\t\tfor(int i = 0; i < n; ++i) {values[i] = new LVar();}\n"
                            + "\t\tLSet res = new LSet().insAll(values);\n"
                            + "\t\treturn res;\n"
                            + "\t}\n";

			    user_defined_constraints.append(genLSetPSNotGround).append("\n\t");
                            curr_arg = "LSet LSetPartiallySpecifiedNotGround" + int_to_string(i) + " = genLSetPSNotGround(" + int_to_string(n) + ")";
                        }


                        //LREL
                        if(name == "LRelFullySpecifiedGround") {
                            // curr_arg = "LRel LRelFullySpecifiedGround" + int_to_string(i) +" = LRel.empty()";
                            // for(int j = 0; j < n; ++j) {
                            //     curr_arg += ".ins(new LPair(" + int_to_string(j*2) + ", " + int_to_string(j*2+1) + "))";
                            // }  

                            string genLRelFSGround = (string)"LRel genLRelFSGround(int n) {\n"
                            + "\t\tLPair[] values = new LPair[n];\n"
                            + "\t\tfor(int i = 0; i < n; ++i) {values[i] = new LPair(i*2, i*2);}\n"
                            + "\t\tLRel res = LRel.empty().insAll(values);\n"
                            + "\t\treturn res;\n"
                            + "\t}\n";

                            user_defined_constraints.append(genLRelFSGround).append("\n\t");

                            curr_arg = "LRel LRelFullySpecifiedGround" + int_to_string(i) + " = genLRelFSGround(" + int_to_string(n) + ")";
                        }

                        else if(name == "LRelFullySpecifiedNotGround") {
                            string genLRelFSNotGround = (string)"LRel genLRelFSNotGround(int n) {\n"
                            + "\t\tLPair[] values = new LPair[n];\n"
                            + "\t\tfor(int i = 0; i < n; ++i) {values[i] = new LPair(new LVar(), new LVar());}\n"
                            + "\t\tLRel res = LRel.empty().insAll(values);\n"
                            + "\t\treturn res;\n"
                            + "\t}\n";

                            user_defined_constraints.append(genLRelFSNotGround).append("\n\t");

                            curr_arg = "LRel LRelFullySpecifiedNotGround" + int_to_string(i) + " = genLRelFSNotGround(" + int_to_string(n) + ")";
                        }

                        else if(name == "LRelPartiallySpecifiedGround") {
                            string genLRelPSGround = (string)"LRel genLRelPSGround(int n) {\n"
                            + "\t\tLPair[] values = new LPair[n];\n"
                            + "\t\tfor(int i = 0; i < n; ++i) {values[i] = new LPair(i*2, i*2);}\n"
                            + "\t\tLRel res = new LRel().insAll(values);\n"
                            + "\t\treturn res;\n"
                            + "\t}\n";

                            user_defined_constraints.append(genLRelPSGround).append("\n\t");

                            curr_arg = "LRel LRelPartiallySpecifiedGround" + int_to_string(i) + " = genLRelPSGround(" + int_to_string(n) + ")";
                        
                        }

                        else if(name == "LRelPartiallySpecifiedNotGround") {
                            string genLRelPSNotGround = (string)"LRel genLRelPSNotGround(int n) {\n"
                            + "\t\tLPair[] values = new LPair[n];\n"
                            + "\t\tfor(int i = 0; i < n; ++i) {values[i] = new LPair(new LVar(), new LVar());}\n"
                            + "\t\tLRel res = LRel.empty().insAll(values);\n"
                            + "\t\treturn res;\n"
                            + "\t}\n";

                            user_defined_constraints.append(genLRelPSNotGround).append("\n\t");

                            curr_arg = "LRel LRelPartiallySpecifiedNotGround" + int_to_string(i) + " = genLRelPSNotGround(" + int_to_string(n) + ")";
                        
                        }

                    }


                    s.set_array[i] = curr_arg;
                }
            }
				
			set_map.insert(pair<string, set>(v[0], s));
		}
			
		//Leggo vincoli
		else if(delim_global_reached && delim_local_reached && delim_sets_reached && delim_constraints_reached){
            vector<string> v = split(line, "$");
            constr c;

            c.arity = v[1];
            c.infix_prefix = v[2];
            constr_map.insert(pair<string, constr>(v[0], c));

			//per ogni vincolo, viene creato un file e viene salvata l'associazione tra il nome del file 
			//e il relativo puntatore ad ofstream
			string file_name = capitalize(v[0]) + "Test.java";

			files_map.insert(pair<string, ofstream*>(file_name, new std::ofstream()));
			string file = directory + file_name;
            files_map[file_name]->open(file.c_str());
            (*files_map[file_name]) << header << "\n\n" << "public class " << capitalize(v[0]) + "Test {\n\n\t" 
            << user_defined_constraints << "\n";
            if(timer) (*files_map[file_name]) << "\t//somma dei tempi parziali di tutti i metodi\n\tprivate static long totTime = 0;\n\n";
        }

	} //for
		
}

/**
 * Funzione che legge il file 'testX_test_cases_specs.txt' e lo usa per creare n classi diverse con i relativi test, dove
 * n e' il numero di vincoli presenti nel file letto.
 */
void read_file_3_and_write_java(istream& test_cases_specification) {
	string line;
	
	while(getline(test_cases_specification, line)) {
		vector<string> v = split(line, " ");
		int arity = string_to_int(constr_map[v[0]].arity);
        string infix_prefix = constr_map[v[0]].infix_prefix;

        string jsetl_sets = "";
        vector<string> names; //es.: { "{A, B}", "{C, D}", "{X, Y}" }
        string vincolo = "";
        
        int indexResult = 1 + arity; //al primo posto c'è il nome del vincolo, seguono gli insiemi (tanti quanti l'arita') e poi c'è il risultato booleano
        string result = capitalize(v[indexResult]);

            string methodName = string("@Test\n\t") + "public void test";
            
            for(int i = 0; i <= arity; ++i) {
                methodName.append(capitalize(v[i]));
                if(i != arity) methodName.append("_");
                else methodName.append("()");
            }
            
            for(int i = 0; i < arity; ++i) {
                string s = set_map[v[i+1]].set_array[i]; //ad esempio LSet S = new LSet("S");
                jsetl_sets.append(s).append(";\n\t\t");

            /* Per poter scrivere vincolo(A, B, C) dove A, B e C sono tre variabili inserite in java_data.txt dall'utente, 
             * opero nel seguente modo:
             * dichiaro un vector<string> temp1 che contiene il vector di stringe ottenutto dallo split dell'insieme letto
           	 * ad esempio, temp1 = < "LVar","X","=","new","LVar("X")" >
             * tramite temp1[1], accedo al nome della LVar (in questo esempio, "X")
             */                    

                vector<string> temp = split(s, " ");
                string name = temp[1];

                names.push_back(name);
            }
            
            if(infix_prefix == "infix") //tipicamente vincolo standard
            {
                vincolo = names[0] + "." + string(v[0]) + "(";
                for(int i = 1; i < arity; ++i){
                    vincolo.append(names[i]);
                    if(i != arity - 1) vincolo.append(", ");
                }
                 
                vincolo += ")";
            }
            
            else if(infix_prefix == "prefix") //tipicamente vincolo utente
            {
                 vincolo = string(v[0]) + "(";

                for(int i = 0; i < arity; ++i){
                    vincolo.append(names[i]);
                    if(i != arity - 1) vincolo.append(", ");
                }

                vincolo += ")";
            }

            string timerStart = "", timerStop = "";

            if(timer) {
                timerStart = "\n\t\t//timer start\n\t\tlong start = System.currentTimeMillis();\n";
                timerStop = "\n\t\t//timer stop\n\t\tlong stop = System.currentTimeMillis();\n\t\tsynchronized(this){totTime += (stop - start);}";
            }
            
            string methodBody = declarations + timerStart +
            "\n\t\tSolver solver = new Solver();\n\t\t" +
            jsetl_sets +
            "solver.add(" + vincolo + ");\n\t\t" +
            "assert" + result + "(solver.check());\n" + "\t" + timerStop;

            string file_name = (capitalize(v[0]) + "Test.java").c_str();
            (*files_map[file_name]) << "\t" << methodName << " {\n\t" << methodBody << "\n\t}\n\n";
    }
}

/**
 * Funzione principale
 */
int main(int argc, char* argv[]) {
	string name_test_set;
	
	/* Possibile impostare name_test_set sia da programma gia' avviato (come input utente), sia da riga di comando */
	if(argc == 1) {
		cout << "Insert test set name: ";
		getline(cin, name_test_set);
	}
	
	else if(argc == 2) {
		//Passo il name_test_set tramite la linea di comando (argv[0] e' il nome del programma)
    	name_test_set = argv[1];
    }
    	
    else {
		cout << "Usage: <name_executable> <name_test_set>" << endl;
		return 1;
	}
	
    	
    //gestione del timer nei file java
    char answer;
    cout << "Include timer in Java tests? (y/n):";
    cin >> answer;
    if(answer == 'n' || answer == 'N') timer = false;
    else timer = true;

    ifstream import_java;
    ifstream cases_java;
    ifstream test_cases_specification;

    string s1("import_java.txt");

    string s2 = name_test_set + "_java_data.txt";
    string s3 = name_test_set + "_test_cases_specs.txt";
    
    directory = name_test_set + separator();

    import_java.open(s1.c_str());

    cases_java.open((directory + s2).c_str());
    test_cases_specification.open((directory + s3).c_str());

    if(import_java.fail()) {
        cerr << "Errore nell'apertura di import_java.txt\n";
        return 0;
    }

    if(cases_java.fail()) {
        cerr << "Errore nell'apertura di " << s2 << endl;
        return 0;
    }

    if(test_cases_specification.fail()) {
        cerr << "Errore nell'apertura di " << s3 << endl;
        return 0;
    }
    
    //lettura 'import_java.txt'
    read_file_1(import_java);

    //lettura 'testX_java_data.txt'
    read_file_2(cases_java);

    //lettura 'testX_cases_specs.txt' e scrittura delle diverse classi Java
    read_file_3_and_write_java(test_cases_specification);

    //chiusura dei file in input
    import_java.close();
    cases_java.close();
    test_cases_specification.close();

    //per ogni classe Java, aggiungo il simbolo '}' per chiudere il corpo della classe e infine chiudo il file
    for(map<string, ofstream*>::iterator i = files_map.begin(); i != files_map.end(); ++i) {
        if(timer) {
            string dir = current_dir() + separator() + name_test_set + separator();
			
			/* In Windows, il separatore e' '\'. Quindi, devo fare l'escape a mano */
			replace_string(dir, "\\", "\\\\");
			
            string constraint_name = (i->first).substr(0, (i->first).length() - 9); //tolgo il "Test.java" finale

            *(i->second) << "\t@AfterClass\n\tpublic static void printTotTime() {\n"
                         << "\t\tPrintWriter writer;\n"
		                 << "\t\ttry {\n"
                         << "\t\t\tString dir  = " << "\"" << dir << "\"" << ";\n"
                         << "\t\t\twriter = new PrintWriter(new FileOutputStream(new File(dir +  \"times.txt\"),true));\n" 
                         << "\t\t\twriter.println(" << "\"" << constraint_name << "\"" << " + \" \" + totTime);\n"
                         << "\t\t\twriter.close();\n"
		                 << "\t\t} catch (Throwable t) {t.printStackTrace();}\n"
                         << "\n\t}\n\n";
        }
        i->second->put('}');
        i->second->close();
    }
}
