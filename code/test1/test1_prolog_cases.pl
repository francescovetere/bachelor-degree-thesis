:- style_check(-singleton).

test(Op,C,Arg1,Arg2) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(false),nl.
test(Op,C,Arg1,Arg2,Arg3) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2,Arg3) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(false),nl.


:- tell('test1/test1_test_cases_specs.txt').

:- test(eq,{A1/B1} = {A2/B2},aperto,aperto).
:- test(eq,{A1/B1} = {X2,Y2},aperto,chiuso).
:- test(eq,{A1/B1} = S2,aperto,var).
:- test(eq,{A1/B1} = {},aperto,vuoto).
:- test(eq,{X1,Y1} = {A2/B2},chiuso,aperto).
:- test(eq,{X1,Y1} = {X2,Y2},chiuso,chiuso).
:- test(eq,{X1,Y1} = S2,chiuso,var).
:- test(eq,{X1,Y1} = {},chiuso,vuoto).
:- test(eq,S1 = {A2/B2},var,aperto).
:- test(eq,S1 = {X2,Y2},var,chiuso).
:- test(eq,S1 = S2,var,var).
:- test(eq,S1 = {},var,vuoto).
:- test(eq,{} = {A2/B2},vuoto,aperto).
:- test(eq,{} = {X2,Y2},vuoto,chiuso).
:- test(eq,{} = S2,vuoto,var).
:- test(eq,{} = {},vuoto,vuoto).

:- test(disj,disj({A1/B1}, {A2/B2}),aperto, aperto).
:- test(disj,disj({A1/B1}, {X2,Y2}),aperto, chiuso).
:- test(disj,disj({A1/B1}, S2),aperto, var).
:- test(disj,disj({A1/B1}, {}),aperto, vuoto).
:- test(disj,disj({X1,Y1}, {A2/B2}),chiuso, aperto).
:- test(disj,disj({X1,Y1}, {X2,Y2}),chiuso, chiuso).
:- test(disj,disj({X1,Y1}, S2),chiuso, var).
:- test(disj,disj({X1,Y1}, {}),chiuso, vuoto).
:- test(disj,disj(S1, {A2/B2}),var, aperto).
:- test(disj,disj(S1, {X2,Y2}),var, chiuso).
:- test(disj,disj(S1, S2),var, var).
:- test(disj,disj(S1, {}),var, vuoto).
:- test(disj,disj({}, {A2/B2}),vuoto, aperto).
:- test(disj,disj({}, {X2,Y2}),vuoto, chiuso).
:- test(disj,disj({}, S2),vuoto, var).
:- test(disj,disj({}, {}),vuoto, vuoto).

