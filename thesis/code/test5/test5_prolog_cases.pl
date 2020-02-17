:- style_check(-singleton).

test(Op,C,Arg1,Arg2) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(false),nl.
test(Op,C,Arg1,Arg2,Arg3) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2,Arg3) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(false),nl.


:- tell('test5/test5_test_cases_specs.txt').

:- test(diff,diff({A1/B1}, {A2/B2}, {A3/B3}),aperto, aperto, aperto).
:- test(diff,diff({A1/B1}, {A2/B2}, {X3,Y3}),aperto, aperto, chiuso).
:- test(diff,diff({A1/B1}, {A2/B2}, S3),aperto, aperto, var).
:- test(diff,diff({A1/B1}, {A2/B2}, {}),aperto, aperto, vuoto).
:- test(diff,diff({A1/B1}, {X2,Y2}, {A3/B3}),aperto, chiuso, aperto).
:- test(diff,diff({A1/B1}, {X2,Y2}, {X3,Y3}),aperto, chiuso, chiuso).
:- test(diff,diff({A1/B1}, {X2,Y2}, S3),aperto, chiuso, var).
:- test(diff,diff({A1/B1}, {X2,Y2}, {}),aperto, chiuso, vuoto).
:- test(diff,diff({A1/B1}, S2, {A3/B3}),aperto, var, aperto).
:- test(diff,diff({A1/B1}, S2, {X3,Y3}),aperto, var, chiuso).
:- test(diff,diff({A1/B1}, S2, S3),aperto, var, var).
:- test(diff,diff({A1/B1}, S2, {}),aperto, var, vuoto).
:- test(diff,diff({A1/B1}, {}, {A3/B3}),aperto, vuoto, aperto).
:- test(diff,diff({A1/B1}, {}, {X3,Y3}),aperto, vuoto, chiuso).
:- test(diff,diff({A1/B1}, {}, S3),aperto, vuoto, var).
:- test(diff,diff({A1/B1}, {}, {}),aperto, vuoto, vuoto).
:- test(diff,diff({X1,Y1}, {A2/B2}, {A3/B3}),chiuso, aperto, aperto).
:- test(diff,diff({X1,Y1}, {A2/B2}, {X3,Y3}),chiuso, aperto, chiuso).
:- test(diff,diff({X1,Y1}, {A2/B2}, S3),chiuso, aperto, var).
:- test(diff,diff({X1,Y1}, {A2/B2}, {}),chiuso, aperto, vuoto).
:- test(diff,diff({X1,Y1}, {X2,Y2}, {A3/B3}),chiuso, chiuso, aperto).
:- test(diff,diff({X1,Y1}, {X2,Y2}, {X3,Y3}),chiuso, chiuso, chiuso).
:- test(diff,diff({X1,Y1}, {X2,Y2}, S3),chiuso, chiuso, var).
:- test(diff,diff({X1,Y1}, {X2,Y2}, {}),chiuso, chiuso, vuoto).
:- test(diff,diff({X1,Y1}, S2, {A3/B3}),chiuso, var, aperto).
:- test(diff,diff({X1,Y1}, S2, {X3,Y3}),chiuso, var, chiuso).
:- test(diff,diff({X1,Y1}, S2, S3),chiuso, var, var).
:- test(diff,diff({X1,Y1}, S2, {}),chiuso, var, vuoto).
:- test(diff,diff({X1,Y1}, {}, {A3/B3}),chiuso, vuoto, aperto).
:- test(diff,diff({X1,Y1}, {}, {X3,Y3}),chiuso, vuoto, chiuso).
:- test(diff,diff({X1,Y1}, {}, S3),chiuso, vuoto, var).
:- test(diff,diff({X1,Y1}, {}, {}),chiuso, vuoto, vuoto).
:- test(diff,diff(S1, {A2/B2}, {A3/B3}),var, aperto, aperto).
:- test(diff,diff(S1, {A2/B2}, {X3,Y3}),var, aperto, chiuso).
:- test(diff,diff(S1, {A2/B2}, S3),var, aperto, var).
:- test(diff,diff(S1, {A2/B2}, {}),var, aperto, vuoto).
:- test(diff,diff(S1, {X2,Y2}, {A3/B3}),var, chiuso, aperto).
:- test(diff,diff(S1, {X2,Y2}, {X3,Y3}),var, chiuso, chiuso).
:- test(diff,diff(S1, {X2,Y2}, S3),var, chiuso, var).
:- test(diff,diff(S1, {X2,Y2}, {}),var, chiuso, vuoto).
:- test(diff,diff(S1, S2, {A3/B3}),var, var, aperto).
:- test(diff,diff(S1, S2, {X3,Y3}),var, var, chiuso).
:- test(diff,diff(S1, S2, S3),var, var, var).
:- test(diff,diff(S1, S2, {}),var, var, vuoto).
:- test(diff,diff(S1, {}, {A3/B3}),var, vuoto, aperto).
:- test(diff,diff(S1, {}, {X3,Y3}),var, vuoto, chiuso).
:- test(diff,diff(S1, {}, S3),var, vuoto, var).
:- test(diff,diff(S1, {}, {}),var, vuoto, vuoto).
:- test(diff,diff({}, {A2/B2}, {A3/B3}),vuoto, aperto, aperto).
:- test(diff,diff({}, {A2/B2}, {X3,Y3}),vuoto, aperto, chiuso).
:- test(diff,diff({}, {A2/B2}, S3),vuoto, aperto, var).
:- test(diff,diff({}, {A2/B2}, {}),vuoto, aperto, vuoto).
:- test(diff,diff({}, {X2,Y2}, {A3/B3}),vuoto, chiuso, aperto).
:- test(diff,diff({}, {X2,Y2}, {X3,Y3}),vuoto, chiuso, chiuso).
:- test(diff,diff({}, {X2,Y2}, S3),vuoto, chiuso, var).
:- test(diff,diff({}, {X2,Y2}, {}),vuoto, chiuso, vuoto).
:- test(diff,diff({}, S2, {A3/B3}),vuoto, var, aperto).
:- test(diff,diff({}, S2, {X3,Y3}),vuoto, var, chiuso).
:- test(diff,diff({}, S2, S3),vuoto, var, var).
:- test(diff,diff({}, S2, {}),vuoto, var, vuoto).
:- test(diff,diff({}, {}, {A3/B3}),vuoto, vuoto, aperto).
:- test(diff,diff({}, {}, {X3,Y3}),vuoto, vuoto, chiuso).
:- test(diff,diff({}, {}, S3),vuoto, vuoto, var).
:- test(diff,diff({}, {}, {}),vuoto, vuoto, vuoto).

