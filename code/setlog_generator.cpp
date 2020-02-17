/**
 *  Programma C++ che preso in input un file contenente una lista di insiemi e di vincoli ('testX_prolog_data.txt'),
 *  produce in output un programma Prolog contenente la lista di tutti i possibili test ('testX_prolog_cases.pl')
 */ 

#include <iostream>
#include <string>
#include <fstream>
#include <ctype.h>
#include <cstdlib>
#include <vector>
#include <map>
#include <sstream> //int_to_string e string_to_int

#define MAX_SETS 10

using namespace std;

/**
In certe versioni di Windows, occorre ritornare string("\\")
*/
inline string separator() {
    #ifdef _WIN32 //Windows
        return string("/");
    #else //Linux, MacOS
        return string("/");
    #endif
}

//---std::stoi del C++ 11 adattata in C++ 98
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

struct set {
    string set_type; //vuoto
    //leggo un numero di insiemi arbitrario, fino a quando non finisce la riga, e memorizzo ogni set nell'indice di questo campo array
    string set_array[MAX_SETS]; //{"A1", "A2", ...}
};

struct constr {
    string jsetl_name; //eq
    string arity; //2
    string infix_prefix; //infix
    string setlog_name; //=
};

vector<constr> constrs;
map<string, set> set_map;

//arita' massima: utile nello scrivere la parte iniziale di testX_prolog_cases.pl
int max_arity = 0;

//stringa contenente tutte le regole Prolog definite dall'utente, e che saranno inserite in coda al file "testX_test_cases_specs.txt"
string user_defined_rules = "";

/**
 * Funzione usata per separare le linee lette dal file di input in piu' token separati da ' '
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

/* 
 * Dato in input il vector { {"A1","A2"}, {"{X1, X2}","{X3, X4}"} } 
 * restituisce in output il vector { {"A1", "{X1, X2}"}, {"A1", "{X3, X4}"}, {"A2", "{X1, X2}"}, {"A2", "{X3, X4}"} }
 */
vector<vector<string> > cart_product (const vector<vector<string> >& v) {
    vector<vector<string> > s;

    s.resize(1);

    for(unsigned int i = 0; i < v.size(); ++i) {
        vector<string> u = v[i];

        vector<vector<string> > r;
        for (unsigned int j = 0; j < s.size(); ++j) {
            vector<string> x = s[j];
            for (unsigned int k = 0; k < u.size(); ++k) {
                string y = u[k];
                r.push_back(x);
                r.back().push_back(y);
            }
        }
        s.swap(r);
    }
    return s;
}

/**
 * Funzione che legge il file 'testX_prolog_data.txt' e ne salva i valori in vector di struct
 */
