****************************************************************************************
*** Strumento per la generazione automatica di test su vincoli per la libreria JSetL ***
****************************************************************************************

Autore: Vetere Francesco
Anno: 2018/2019

/**********************************************************
 ************* (1) PREREQUISITI DI SISTEMA ****************
 **********************************************************/
- g++ (o software equivalente, nel caso non si voglia usufruire dello script di automazione)
- swipl (o software equivalente, nel caso non si voglia usufruire dello script di automazione)
- JSetL
- JUnit 
- IDE Java per la visualizzazione grafica dei risultati dei test

Questo strumento e' stato testato fino ad ora su macchine Windows 10 64 bit e Linux Ubuntu 16.04 64 bit.
(nota: per utilizzare lo script di automazione su Windows e' necessario aggiungere i percorsi di g++ e swipl alla variabile d'ambiente PATH).
(nota: portando il software da Windows a Linux e viceversa, e' necessario, prima di avviare la generazione dei test, assicurarsi di ripristinare la formattazione corretta dei file .txt (in Linux e in Windows infatti, '\n' e' interpretato in due modi diversi). E' possibile farlo manualmente o tramite il tool scaricabile a questo indirizzo: http://dos2unix.sourceforge.net/ )

/**********************************************************
 ************* (2) CREAZIONE DI UN NUOVO TEST CASE ********
 **********************************************************/
- Nella directory root ("test_cases_generator") Creare una nuova cartella "testX"
- Al suo interno creare due file di testo, "testX_prolog_data.txt" e "testX_java_data.txt"

Questi due file di testo devono avere una sintassi ben precisa:

	///////// testX_prolog_data.txt /////////
	=============inizio=============
	$$$ user rules $$$
	<regole prolog definite dall'utente>

	$$$ args $$$
	nome_arg_1$[SINTASSI_{LOG}_1]$...$[SINTASSI_{LOG]_N]
	...
	nome_arg_N$...

	$$$ constraints $$$
	<nome_vincolo1_JSetL$arita'$prefisso-infisso$nome_vincolo1_setlog>
	...
	<nome_vincoloN_JSetL$arita'$prefisso-infisso$nome_vincoloN_setlog>
	=============fine=============
	
			--- ESEMPIO ---
			$$$ user rules $$$

			$$$ args $$$
			vuoto${}${}${}
			var$S1$S2$S3
			chiuso${X1,Y1}${X2,Y2}${X3,Y3}
			aperto${A1/B1}${A2/B2}${A3/B3}

			$$$ constraints $$$
			diff$3$prefix$diff
			inters$3$prefix$inters
			subset$2$prefix$subset
			
	N.B.:
	Possibile creare insiemi/relazioni chiusi/aperti contenenti valori ground/non ground, di dimensione N qualsiasi.
	E' sufficiente scrivere SINTASSI_{LOG}_I-ESIMA in uno dei seguenti modi:
		#LSetFullySpecifiedGround_N 
		#LSetFullySpecifiedNotGround_N
		#LSetPartiallySpecifiedGround_N
		#LSetPartiallySpecifiedNotGround_N
		
		#LRelFullySpecifiedGround_N 
		#LRelFullySpecifiedNotGround_N
		#LRelPartiallySpecifiedGround_N
		#LRelPartiallySpecifiedNotGround_N
	
	
	
	///////// testX_java_data.txt /////////
	=============inizio=============
	$$$ global $$$
	<dichiarazioni globali per poter risolvere vincoli definiti da utente>

	$$$ local $$$
	<dichiarazioni che saranno locali a ogni metodo di questo test set>

	$$$ args $$$
	nome_arg_1$[SINTASSI_JSETL_1]$...$[SINTASSI_JSETL_N]
	...
	nome_arg_N$...

	$$$ constraints $$$
	<nome_vincolo1_JSetL$arita'$prefisso-infisso$nome_vincolo1_setlog>
	...
	<nome_vincoloN_JSetL$arita'$prefisso-infisso$nome_vincoloN_setlog>
	=============fine=============
	
			--- ESEMPIO ---
			$$$ global $$$

			$$$ local $$$

			$$$ args $$$
			vuoto$LSet A = LSet.empty()$LSet B = LSet.empty()$LSet C = LSet.empty()
			var$LSet A = new LSet("S1")$LSet B = new LSet("S2")$LSet C = new LSet("S3")
			chiuso$LSet A = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"))$LSet B = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"))$LSet C = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"))
			aperto$LSet A = new LSet("B1").ins(new LVar("A1"))$LSet B = new LSet("B2").ins(new LVar("A2"))$LSet C = new LSet("B3").ins(new LVar("A3"))

			$$$ constraints $$$
			diff$3$infix
			inters$3$infix
			subset$2$infix
			
	N.B.:
	Possibile creare insiemi/relazioni chiusi/aperti contenenti valori bound/unbound, di dimensione N qualsiasi.
	E' sufficiente scrivere SINTASSI_JSETL_I-ESIMA in uno dei seguenti modi:
		#LSetFullySpecifiedGround_N 
		#LSetFullySpecifiedNotGround_N
		#LSetPartiallySpecifiedGround_N
		#LSetPartiallySpecifiedNotGround_N
		
		#LRelFullySpecifiedGround_N 
		#LRelFullySpecifiedNotGround_N
		#LRelPartiallySpecifiedGround_N
		#LRelPartiallySpecifiedNotGround_N