:- test(inters,inters({A1/B1}, {A2/B2}, {A3/B3}),aperto, aperto, aperto).
:- test(inters,inters({A1/B1}, {A2/B2}, {X3,Y3}),aperto, aperto, chiuso).
:- test(inters,inters({A1/B1}, {A2/B2}, S3),aperto, aperto, var).
:- test(inters,inters({A1/B1}, {A2/B2}, {}),aperto, aperto, vuoto).
:- test(inters,inters({A1/B1}, {X2,Y2}, {A3/B3}),aperto, chiuso, aperto).
:- test(inters,inters({A1/B1}, {X2,Y2}, {X3,Y3}),aperto, chiuso, chiuso).
:- test(inters,inters({A1/B1}, {X2,Y2}, S3),aperto, chiuso, var).
:- test(inters,inters({A1/B1}, {X2,Y2}, {}),aperto, chiuso, vuoto).
:- test(inters,inters({A1/B1}, S2, {A3/B3}),aperto, var, aperto).
:- test(inters,inters({A1/B1}, S2, {X3,Y3}),aperto, var, chiuso).
:- test(inters,inters({A1/B1}, S2, S3),aperto, var, var).
:- test(inters,inters({A1/B1}, S2, {}),aperto, var, vuoto).
:- test(inters,inters({A1/B1}, {}, {A3/B3}),aperto, vuoto, aperto).
:- test(inters,inters({A1/B1}, {}, {X3,Y3}),aperto, vuoto, chiuso).
:- test(inters,inters({A1/B1}, {}, S3),aperto, vuoto, var).
:- test(inters,inters({A1/B1}, {}, {}),aperto, vuoto, vuoto).
:- test(inters,inters({X1,Y1}, {A2/B2}, {A3/B3}),chiuso, aperto, aperto).
:- test(inters,inters({X1,Y1}, {A2/B2}, {X3,Y3}),chiuso, aperto, chiuso).
:- test(inters,inters({X1,Y1}, {A2/B2}, S3),chiuso, aperto, var).
:- test(inters,inters({X1,Y1}, {A2/B2}, {}),chiuso, aperto, vuoto).
:- test(inters,inters({X1,Y1}, {X2,Y2}, {A3/B3}),chiuso, chiuso, aperto).
:- test(inters,inters({X1,Y1}, {X2,Y2}, {X3,Y3}),chiuso, chiuso, chiuso).
:- test(inters,inters({X1,Y1}, {X2,Y2}, S3),chiuso, chiuso, var).
:- test(inters,inters({X1,Y1}, {X2,Y2}, {}),chiuso, chiuso, vuoto).
:- test(inters,inters({X1,Y1}, S2, {A3/B3}),chiuso, var, aperto).
:- test(inters,inters({X1,Y1}, S2, {X3,Y3}),chiuso, var, chiuso).
:- test(inters,inters({X1,Y1}, S2, S3),chiuso, var, var).
:- test(inters,inters({X1,Y1}, S2, {}),chiuso, var, vuoto).
:- test(inters,inters({X1,Y1}, {}, {A3/B3}),chiuso, vuoto, aperto).
:- test(inters,inters({X1,Y1}, {}, {X3,Y3}),chiuso, vuoto, chiuso).
:- test(inters,inters({X1,Y1}, {}, S3),chiuso, vuoto, var).
:- test(inters,inters({X1,Y1}, {}, {}),chiuso, vuoto, vuoto).
:- test(inters,inters(S1, {A2/B2}, {A3/B3}),var, aperto, aperto).
:- test(inters,inters(S1, {A2/B2}, {X3,Y3}),var, aperto, chiuso).
:- test(inters,inters(S1, {A2/B2}, S3),var, aperto, var).
:- test(inters,inters(S1, {A2/B2}, {}),var, aperto, vuoto).
:- test(inters,inters(S1, {X2,Y2}, {A3/B3}),var, chiuso, aperto).
:- test(inters,inters(S1, {X2,Y2}, {X3,Y3}),var, chiuso, chiuso).
:- test(inters,inters(S1, {X2,Y2}, S3),var, chiuso, var).
:- test(inters,inters(S1, {X2,Y2}, {}),var, chiuso, vuoto).
:- test(inters,inters(S1, S2, {A3/B3}),var, var, aperto).
:- test(inters,inters(S1, S2, {X3,Y3}),var, var, chiuso).
:- test(inters,inters(S1, S2, S3),var, var, var).
:- test(inters,inters(S1, S2, {}),var, var, vuoto).
:- test(inters,inters(S1, {}, {A3/B3}),var, vuoto, aperto).
:- test(inters,inters(S1, {}, {X3,Y3}),var, vuoto, chiuso).
:- test(inters,inters(S1, {}, S3),var, vuoto, var).
:- test(inters,inters(S1, {}, {}),var, vuoto, vuoto).
:- test(inters,inters({}, {A2/B2}, {A3/B3}),vuoto, aperto, aperto).
:- test(inters,inters({}, {A2/B2}, {X3,Y3}),vuoto, aperto, chiuso).
:- test(inters,inters({}, {A2/B2}, S3),vuoto, aperto, var).
:- test(inters,inters({}, {A2/B2}, {}),vuoto, aperto, vuoto).
:- test(inters,inters({}, {X2,Y2}, {A3/B3}),vuoto, chiuso, aperto).
:- test(inters,inters({}, {X2,Y2}, {X3,Y3}),vuoto, chiuso, chiuso).
:- test(inters,inters({}, {X2,Y2}, S3),vuoto, chiuso, var).
:- test(inters,inters({}, {X2,Y2}, {}),vuoto, chiuso, vuoto).
:- test(inters,inters({}, S2, {A3/B3}),vuoto, var, aperto).
:- test(inters,inters({}, S2, {X3,Y3}),vuoto, var, chiuso).
:- test(inters,inters({}, S2, S3),vuoto, var, var).
:- test(inters,inters({}, S2, {}),vuoto, var, vuoto).
:- test(inters,inters({}, {}, {A3/B3}),vuoto, vuoto, aperto).
:- test(inters,inters({}, {}, {X3,Y3}),vuoto, vuoto, chiuso).
:- test(inters,inters({}, {}, S3),vuoto, vuoto, var).
:- test(inters,inters({}, {}, {}),vuoto, vuoto, vuoto).

:- test(subset,subset({A1/B1}, {A2/B2}),aperto, aperto).
:- test(subset,subset({A1/B1}, {X2,Y2}),aperto, chiuso).
:- test(subset,subset({A1/B1}, S2),aperto, var).
:- test(subset,subset({A1/B1}, {}),aperto, vuoto).
:- test(subset,subset({X1,Y1}, {A2/B2}),chiuso, aperto).
:- test(subset,subset({X1,Y1}, {X2,Y2}),chiuso, chiuso).
:- test(subset,subset({X1,Y1}, S2),chiuso, var).
:- test(subset,subset({X1,Y1}, {}),chiuso, vuoto).
:- test(subset,subset(S1, {A2/B2}),var, aperto).
:- test(subset,subset(S1, {X2,Y2}),var, chiuso).
:- test(subset,subset(S1, S2),var, var).
:- test(subset,subset(S1, {}),var, vuoto).
:- test(subset,subset({}, {A2/B2}),vuoto, aperto).
:- test(subset,subset({}, {X2,Y2}),vuoto, chiuso).
:- test(subset,subset({}, S2),vuoto, var).
:- test(subset,subset({}, {}),vuoto, vuoto).


:- told.

:- halt.