void read_file(istream& in) {
    //booleano da impostare a true quando viene raggiunto il primo delimitatore ("$$$ global $$$") 
    //identifica l'inizio dei metodi che diventeranno globali nel .java generato
    bool delim_user_rules_reached = false;

    //booleano da impostare a true quando viene raggiunto il secondo delimitatore ("$$$ sets $$$") 
    //identifica l'inizio degli insiemi
    bool delim_sets_reached = false;

    //booleano da impostare a true quando viene raggiunto il terzo delimitatore ("$$$ constraints $$$") 
    //identifica l'inizio dei vincoli
    bool delim_constraints_reached = false;

    string delim_user_rules = "$$$ user rules $$$";
    string delim_sets = "$$$ args $$$";
    string delim_constraints = "$$$ constraints $$$";
    
    string line;
	
    for(; getline(in, line); ) {
        if(line == "") continue;
        if(line.at(0) == '/' && line.at(1) == '/') continue;
		if(line == delim_user_rules) { delim_user_rules_reached = true; continue;}
        if(line == delim_sets) { delim_sets_reached = true; continue;}
        if(line == delim_constraints) { delim_constraints_reached = true; continue;}
		
        //Se arrivo fin qui, significa che la riga che sto leggendo non e' un delimitatore 

        vector<string> v = split(line, "$");

        //Leggo vincoli definiti da utente e li accodo al file "testX_cases_prolog.pl"
		if(delim_user_rules_reached && !delim_sets_reached && !delim_constraints_reached) {
            line.erase(line.end()-1); //cancella il '.' finale della regola prolog (che per ipotesi e' scritta su una sola riga)
			user_defined_rules.append(":- setlog_clause(").append(line).append(").\n\n"); 
		}
    
		//Leggo argomenti
		else if(delim_user_rules_reached && delim_sets_reached && !delim_constraints_reached) {
			set s;
			
            s.set_type = v[0];
            /* ciclo per tutta la lunghezza di v, ossia il vettore contenente le stringhe "splittate" dai $
             * v[0] conterra il nome del set, mentre da v[1] in poi saranno presenti gli insiemi veri e propri, che vado
             * ad assegnare nel campo set_array[i]
             */
            for(unsigned int i = 0; i < v.size() - 1; ++i) {
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
                        curr_arg = "{";
                        for(int j = 0; j < n; ++j) {
                            curr_arg += int_to_string(j);
                            if(j != n - 1) curr_arg += ", "; 
                        }  

                        curr_arg += "}"; 

                    }

                    else if(name == "LSetFullySpecifiedNotGround") {
                        curr_arg = "{";
                        for(int j = 0; j < n; ++j) {
                            curr_arg += "RandomVar" + int_to_string(j);
                            if(j != n - 1) curr_arg += ", "; 
                        }  

                        curr_arg += "}"; 
                    }

                    else if(name == "LSetPartiallySpecifiedGround") {
                        curr_arg = "{";
                        for(int j = 0; j < n; ++j) {
                            curr_arg += int_to_string(j);
                            if(j != n - 1) curr_arg += ", "; 
                        }  

                        curr_arg += "/ Resto" + int_to_string(i) +"}"; 
                    }

                    else if(name == "LSetPartiallySpecifiedNotGround") {
                        curr_arg = "{";
                        for(int j = 0; j < n; ++j) {
                            curr_arg += "RandomVar" + int_to_string(j);
                            if(j != n - 1) curr_arg += ", "; 
                        }  

                        curr_arg += "/ Resto" + int_to_string(i) + "}"; 
                    }
                


                    //LREL

                    if(name == "LRelFullySpecifiedGround") {
                        curr_arg = "{";
                        for(int j = 0; j < n; ++j) {
                            curr_arg += "[" + int_to_string(2*j) + ", " + int_to_string(2*j) + "]";
                            if(j != n - 1) curr_arg += ", "; 
                        }  

                        curr_arg += "}"; 

                    }

                    else if(name == "LRelFullySpecifiedNotGround") {
                        curr_arg = "{";
                        for(int j = 0; j < n; ++j) {
                            curr_arg += "[RandomVar" + int_to_string(2*j) + ", RandomVar" + int_to_string(2*j+1) + "]";
                            if(j != n - 1) curr_arg += ", "; 
                        }  

                        curr_arg += "}"; 
                    }

                    else if(name == "LRelPartiallySpecifiedGround") {
                        curr_arg = "{";
                        for(int j = 0; j < n; ++j) {
                            curr_arg += "[" + int_to_string(2*j) + ", " + int_to_string(2*j) + "]";
                            if(j != n - 1) curr_arg += ", "; 
                        }  

                        curr_arg += "/ Resto" + int_to_string(i) +"}"; 
                    }

                    else if(name == "LRelPartiallySpecifiedNotGround") {
                        curr_arg = "{";
                        for(int j = 0; j < n; ++j) {
                            curr_arg += "[RandomVar" + int_to_string(2*j) + ", RandomVar" + int_to_string(2*j+1) + "]";
                            if(j != n - 1) curr_arg += ", "; 
                        }  

                        curr_arg += "/ Resto" + int_to_string(i) + "}"; 
                    }
                    
                }

                s.set_array[i] = curr_arg;
            }
            
            set_map.insert(pair<string, set>(v[0], s));
		}

        //Leggo vincoli
		else if(delim_user_rules_reached && delim_sets_reached && delim_constraints_reached){
			constr c;
			c.jsetl_name = v[0];
			c.arity = v[1];
			c.infix_prefix = v[2];
			c.setlog_name = v[3];

			constrs.push_back(c);
			
			//aggiorno l'arita' massima
			if(string_to_int(v[1]) > max_arity) max_arity = string_to_int(v[1]);
        }
    }

}

/**
 * Funzione che scrive il file 'testX_prolog_cases.pl'
 */
