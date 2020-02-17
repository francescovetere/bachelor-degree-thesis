:- style_check(-singleton).

test(Op,C,Arg1,Arg2) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(false),nl.


:- tell('test3/test3_test_cases_specs.txt').

:- test(in,3 in {A/B},lVarBound,aperto).
:- test(in,3 in {A,B},lVarBound,chiuso).
:- test(in,3 in X,lVarBound,var).
:- test(in,3 in {},lVarBound,vuoto).
:- test(in,LVNB in {A/B},lVarNotBound,aperto).
:- test(in,LVNB in {A,B},lVarNotBound,chiuso).
:- test(in,LVNB in X,lVarNotBound,var).
:- test(in,LVNB in {},lVarNotBound,vuoto).

:- test(nin,3 nin {A/B},lVarBound,aperto).
:- test(nin,3 nin {A,B},lVarBound,chiuso).
:- test(nin,3 nin X,lVarBound,var).
:- test(nin,3 nin {},lVarBound,vuoto).
:- test(nin,LVNB nin {A/B},lVarNotBound,aperto).
:- test(nin,LVNB nin {A,B},lVarNotBound,chiuso).
:- test(nin,LVNB nin X,lVarNotBound,var).
:- test(nin,LVNB nin {},lVarNotBound,vuoto).


:- told.

:- halt.