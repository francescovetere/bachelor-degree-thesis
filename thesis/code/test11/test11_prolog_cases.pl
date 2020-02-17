:- style_check(-singleton).

test(Op,C,Arg1,Arg2) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(false),nl.
test(Op,C,Arg1,Arg2,Arg3) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2,Arg3) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(false),nl.


:- tell('test11/test11_test_cases_specs.txt').

:- test(eq,{A1/B1} = {A2/B2},aperto,aperto).
:- test(eq,{A1/B1} = {X2,Y2},aperto,chiusoPiccoloNonGround).
:- test(eq,{A1/B1} = S2,aperto,var).
:- test(eq,{A1/B1} = {},aperto,vuoto).
:- test(eq,{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19} = {A2/B2},chiusoGrossoGround,aperto).
:- test(eq,{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19} = {X2,Y2},chiusoGrossoGround,chiusoPiccoloNonGround).
:- test(eq,{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19} = S2,chiusoGrossoGround,var).
:- test(eq,{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19} = {},chiusoGrossoGround,vuoto).
:- test(eq,S1 = {A2/B2},var,aperto).
:- test(eq,S1 = {X2,Y2},var,chiusoPiccoloNonGround).
:- test(eq,S1 = S2,var,var).
:- test(eq,S1 = {},var,vuoto).
:- test(eq,{} = {A2/B2},vuoto,aperto).
:- test(eq,{} = {X2,Y2},vuoto,chiusoPiccoloNonGround).
:- test(eq,{} = S2,vuoto,var).
:- test(eq,{} = {},vuoto,vuoto).

:- test(neq,{A1/B1} neq {A2/B2},aperto,aperto).
:- test(neq,{A1/B1} neq {X2,Y2},aperto,chiusoPiccoloNonGround).
:- test(neq,{A1/B1} neq S2,aperto,var).
:- test(neq,{A1/B1} neq {},aperto,vuoto).
:- test(neq,{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19} neq {A2/B2},chiusoGrossoGround,aperto).
:- test(neq,{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19} neq {X2,Y2},chiusoGrossoGround,chiusoPiccoloNonGround).
:- test(neq,{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19} neq S2,chiusoGrossoGround,var).
:- test(neq,{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19} neq {},chiusoGrossoGround,vuoto).
:- test(neq,S1 neq {A2/B2},var,aperto).
:- test(neq,S1 neq {X2,Y2},var,chiusoPiccoloNonGround).
:- test(neq,S1 neq S2,var,var).
:- test(neq,S1 neq {},var,vuoto).
:- test(neq,{} neq {A2/B2},vuoto,aperto).
:- test(neq,{} neq {X2,Y2},vuoto,chiusoPiccoloNonGround).
:- test(neq,{} neq S2,vuoto,var).
:- test(neq,{} neq {},vuoto,vuoto).

