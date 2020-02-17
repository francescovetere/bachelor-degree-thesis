:- style_check(-singleton).

test(Op,C,Arg1,Arg2) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(false),nl.
test(Op,C,Arg1,Arg2,Arg3) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2,Arg3) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(false),nl.
test(Op,C,Arg1,Arg2,Arg3,Arg4) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(Arg4),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2,Arg3,Arg4) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(Arg4),write(' '),write(false),nl.
test(Op,C,Arg1,Arg2,Arg3,Arg4,Arg5) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(Arg4),write(' '),write(Arg5),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2,Arg3,Arg4,Arg5) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(Arg4),write(' '),write(Arg5),write(' '),write(false),nl.


:- tell('test9/test9_test_cases_specs.txt').

:- setlog_clause(myRis(ControlTerm, Domain, Filter, Pattern, InsiemeDaUnificare) :- InsiemeDaUnificare = ris(ControlTerm in Domain, Filter, Pattern)).

:- test(myRis,myRis(LV1, {X2,Y2}, LV1 = 4, LV1, {X3,Y3}),lvar, chiuso, filtroCustom, pattern1, chiuso).
:- test(myRis,myRis(LV1, {X2,Y2}, LV1 = 4, LV1, {}),lvar, chiuso, filtroCustom, pattern1, vuoto).
:- test(myRis,myRis(LV1, {X2,Y2}, false, LV1, {X3,Y3}),lvar, chiuso, filtroFalse, pattern1, chiuso).
:- test(myRis,myRis(LV1, {X2,Y2}, false, LV1, {}),lvar, chiuso, filtroFalse, pattern1, vuoto).
:- test(myRis,myRis(LV1, {X2,Y2}, true, LV1, {X3,Y3}),lvar, chiuso, filtroTrue, pattern1, chiuso).
:- test(myRis,myRis(LV1, {X2,Y2}, true, LV1, {}),lvar, chiuso, filtroTrue, pattern1, vuoto).
:- test(myRis,myRis(LV1, {}, LV1 = 4, LV1, {X3,Y3}),lvar, vuoto, filtroCustom, pattern1, chiuso).
:- test(myRis,myRis(LV1, {}, LV1 = 4, LV1, {}),lvar, vuoto, filtroCustom, pattern1, vuoto).
:- test(myRis,myRis(LV1, {}, false, LV1, {X3,Y3}),lvar, vuoto, filtroFalse, pattern1, chiuso).
:- test(myRis,myRis(LV1, {}, false, LV1, {}),lvar, vuoto, filtroFalse, pattern1, vuoto).
:- test(myRis,myRis(LV1, {}, true, LV1, {X3,Y3}),lvar, vuoto, filtroTrue, pattern1, chiuso).
:- test(myRis,myRis(LV1, {}, true, LV1, {}),lvar, vuoto, filtroTrue, pattern1, vuoto).


:- told.

:- halt.