Ulteriori note sulla sintassi dei 2 file di input: 
--> I nomi degli insiemi (vuoto, var, chiuso...) devono essere uguali sia in "testX_prolog_data.txt" che in "testX_java_data.txt", e devono 
essere uguali anche in numero.
--> Possibile inserire commenti all'inizio di ogni riga, semplicemente con la sintassi "// questo e' un commento"
--> Le sezioni $$$ user rules $$$, $$$ global $$$ e $$$ local $$$ possono essere eventualmente anche vuote. 
    Le sezioni $$$ sets $$$ e $$$ constraints $$$ devono invece avere almeno un record, altrimenti non si avrebbe alcun caso di test.
--> Possibile inserire l'insieme speciale denotato da "***", che, a seconda della posizione in cui e' messo, sta a significare che quell'insieme/quella variabile/quell'oggetto Java non deve apparire in quella posizione all'interno del vincolo.

		Esempio di uso della sintassi "***":

		///////// testX_prolog_data.txt /////////
		=============inizio=============
		...
		...
		$$$ args $$$
		lVarNotBound$X$***
		lVarBound$3$***
		vuoto$***${}
		var$***${X}
		...
		...
		=============fine=============


		///////// testX_java_data.txt /////////
		=============inizio=============
		...
		...
		$$$ args $$$
		lVarNotBound$LVar LVN = new LVar("X")$***
		lVarBound$LVar LVB = new LVar(3)$***
		vuoto$***$LSet E = LSet.empty()
		var$***$LSet V = new LSet("V")
		...
		...
		=============fine=============

		In questo esempio, viene usata la sintassi speciale ***, in modo che tutti i vincoli generati siano della forma 
				 A.vincolo(B) con A = new LVar(3), B = new LSet("V").
		(Utile, ad esempio, per vincoli come in e nin, ma anche per testare i RIS)
	
	
	
/**********************************************************
 ************* (3) GENERAZIONE DEI TEST *******************
 **********************************************************/
 
 Per generare le classi Java finali, e' sufficiente eseguire "script_windows.bat" in ambiente Windows, o "script_linux.bash" in ambiente Linux.
 L'utente ha anche la possibilita' di scegliere se avere o meno nei file Java finali il calcolo dei tempi di esecuzione relativi agli unit test Java generati. Il risultato dei tempi d'esecuzione verra' riportato nel file "times.txt" nella stessa cartella del test set corrente.
 
 In alternativa, e' sempre possibile procedere alla compilazione manualmente:
 - compilare "setlog_generator.cpp"
 - lanciare l'eseguibile generato, che a sua volta generera' il file "testX_prolog_cases.pl"
 - aprire un interprete Prolog, caricare prima il file "setlog496-5c.pl" e poi "testX_prolog_cases.pl"
   Il risultato generato e' il file "testX_test_cases_specs.txt"
 - compilare "java_generator.cpp"
 - lanciare l'eseguibile generato, che a sua volta generera' N classi Java, una per ogni vincolo
 - caricare queste classi nel porprio IDE Java, assicurarsi di avere disponibili sia la libreria JSetL
   che JUnit, e a questo punto dare il comando "run as JUnit Test"