void write_test(vector<constr>::const_iterator c,
                vector<string> s,
                ostream& out) {

    if(c->infix_prefix == "prefix") {
        string jsetl_sets = "";
        string setlog_sets = "";

        for (size_t j = 0; j < s.size(); j++){

            if((set_map[s[j]].set_array[j]) == string("***")) return;

            jsetl_sets.append(s[j]);
            setlog_sets.append(set_map[s[j]].set_array[j]);

            if(j != s.size() - 1) {
                jsetl_sets.append(", ");
                setlog_sets.append(", ");
            }
        }

            out << ":- test(" << c->jsetl_name << "," << c->setlog_name << "("
            << setlog_sets
            << ")," 
            << jsetl_sets 
            << ")." << endl;
    }

    else //== "infix" --> in setlog, i vincoli infissi hanno cardinalita' = 2
    {
        string set1 = set_map[s[0]].set_array[0];
        string set2 = set_map[s[1]].set_array[1];
        if(set1 == "***") return;
        if(set2 == "***") return;

        out << ":- test(" << c->jsetl_name << "," 
        << set1 << " "
        << c->setlog_name << " "
        << set2
        << ","
        << s[0] << "," << s[1] 
        << ")." << endl;
    }

}

/**
 * Funzione che scrive sul file 'testX_prolog_cases.pl'
 */
void write_file(ostream& out, string name_cases_specs) {
	out << ":- style_check(-singleton).\n\n"; //disabilita i warning sulle variabili singleton
	
	for(int i = 0; i < max_arity-1; ++i) {
	
		out << "test(Op,C,";
		for(int j = 0; j < i+2; ++j) { //j+2 serve perche' al minimo avro' un test formato da due argomenti
			out << "Arg" << (j+1);
			if(j != (i+2)-1) out << ",";
		}
		out << ") :-\n";
		out << "\tsetlog(C,_),!,write(Op),write(' '),";
		for(int j = 0; j < i+2; ++j) { //j+2 serve perche' al minimo avro' un test formato da due argomenti
			out << "write(Arg" << (j+1) << "),write(' '),";
			if(j == (i+2)-1) out << "write(true),nl.\n";
		}
		
		out << "test(Op,_C,";
		for(int j = 0; j < i+2; ++j) { //j+2 serve perche' al minimo avro' un test formato da due argomenti
			out << "Arg" << (j+1);
			if(j != (i+2)-1) out << ",";
		}
		out << ") :-\n";
		out << "\twrite(Op),write(' '),";
		for(int j = 0; j < i+2; ++j) { //j+2 serve perche' al minimo avro' un test formato da due argomenti
			out << "write(Arg" << (j+1) << "),write(' '),";
			if(j == (i+2)-1) out << "write(false),nl.\n";
		}
		
	}

    out << "\n\n:- tell('"+name_cases_specs+"').\n\n";
	out << user_defined_rules;
	
	//************************** calcolo le combinazioni cartesiane degli insiemi **********************
    for(vector<constr>::const_iterator current_constr = constrs.begin(); current_constr != constrs.end(); ++current_constr) {
        int arity = string_to_int(current_constr->arity);
	
cout << "arity: " << arity << endl;
        vector<vector<string> > cartesian_sets;
        for(int i = 0; i < arity; ++i) {
            vector<string> tmp;
            
            for(std::map<string, set>::iterator iter = set_map.begin(); iter != set_map.end(); ++iter) {
                string s = iter->first;
                tmp.push_back(s);
            }

            cartesian_sets.push_back(tmp);
        }
for(unsigned int i = 0; i < cartesian_sets.size(); ++i) {
   vector<string> u = cartesian_sets[i];
   for (unsigned int k = 0; k < u.size(); ++k) {
	cout << cartesian_sets[i][k] << " ";
   }
   cout << endl;
}
        vector<vector<string> > res = cart_product(cartesian_sets);

        for(size_t i = 0; i < res.size();i++) {
            //res[i] contiene, ad esempio, {"vuoto", "vuoto", "vuoto"}
            write_test(current_constr, res[i], out);
        }

for(unsigned int i = 0; i < res.size(); ++i) {
   vector<string> u = res[i];
   for (unsigned int k = 0; k < u.size(); ++k) {
	cout << res[i][k] << " ";
   }
   cout << endl;
}
        out << endl;
    }

    out << "\n:- told.\n\n";
	out << ":- halt.";
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

    ifstream in;
    ofstream out;
    
    string name_in = name_test_set + "_prolog_data.txt";
    
    in.open((name_test_set + separator() + name_in).c_str());

    if(in.fail()) {
        cerr << "Errore nell'apertura del file " << name_in << endl;
        return 1;
    }

    string name_out = name_test_set + "_prolog_cases.pl";

    out.open((name_test_set + separator() + name_out).c_str());
 
    //lettura 'testX_prolog_data.txt'
    read_file(in);
    
    //scrittura 'testX_prolog_cases.pl'
    string name_cases_specs = name_test_set + separator() + name_test_set + "_test_cases_specs.txt";
    write_file(out, name_cases_specs);

    //chiusura dei file
    in.close();
    out.close();
}