:- test(disj,disj({A1/B1}, {A2/B2}),aperto, aperto).
:- test(disj,disj({A1/B1}, {X2,Y2}),aperto, chiusoPiccoloNonGround).
:- test(disj,disj({A1/B1}, S2),aperto, var).
:- test(disj,disj({A1/B1}, {}),aperto, vuoto).
:- test(disj,disj({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, {A2/B2}),chiusoGrossoGround, aperto).
:- test(disj,disj({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, {X2,Y2}),chiusoGrossoGround, chiusoPiccoloNonGround).
:- test(disj,disj({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, S2),chiusoGrossoGround, var).
:- test(disj,disj({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, {}),chiusoGrossoGround, vuoto).
:- test(disj,disj(S1, {A2/B2}),var, aperto).
:- test(disj,disj(S1, {X2,Y2}),var, chiusoPiccoloNonGround).
:- test(disj,disj(S1, S2),var, var).
:- test(disj,disj(S1, {}),var, vuoto).
:- test(disj,disj({}, {A2/B2}),vuoto, aperto).
:- test(disj,disj({}, {X2,Y2}),vuoto, chiusoPiccoloNonGround).
:- test(disj,disj({}, S2),vuoto, var).
:- test(disj,disj({}, {}),vuoto, vuoto).

:- test(union,un({A1/B1}, {A2/B2}, {A3/B3}),aperto, aperto, aperto).
:- test(union,un({A1/B1}, {A2/B2}, {X3,Y3}),aperto, aperto, chiusoPiccoloNonGround).
:- test(union,un({A1/B1}, {A2/B2}, S3),aperto, aperto, var).
:- test(union,un({A1/B1}, {A2/B2}, {}),aperto, aperto, vuoto).
:- test(union,un({A1/B1}, {X2,Y2}, {A3/B3}),aperto, chiusoPiccoloNonGround, aperto).
:- test(union,un({A1/B1}, {X2,Y2}, {X3,Y3}),aperto, chiusoPiccoloNonGround, chiusoPiccoloNonGround).
:- test(union,un({A1/B1}, {X2,Y2}, S3),aperto, chiusoPiccoloNonGround, var).
:- test(union,un({A1/B1}, {X2,Y2}, {}),aperto, chiusoPiccoloNonGround, vuoto).
:- test(union,un({A1/B1}, S2, {A3/B3}),aperto, var, aperto).
:- test(union,un({A1/B1}, S2, {X3,Y3}),aperto, var, chiusoPiccoloNonGround).
:- test(union,un({A1/B1}, S2, S3),aperto, var, var).
:- test(union,un({A1/B1}, S2, {}),aperto, var, vuoto).
:- test(union,un({A1/B1}, {}, {A3/B3}),aperto, vuoto, aperto).
:- test(union,un({A1/B1}, {}, {X3,Y3}),aperto, vuoto, chiusoPiccoloNonGround).
:- test(union,un({A1/B1}, {}, S3),aperto, vuoto, var).
:- test(union,un({A1/B1}, {}, {}),aperto, vuoto, vuoto).
:- test(union,un({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, {A2/B2}, {A3/B3}),chiusoGrossoGround, aperto, aperto).
:- test(union,un({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, {A2/B2}, {X3,Y3}),chiusoGrossoGround, aperto, chiusoPiccoloNonGround).
:- test(union,un({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, {A2/B2}, S3),chiusoGrossoGround, aperto, var).
:- test(union,un({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, {A2/B2}, {}),chiusoGrossoGround, aperto, vuoto).
:- test(union,un({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, {X2,Y2}, {A3/B3}),chiusoGrossoGround, chiusoPiccoloNonGround, aperto).
:- test(union,un({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, {X2,Y2}, {X3,Y3}),chiusoGrossoGround, chiusoPiccoloNonGround, chiusoPiccoloNonGround).
:- test(union,un({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, {X2,Y2}, S3),chiusoGrossoGround, chiusoPiccoloNonGround, var).
:- test(union,un({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, {X2,Y2}, {}),chiusoGrossoGround, chiusoPiccoloNonGround, vuoto).
:- test(union,un({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, S2, {A3/B3}),chiusoGrossoGround, var, aperto).
:- test(union,un({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, S2, {X3,Y3}),chiusoGrossoGround, var, chiusoPiccoloNonGround).
:- test(union,un({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, S2, S3),chiusoGrossoGround, var, var).
:- test(union,un({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, S2, {}),chiusoGrossoGround, var, vuoto).
:- test(union,un({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, {}, {A3/B3}),chiusoGrossoGround, vuoto, aperto).
:- test(union,un({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, {}, {X3,Y3}),chiusoGrossoGround, vuoto, chiusoPiccoloNonGround).
:- test(union,un({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, {}, S3),chiusoGrossoGround, vuoto, var).
:- test(union,un({0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, {}, {}),chiusoGrossoGround, vuoto, vuoto).
:- test(union,un(S1, {A2/B2}, {A3/B3}),var, aperto, aperto).
:- test(union,un(S1, {A2/B2}, {X3,Y3}),var, aperto, chiusoPiccoloNonGround).
:- test(union,un(S1, {A2/B2}, S3),var, aperto, var).
:- test(union,un(S1, {A2/B2}, {}),var, aperto, vuoto).
:- test(union,un(S1, {X2,Y2}, {A3/B3}),var, chiusoPiccoloNonGround, aperto).
:- test(union,un(S1, {X2,Y2}, {X3,Y3}),var, chiusoPiccoloNonGround, chiusoPiccoloNonGround).
:- test(union,un(S1, {X2,Y2}, S3),var, chiusoPiccoloNonGround, var).
:- test(union,un(S1, {X2,Y2}, {}),var, chiusoPiccoloNonGround, vuoto).
:- test(union,un(S1, S2, {A3/B3}),var, var, aperto).
:- test(union,un(S1, S2, {X3,Y3}),var, var, chiusoPiccoloNonGround).
:- test(union,un(S1, S2, S3),var, var, var).
:- test(union,un(S1, S2, {}),var, var, vuoto).
:- test(union,un(S1, {}, {A3/B3}),var, vuoto, aperto).
:- test(union,un(S1, {}, {X3,Y3}),var, vuoto, chiusoPiccoloNonGround).
:- test(union,un(S1, {}, S3),var, vuoto, var).
:- test(union,un(S1, {}, {}),var, vuoto, vuoto).
:- test(union,un({}, {A2/B2}, {A3/B3}),vuoto, aperto, aperto).
:- test(union,un({}, {A2/B2}, {X3,Y3}),vuoto, aperto, chiusoPiccoloNonGround).
:- test(union,un({}, {A2/B2}, S3),vuoto, aperto, var).
:- test(union,un({}, {A2/B2}, {}),vuoto, aperto, vuoto).
:- test(union,un({}, {X2,Y2}, {A3/B3}),vuoto, chiusoPiccoloNonGround, aperto).
:- test(union,un({}, {X2,Y2}, {X3,Y3}),vuoto, chiusoPiccoloNonGround, chiusoPiccoloNonGround).
:- test(union,un({}, {X2,Y2}, S3),vuoto, chiusoPiccoloNonGround, var).
:- test(union,un({}, {X2,Y2}, {}),vuoto, chiusoPiccoloNonGround, vuoto).
:- test(union,un({}, S2, {A3/B3}),vuoto, var, aperto).
:- test(union,un({}, S2, {X3,Y3}),vuoto, var, chiusoPiccoloNonGround).
:- test(union,un({}, S2, S3),vuoto, var, var).
:- test(union,un({}, S2, {}),vuoto, var, vuoto).
:- test(union,un({}, {}, {A3/B3}),vuoto, vuoto, aperto).
:- test(union,un({}, {}, {X3,Y3}),vuoto, vuoto, chiusoPiccoloNonGround).
:- test(union,un({}, {}, S3),vuoto, vuoto, var).
:- test(union,un({}, {}, {}),vuoto, vuoto, vuoto).


:- told.

:- halt.