:- test(union,un({A1/B1}, {A2/B2}, {A3/B3}),aperto, aperto, aperto).
:- test(union,un({A1/B1}, {A2/B2}, {X3,Y3}),aperto, aperto, chiuso).
:- test(union,un({A1/B1}, {A2/B2}, S3),aperto, aperto, var).
:- test(union,un({A1/B1}, {A2/B2}, {}),aperto, aperto, vuoto).
:- test(union,un({A1/B1}, {X2,Y2}, {A3/B3}),aperto, chiuso, aperto).
:- test(union,un({A1/B1}, {X2,Y2}, {X3,Y3}),aperto, chiuso, chiuso).
:- test(union,un({A1/B1}, {X2,Y2}, S3),aperto, chiuso, var).
:- test(union,un({A1/B1}, {X2,Y2}, {}),aperto, chiuso, vuoto).
:- test(union,un({A1/B1}, S2, {A3/B3}),aperto, var, aperto).
:- test(union,un({A1/B1}, S2, {X3,Y3}),aperto, var, chiuso).
:- test(union,un({A1/B1}, S2, S3),aperto, var, var).
:- test(union,un({A1/B1}, S2, {}),aperto, var, vuoto).
:- test(union,un({A1/B1}, {}, {A3/B3}),aperto, vuoto, aperto).
:- test(union,un({A1/B1}, {}, {X3,Y3}),aperto, vuoto, chiuso).
:- test(union,un({A1/B1}, {}, S3),aperto, vuoto, var).
:- test(union,un({A1/B1}, {}, {}),aperto, vuoto, vuoto).
:- test(union,un({X1,Y1}, {A2/B2}, {A3/B3}),chiuso, aperto, aperto).
:- test(union,un({X1,Y1}, {A2/B2}, {X3,Y3}),chiuso, aperto, chiuso).
:- test(union,un({X1,Y1}, {A2/B2}, S3),chiuso, aperto, var).
:- test(union,un({X1,Y1}, {A2/B2}, {}),chiuso, aperto, vuoto).
:- test(union,un({X1,Y1}, {X2,Y2}, {A3/B3}),chiuso, chiuso, aperto).
:- test(union,un({X1,Y1}, {X2,Y2}, {X3,Y3}),chiuso, chiuso, chiuso).
:- test(union,un({X1,Y1}, {X2,Y2}, S3),chiuso, chiuso, var).
:- test(union,un({X1,Y1}, {X2,Y2}, {}),chiuso, chiuso, vuoto).
:- test(union,un({X1,Y1}, S2, {A3/B3}),chiuso, var, aperto).
:- test(union,un({X1,Y1}, S2, {X3,Y3}),chiuso, var, chiuso).
:- test(union,un({X1,Y1}, S2, S3),chiuso, var, var).
:- test(union,un({X1,Y1}, S2, {}),chiuso, var, vuoto).
:- test(union,un({X1,Y1}, {}, {A3/B3}),chiuso, vuoto, aperto).
:- test(union,un({X1,Y1}, {}, {X3,Y3}),chiuso, vuoto, chiuso).
:- test(union,un({X1,Y1}, {}, S3),chiuso, vuoto, var).
:- test(union,un({X1,Y1}, {}, {}),chiuso, vuoto, vuoto).
:- test(union,un(S1, {A2/B2}, {A3/B3}),var, aperto, aperto).
:- test(union,un(S1, {A2/B2}, {X3,Y3}),var, aperto, chiuso).
:- test(union,un(S1, {A2/B2}, S3),var, aperto, var).
:- test(union,un(S1, {A2/B2}, {}),var, aperto, vuoto).
:- test(union,un(S1, {X2,Y2}, {A3/B3}),var, chiuso, aperto).
:- test(union,un(S1, {X2,Y2}, {X3,Y3}),var, chiuso, chiuso).
:- test(union,un(S1, {X2,Y2}, S3),var, chiuso, var).
:- test(union,un(S1, {X2,Y2}, {}),var, chiuso, vuoto).
:- test(union,un(S1, S2, {A3/B3}),var, var, aperto).
:- test(union,un(S1, S2, {X3,Y3}),var, var, chiuso).
:- test(union,un(S1, S2, S3),var, var, var).
:- test(union,un(S1, S2, {}),var, var, vuoto).
:- test(union,un(S1, {}, {A3/B3}),var, vuoto, aperto).
:- test(union,un(S1, {}, {X3,Y3}),var, vuoto, chiuso).
:- test(union,un(S1, {}, S3),var, vuoto, var).
:- test(union,un(S1, {}, {}),var, vuoto, vuoto).
:- test(union,un({}, {A2/B2}, {A3/B3}),vuoto, aperto, aperto).
:- test(union,un({}, {A2/B2}, {X3,Y3}),vuoto, aperto, chiuso).
:- test(union,un({}, {A2/B2}, S3),vuoto, aperto, var).
:- test(union,un({}, {A2/B2}, {}),vuoto, aperto, vuoto).
:- test(union,un({}, {X2,Y2}, {A3/B3}),vuoto, chiuso, aperto).
:- test(union,un({}, {X2,Y2}, {X3,Y3}),vuoto, chiuso, chiuso).
:- test(union,un({}, {X2,Y2}, S3),vuoto, chiuso, var).
:- test(union,un({}, {X2,Y2}, {}),vuoto, chiuso, vuoto).
:- test(union,un({}, S2, {A3/B3}),vuoto, var, aperto).
:- test(union,un({}, S2, {X3,Y3}),vuoto, var, chiuso).
:- test(union,un({}, S2, S3),vuoto, var, var).
:- test(union,un({}, S2, {}),vuoto, var, vuoto).
:- test(union,un({}, {}, {A3/B3}),vuoto, vuoto, aperto).
:- test(union,un({}, {}, {X3,Y3}),vuoto, vuoto, chiuso).
:- test(union,un({}, {}, S3),vuoto, vuoto, var).
:- test(union,un({}, {}, {}),vuoto, vuoto, vuoto).


:- told.

:- halt.