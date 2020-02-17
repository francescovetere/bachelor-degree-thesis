:- style_check(-singleton).

test(Op,C,Arg1,Arg2) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(false),nl.
test(Op,C,Arg1,Arg2,Arg3) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2,Arg3) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(false),nl.


:- tell('test3/test3_test_cases_specs.txt').

:- test(eq,{A} = {X/A},chiuso,aperto1).
:- test(eq,{A} = {A/R},chiuso,aperto2).
:- test(eq,{A} = {A,A},chiuso,chiuso).
:- test(eq,{A} = B,chiuso,var).
:- test(eq,A = {X/A},var,aperto1).
:- test(eq,A = {A/R},var,aperto2).
:- test(eq,A = {A,A},var,chiuso).
:- test(eq,A = B,var,var).

:- test(disj,disj({A}, {X/A}),chiuso, aperto1).
:- test(disj,disj({A}, {A/R}),chiuso, aperto2).
:- test(disj,disj({A}, {A,A}),chiuso, chiuso).
:- test(disj,disj({A}, B),chiuso, var).
:- test(disj,disj(A, {X/A}),var, aperto1).
:- test(disj,disj(A, {A/R}),var, aperto2).
:- test(disj,disj(A, {A,A}),var, chiuso).
:- test(disj,disj(A, B),var, var).

:- test(union,un({A}, {X/A}, {A,B,C}),chiuso, aperto1, chiuso).
:- test(union,un({A}, {X/A}, B),chiuso, aperto1, var).
:- test(union,un({A}, {A/R}, {A,B,C}),chiuso, aperto2, chiuso).
:- test(union,un({A}, {A/R}, B),chiuso, aperto2, var).
:- test(union,un({A}, {A,A}, {A,B,C}),chiuso, chiuso, chiuso).
:- test(union,un({A}, {A,A}, B),chiuso, chiuso, var).
:- test(union,un({A}, B, {A,B,C}),chiuso, var, chiuso).
:- test(union,un({A}, B, B),chiuso, var, var).
:- test(union,un(A, {X/A}, {A,B,C}),var, aperto1, chiuso).
:- test(union,un(A, {X/A}, B),var, aperto1, var).
:- test(union,un(A, {A/R}, {A,B,C}),var, aperto2, chiuso).
:- test(union,un(A, {A/R}, B),var, aperto2, var).
:- test(union,un(A, {A,A}, {A,B,C}),var, chiuso, chiuso).
:- test(union,un(A, {A,A}, B),var, chiuso, var).
:- test(union,un(A, B, {A,B,C}),var, var, chiuso).
:- test(union,un(A, B, B),var, var, var).


:- told.

:- halt.