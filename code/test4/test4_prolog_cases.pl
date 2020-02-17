:- style_check(-singleton).

test(Op,C,Arg1,Arg2) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(false),nl.
test(Op,C,Arg1,Arg2,Arg3) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2,Arg3) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(false),nl.


:- tell('test4/test4_test_cases_specs.txt').

:- setlog_clause(myTest(A,B,C) :- un(A,B,C) & nun(A,B,C)).

:- test(myTest,myTest({A1/B1}, {A2/B2}, {A3/B3}),aperto, aperto, aperto).
:- test(myTest,myTest({A1/B1}, {A2/B2}, {X3,Y3}),aperto, aperto, chiuso).
:- test(myTest,myTest({A1/B1}, {A2/B2}, S3),aperto, aperto, var).
:- test(myTest,myTest({A1/B1}, {A2/B2}, {}),aperto, aperto, vuoto).
:- test(myTest,myTest({A1/B1}, {X2,Y2}, {A3/B3}),aperto, chiuso, aperto).
:- test(myTest,myTest({A1/B1}, {X2,Y2}, {X3,Y3}),aperto, chiuso, chiuso).
:- test(myTest,myTest({A1/B1}, {X2,Y2}, S3),aperto, chiuso, var).
:- test(myTest,myTest({A1/B1}, {X2,Y2}, {}),aperto, chiuso, vuoto).
:- test(myTest,myTest({A1/B1}, S2, {A3/B3}),aperto, var, aperto).
:- test(myTest,myTest({A1/B1}, S2, {X3,Y3}),aperto, var, chiuso).
:- test(myTest,myTest({A1/B1}, S2, S3),aperto, var, var).
:- test(myTest,myTest({A1/B1}, S2, {}),aperto, var, vuoto).
:- test(myTest,myTest({A1/B1}, {}, {A3/B3}),aperto, vuoto, aperto).
:- test(myTest,myTest({A1/B1}, {}, {X3,Y3}),aperto, vuoto, chiuso).
:- test(myTest,myTest({A1/B1}, {}, S3),aperto, vuoto, var).
:- test(myTest,myTest({A1/B1}, {}, {}),aperto, vuoto, vuoto).
:- test(myTest,myTest({X1,Y1}, {A2/B2}, {A3/B3}),chiuso, aperto, aperto).
:- test(myTest,myTest({X1,Y1}, {A2/B2}, {X3,Y3}),chiuso, aperto, chiuso).
:- test(myTest,myTest({X1,Y1}, {A2/B2}, S3),chiuso, aperto, var).
:- test(myTest,myTest({X1,Y1}, {A2/B2}, {}),chiuso, aperto, vuoto).
:- test(myTest,myTest({X1,Y1}, {X2,Y2}, {A3/B3}),chiuso, chiuso, aperto).
:- test(myTest,myTest({X1,Y1}, {X2,Y2}, {X3,Y3}),chiuso, chiuso, chiuso).
:- test(myTest,myTest({X1,Y1}, {X2,Y2}, S3),chiuso, chiuso, var).
:- test(myTest,myTest({X1,Y1}, {X2,Y2}, {}),chiuso, chiuso, vuoto).
:- test(myTest,myTest({X1,Y1}, S2, {A3/B3}),chiuso, var, aperto).
:- test(myTest,myTest({X1,Y1}, S2, {X3,Y3}),chiuso, var, chiuso).
:- test(myTest,myTest({X1,Y1}, S2, S3),chiuso, var, var).
:- test(myTest,myTest({X1,Y1}, S2, {}),chiuso, var, vuoto).
:- test(myTest,myTest({X1,Y1}, {}, {A3/B3}),chiuso, vuoto, aperto).
:- test(myTest,myTest({X1,Y1}, {}, {X3,Y3}),chiuso, vuoto, chiuso).
:- test(myTest,myTest({X1,Y1}, {}, S3),chiuso, vuoto, var).
:- test(myTest,myTest({X1,Y1}, {}, {}),chiuso, vuoto, vuoto).
:- test(myTest,myTest(S1, {A2/B2}, {A3/B3}),var, aperto, aperto).
:- test(myTest,myTest(S1, {A2/B2}, {X3,Y3}),var, aperto, chiuso).
:- test(myTest,myTest(S1, {A2/B2}, S3),var, aperto, var).
:- test(myTest,myTest(S1, {A2/B2}, {}),var, aperto, vuoto).
:- test(myTest,myTest(S1, {X2,Y2}, {A3/B3}),var, chiuso, aperto).
:- test(myTest,myTest(S1, {X2,Y2}, {X3,Y3}),var, chiuso, chiuso).
:- test(myTest,myTest(S1, {X2,Y2}, S3),var, chiuso, var).
:- test(myTest,myTest(S1, {X2,Y2}, {}),var, chiuso, vuoto).
:- test(myTest,myTest(S1, S2, {A3/B3}),var, var, aperto).
:- test(myTest,myTest(S1, S2, {X3,Y3}),var, var, chiuso).
:- test(myTest,myTest(S1, S2, S3),var, var, var).
:- test(myTest,myTest(S1, S2, {}),var, var, vuoto).
:- test(myTest,myTest(S1, {}, {A3/B3}),var, vuoto, aperto).
:- test(myTest,myTest(S1, {}, {X3,Y3}),var, vuoto, chiuso).
:- test(myTest,myTest(S1, {}, S3),var, vuoto, var).
:- test(myTest,myTest(S1, {}, {}),var, vuoto, vuoto).
:- test(myTest,myTest({}, {A2/B2}, {A3/B3}),vuoto, aperto, aperto).
:- test(myTest,myTest({}, {A2/B2}, {X3,Y3}),vuoto, aperto, chiuso).
:- test(myTest,myTest({}, {A2/B2}, S3),vuoto, aperto, var).
:- test(myTest,myTest({}, {A2/B2}, {}),vuoto, aperto, vuoto).
:- test(myTest,myTest({}, {X2,Y2}, {A3/B3}),vuoto, chiuso, aperto).
:- test(myTest,myTest({}, {X2,Y2}, {X3,Y3}),vuoto, chiuso, chiuso).
:- test(myTest,myTest({}, {X2,Y2}, S3),vuoto, chiuso, var).
:- test(myTest,myTest({}, {X2,Y2}, {}),vuoto, chiuso, vuoto).
:- test(myTest,myTest({}, S2, {A3/B3}),vuoto, var, aperto).
:- test(myTest,myTest({}, S2, {X3,Y3}),vuoto, var, chiuso).
:- test(myTest,myTest({}, S2, S3),vuoto, var, var).
:- test(myTest,myTest({}, S2, {}),vuoto, var, vuoto).
:- test(myTest,myTest({}, {}, {A3/B3}),vuoto, vuoto, aperto).
:- test(myTest,myTest({}, {}, {X3,Y3}),vuoto, vuoto, chiuso).
:- test(myTest,myTest({}, {}, S3),vuoto, vuoto, var).
:- test(myTest,myTest({}, {}, {}),vuoto, vuoto, vuoto).


:- told.

:- halt.