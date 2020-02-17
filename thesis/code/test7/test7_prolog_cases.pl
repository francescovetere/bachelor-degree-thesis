:- style_check(-singleton).

test(Op,C,Arg1,Arg2) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(false),nl.


:- tell('test7/test7_test_cases_specs.txt').

:- test(size,size({A/B}, 1),aperto, lVarBound1).
:- test(size,size({A/B}, 2),aperto, lVarBound2).
:- test(size,size({A/B}, 3),aperto, lVarBound3).
:- test(size,size({A/B}, N),aperto, lVarNotBound).
:- test(size,size({A,B}, 1),chiuso, lVarBound1).
:- test(size,size({A,B}, 2),chiuso, lVarBound2).
:- test(size,size({A,B}, 3),chiuso, lVarBound3).
:- test(size,size({A,B}, N),chiuso, lVarNotBound).
:- test(size,size(X, 1),var, lVarBound1).
:- test(size,size(X, 2),var, lVarBound2).
:- test(size,size(X, 3),var, lVarBound3).
:- test(size,size(X, N),var, lVarNotBound).
:- test(size,size({}, 1),vuoto, lVarBound1).
:- test(size,size({}, 2),vuoto, lVarBound2).
:- test(size,size({}, 3),vuoto, lVarBound3).
:- test(size,size({}, N),vuoto, lVarNotBound).


:- told.

:- halt.