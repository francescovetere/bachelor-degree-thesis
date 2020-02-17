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


:- tell('test10/test10_test_cases_specs.txt').

:- setlog_clause(union4(A,B,C,D) :- un(A,B,C) & un(A,B,D)).

:- test(union4,union4({A1/B1}, {A2/B2}, {A3/B3}, {A4/B4}),aperto, aperto, aperto, aperto).
:- test(union4,union4({A1/B1}, {A2/B2}, {A3/B3}, {X4,Y4}),aperto, aperto, aperto, chiuso).
:- test(union4,union4({A1/B1}, {A2/B2}, {A3/B3}, S4),aperto, aperto, aperto, var).
:- test(union4,union4({A1/B1}, {A2/B2}, {A3/B3}, {}),aperto, aperto, aperto, vuoto).
:- test(union4,union4({A1/B1}, {A2/B2}, {X3,Y3}, {A4/B4}),aperto, aperto, chiuso, aperto).
:- test(union4,union4({A1/B1}, {A2/B2}, {X3,Y3}, {X4,Y4}),aperto, aperto, chiuso, chiuso).
:- test(union4,union4({A1/B1}, {A2/B2}, {X3,Y3}, S4),aperto, aperto, chiuso, var).
:- test(union4,union4({A1/B1}, {A2/B2}, {X3,Y3}, {}),aperto, aperto, chiuso, vuoto).
:- test(union4,union4({A1/B1}, {A2/B2}, S3, {A4/B4}),aperto, aperto, var, aperto).
:- test(union4,union4({A1/B1}, {A2/B2}, S3, {X4,Y4}),aperto, aperto, var, chiuso).
:- test(union4,union4({A1/B1}, {A2/B2}, S3, S4),aperto, aperto, var, var).
:- test(union4,union4({A1/B1}, {A2/B2}, S3, {}),aperto, aperto, var, vuoto).
:- test(union4,union4({A1/B1}, {A2/B2}, {}, {A4/B4}),aperto, aperto, vuoto, aperto).
:- test(union4,union4({A1/B1}, {A2/B2}, {}, {X4,Y4}),aperto, aperto, vuoto, chiuso).
:- test(union4,union4({A1/B1}, {A2/B2}, {}, S4),aperto, aperto, vuoto, var).
:- test(union4,union4({A1/B1}, {A2/B2}, {}, {}),aperto, aperto, vuoto, vuoto).
:- test(union4,union4({A1/B1}, {X2,Y2}, {A3/B3}, {A4/B4}),aperto, chiuso, aperto, aperto).
:- test(union4,union4({A1/B1}, {X2,Y2}, {A3/B3}, {X4,Y4}),aperto, chiuso, aperto, chiuso).
:- test(union4,union4({A1/B1}, {X2,Y2}, {A3/B3}, S4),aperto, chiuso, aperto, var).
:- test(union4,union4({A1/B1}, {X2,Y2}, {A3/B3}, {}),aperto, chiuso, aperto, vuoto).
:- test(union4,union4({A1/B1}, {X2,Y2}, {X3,Y3}, {A4/B4}),aperto, chiuso, chiuso, aperto).
:- test(union4,union4({A1/B1}, {X2,Y2}, {X3,Y3}, {X4,Y4}),aperto, chiuso, chiuso, chiuso).
:- test(union4,union4({A1/B1}, {X2,Y2}, {X3,Y3}, S4),aperto, chiuso, chiuso, var).
:- test(union4,union4({A1/B1}, {X2,Y2}, {X3,Y3}, {}),aperto, chiuso, chiuso, vuoto).
:- test(union4,union4({A1/B1}, {X2,Y2}, S3, {A4/B4}),aperto, chiuso, var, aperto).
:- test(union4,union4({A1/B1}, {X2,Y2}, S3, {X4,Y4}),aperto, chiuso, var, chiuso).
:- test(union4,union4({A1/B1}, {X2,Y2}, S3, S4),aperto, chiuso, var, var).
:- test(union4,union4({A1/B1}, {X2,Y2}, S3, {}),aperto, chiuso, var, vuoto).
:- test(union4,union4({A1/B1}, {X2,Y2}, {}, {A4/B4}),aperto, chiuso, vuoto, aperto).
:- test(union4,union4({A1/B1}, {X2,Y2}, {}, {X4,Y4}),aperto, chiuso, vuoto, chiuso).
:- test(union4,union4({A1/B1}, {X2,Y2}, {}, S4),aperto, chiuso, vuoto, var).
:- test(union4,union4({A1/B1}, {X2,Y2}, {}, {}),aperto, chiuso, vuoto, vuoto).
:- test(union4,union4({A1/B1}, S2, {A3/B3}, {A4/B4}),aperto, var, aperto, aperto).
:- test(union4,union4({A1/B1}, S2, {A3/B3}, {X4,Y4}),aperto, var, aperto, chiuso).
:- test(union4,union4({A1/B1}, S2, {A3/B3}, S4),aperto, var, aperto, var).
:- test(union4,union4({A1/B1}, S2, {A3/B3}, {}),aperto, var, aperto, vuoto).
:- test(union4,union4({A1/B1}, S2, {X3,Y3}, {A4/B4}),aperto, var, chiuso, aperto).
:- test(union4,union4({A1/B1}, S2, {X3,Y3}, {X4,Y4}),aperto, var, chiuso, chiuso).
:- test(union4,union4({A1/B1}, S2, {X3,Y3}, S4),aperto, var, chiuso, var).
:- test(union4,union4({A1/B1}, S2, {X3,Y3}, {}),aperto, var, chiuso, vuoto).
:- test(union4,union4({A1/B1}, S2, S3, {A4/B4}),aperto, var, var, aperto).
:- test(union4,union4({A1/B1}, S2, S3, {X4,Y4}),aperto, var, var, chiuso).
:- test(union4,union4({A1/B1}, S2, S3, S4),aperto, var, var, var).
:- test(union4,union4({A1/B1}, S2, S3, {}),aperto, var, var, vuoto).
:- test(union4,union4({A1/B1}, S2, {}, {A4/B4}),aperto, var, vuoto, aperto).
:- test(union4,union4({A1/B1}, S2, {}, {X4,Y4}),aperto, var, vuoto, chiuso).
:- test(union4,union4({A1/B1}, S2, {}, S4),aperto, var, vuoto, var).
:- test(union4,union4({A1/B1}, S2, {}, {}),aperto, var, vuoto, vuoto).
:- test(union4,union4({A1/B1}, {}, {A3/B3}, {A4/B4}),aperto, vuoto, aperto, aperto).
:- test(union4,union4({A1/B1}, {}, {A3/B3}, {X4,Y4}),aperto, vuoto, aperto, chiuso).
:- test(union4,union4({A1/B1}, {}, {A3/B3}, S4),aperto, vuoto, aperto, var).
:- test(union4,union4({A1/B1}, {}, {A3/B3}, {}),aperto, vuoto, aperto, vuoto).
:- test(union4,union4({A1/B1}, {}, {X3,Y3}, {A4/B4}),aperto, vuoto, chiuso, aperto).
:- test(union4,union4({A1/B1}, {}, {X3,Y3}, {X4,Y4}),aperto, vuoto, chiuso, chiuso).
:- test(union4,union4({A1/B1}, {}, {X3,Y3}, S4),aperto, vuoto, chiuso, var).
:- test(union4,union4({A1/B1}, {}, {X3,Y3}, {}),aperto, vuoto, chiuso, vuoto).
:- test(union4,union4({A1/B1}, {}, S3, {A4/B4}),aperto, vuoto, var, aperto).
:- test(union4,union4({A1/B1}, {}, S3, {X4,Y4}),aperto, vuoto, var, chiuso).
:- test(union4,union4({A1/B1}, {}, S3, S4),aperto, vuoto, var, var).
:- test(union4,union4({A1/B1}, {}, S3, {}),aperto, vuoto, var, vuoto).
:- test(union4,union4({A1/B1}, {}, {}, {A4/B4}),aperto, vuoto, vuoto, aperto).
:- test(union4,union4({A1/B1}, {}, {}, {X4,Y4}),aperto, vuoto, vuoto, chiuso).
:- test(union4,union4({A1/B1}, {}, {}, S4),aperto, vuoto, vuoto, var).
:- test(union4,union4({A1/B1}, {}, {}, {}),aperto, vuoto, vuoto, vuoto).
:- test(union4,union4({X1,Y1}, {A2/B2}, {A3/B3}, {A4/B4}),chiuso, aperto, aperto, aperto).
:- test(union4,union4({X1,Y1}, {A2/B2}, {A3/B3}, {X4,Y4}),chiuso, aperto, aperto, chiuso).
:- test(union4,union4({X1,Y1}, {A2/B2}, {A3/B3}, S4),chiuso, aperto, aperto, var).
:- test(union4,union4({X1,Y1}, {A2/B2}, {A3/B3}, {}),chiuso, aperto, aperto, vuoto).
:- test(union4,union4({X1,Y1}, {A2/B2}, {X3,Y3}, {A4/B4}),chiuso, aperto, chiuso, aperto).
:- test(union4,union4({X1,Y1}, {A2/B2}, {X3,Y3}, {X4,Y4}),chiuso, aperto, chiuso, chiuso).
:- test(union4,union4({X1,Y1}, {A2/B2}, {X3,Y3}, S4),chiuso, aperto, chiuso, var).
:- test(union4,union4({X1,Y1}, {A2/B2}, {X3,Y3}, {}),chiuso, aperto, chiuso, vuoto).
:- test(union4,union4({X1,Y1}, {A2/B2}, S3, {A4/B4}),chiuso, aperto, var, aperto).
:- test(union4,union4({X1,Y1}, {A2/B2}, S3, {X4,Y4}),chiuso, aperto, var, chiuso).
:- test(union4,union4({X1,Y1}, {A2/B2}, S3, S4),chiuso, aperto, var, var).
:- test(union4,union4({X1,Y1}, {A2/B2}, S3, {}),chiuso, aperto, var, vuoto).
:- test(union4,union4({X1,Y1}, {A2/B2}, {}, {A4/B4}),chiuso, aperto, vuoto, aperto).
:- test(union4,union4({X1,Y1}, {A2/B2}, {}, {X4,Y4}),chiuso, aperto, vuoto, chiuso).
:- test(union4,union4({X1,Y1}, {A2/B2}, {}, S4),chiuso, aperto, vuoto, var).
:- test(union4,union4({X1,Y1}, {A2/B2}, {}, {}),chiuso, aperto, vuoto, vuoto).
:- test(union4,union4({X1,Y1}, {X2,Y2}, {A3/B3}, {A4/B4}),chiuso, chiuso, aperto, aperto).
:- test(union4,union4({X1,Y1}, {X2,Y2}, {A3/B3}, {X4,Y4}),chiuso, chiuso, aperto, chiuso).
:- test(union4,union4({X1,Y1}, {X2,Y2}, {A3/B3}, S4),chiuso, chiuso, aperto, var).
:- test(union4,union4({X1,Y1}, {X2,Y2}, {A3/B3}, {}),chiuso, chiuso, aperto, vuoto).
:- test(union4,union4({X1,Y1}, {X2,Y2}, {X3,Y3}, {A4/B4}),chiuso, chiuso, chiuso, aperto).
:- test(union4,union4({X1,Y1}, {X2,Y2}, {X3,Y3}, {X4,Y4}),chiuso, chiuso, chiuso, chiuso).
:- test(union4,union4({X1,Y1}, {X2,Y2}, {X3,Y3}, S4),chiuso, chiuso, chiuso, var).
:- test(union4,union4({X1,Y1}, {X2,Y2}, {X3,Y3}, {}),chiuso, chiuso, chiuso, vuoto).
:- test(union4,union4({X1,Y1}, {X2,Y2}, S3, {A4/B4}),chiuso, chiuso, var, aperto).
:- test(union4,union4({X1,Y1}, {X2,Y2}, S3, {X4,Y4}),chiuso, chiuso, var, chiuso).
:- test(union4,union4({X1,Y1}, {X2,Y2}, S3, S4),chiuso, chiuso, var, var).
:- test(union4,union4({X1,Y1}, {X2,Y2}, S3, {}),chiuso, chiuso, var, vuoto).
:- test(union4,union4({X1,Y1}, {X2,Y2}, {}, {A4/B4}),chiuso, chiuso, vuoto, aperto).
:- test(union4,union4({X1,Y1}, {X2,Y2}, {}, {X4,Y4}),chiuso, chiuso, vuoto, chiuso).
:- test(union4,union4({X1,Y1}, {X2,Y2}, {}, S4),chiuso, chiuso, vuoto, var).
:- test(union4,union4({X1,Y1}, {X2,Y2}, {}, {}),chiuso, chiuso, vuoto, vuoto).
:- test(union4,union4({X1,Y1}, S2, {A3/B3}, {A4/B4}),chiuso, var, aperto, aperto).
:- test(union4,union4({X1,Y1}, S2, {A3/B3}, {X4,Y4}),chiuso, var, aperto, chiuso).
:- test(union4,union4({X1,Y1}, S2, {A3/B3}, S4),chiuso, var, aperto, var).
:- test(union4,union4({X1,Y1}, S2, {A3/B3}, {}),chiuso, var, aperto, vuoto).
:- test(union4,union4({X1,Y1}, S2, {X3,Y3}, {A4/B4}),chiuso, var, chiuso, aperto).
:- test(union4,union4({X1,Y1}, S2, {X3,Y3}, {X4,Y4}),chiuso, var, chiuso, chiuso).
:- test(union4,union4({X1,Y1}, S2, {X3,Y3}, S4),chiuso, var, chiuso, var).
:- test(union4,union4({X1,Y1}, S2, {X3,Y3}, {}),chiuso, var, chiuso, vuoto).
:- test(union4,union4({X1,Y1}, S2, S3, {A4/B4}),chiuso, var, var, aperto).
:- test(union4,union4({X1,Y1}, S2, S3, {X4,Y4}),chiuso, var, var, chiuso).
:- test(union4,union4({X1,Y1}, S2, S3, S4),chiuso, var, var, var).
:- test(union4,union4({X1,Y1}, S2, S3, {}),chiuso, var, var, vuoto).
:- test(union4,union4({X1,Y1}, S2, {}, {A4/B4}),chiuso, var, vuoto, aperto).
:- test(union4,union4({X1,Y1}, S2, {}, {X4,Y4}),chiuso, var, vuoto, chiuso).
:- test(union4,union4({X1,Y1}, S2, {}, S4),chiuso, var, vuoto, var).
:- test(union4,union4({X1,Y1}, S2, {}, {}),chiuso, var, vuoto, vuoto).
:- test(union4,union4({X1,Y1}, {}, {A3/B3}, {A4/B4}),chiuso, vuoto, aperto, aperto).
:- test(union4,union4({X1,Y1}, {}, {A3/B3}, {X4,Y4}),chiuso, vuoto, aperto, chiuso).
:- test(union4,union4({X1,Y1}, {}, {A3/B3}, S4),chiuso, vuoto, aperto, var).
:- test(union4,union4({X1,Y1}, {}, {A3/B3}, {}),chiuso, vuoto, aperto, vuoto).
:- test(union4,union4({X1,Y1}, {}, {X3,Y3}, {A4/B4}),chiuso, vuoto, chiuso, aperto).
:- test(union4,union4({X1,Y1}, {}, {X3,Y3}, {X4,Y4}),chiuso, vuoto, chiuso, chiuso).
:- test(union4,union4({X1,Y1}, {}, {X3,Y3}, S4),chiuso, vuoto, chiuso, var).
:- test(union4,union4({X1,Y1}, {}, {X3,Y3}, {}),chiuso, vuoto, chiuso, vuoto).
:- test(union4,union4({X1,Y1}, {}, S3, {A4/B4}),chiuso, vuoto, var, aperto).
:- test(union4,union4({X1,Y1}, {}, S3, {X4,Y4}),chiuso, vuoto, var, chiuso).
:- test(union4,union4({X1,Y1}, {}, S3, S4),chiuso, vuoto, var, var).
:- test(union4,union4({X1,Y1}, {}, S3, {}),chiuso, vuoto, var, vuoto).
:- test(union4,union4({X1,Y1}, {}, {}, {A4/B4}),chiuso, vuoto, vuoto, aperto).
:- test(union4,union4({X1,Y1}, {}, {}, {X4,Y4}),chiuso, vuoto, vuoto, chiuso).
:- test(union4,union4({X1,Y1}, {}, {}, S4),chiuso, vuoto, vuoto, var).
:- test(union4,union4({X1,Y1}, {}, {}, {}),chiuso, vuoto, vuoto, vuoto).
:- test(union4,union4(S1, {A2/B2}, {A3/B3}, {A4/B4}),var, aperto, aperto, aperto).
:- test(union4,union4(S1, {A2/B2}, {A3/B3}, {X4,Y4}),var, aperto, aperto, chiuso).
:- test(union4,union4(S1, {A2/B2}, {A3/B3}, S4),var, aperto, aperto, var).
:- test(union4,union4(S1, {A2/B2}, {A3/B3}, {}),var, aperto, aperto, vuoto).
:- test(union4,union4(S1, {A2/B2}, {X3,Y3}, {A4/B4}),var, aperto, chiuso, aperto).
:- test(union4,union4(S1, {A2/B2}, {X3,Y3}, {X4,Y4}),var, aperto, chiuso, chiuso).
:- test(union4,union4(S1, {A2/B2}, {X3,Y3}, S4),var, aperto, chiuso, var).
:- test(union4,union4(S1, {A2/B2}, {X3,Y3}, {}),var, aperto, chiuso, vuoto).
:- test(union4,union4(S1, {A2/B2}, S3, {A4/B4}),var, aperto, var, aperto).
:- test(union4,union4(S1, {A2/B2}, S3, {X4,Y4}),var, aperto, var, chiuso).
:- test(union4,union4(S1, {A2/B2}, S3, S4),var, aperto, var, var).
:- test(union4,union4(S1, {A2/B2}, S3, {}),var, aperto, var, vuoto).
:- test(union4,union4(S1, {A2/B2}, {}, {A4/B4}),var, aperto, vuoto, aperto).
:- test(union4,union4(S1, {A2/B2}, {}, {X4,Y4}),var, aperto, vuoto, chiuso).
:- test(union4,union4(S1, {A2/B2}, {}, S4),var, aperto, vuoto, var).
:- test(union4,union4(S1, {A2/B2}, {}, {}),var, aperto, vuoto, vuoto).
:- test(union4,union4(S1, {X2,Y2}, {A3/B3}, {A4/B4}),var, chiuso, aperto, aperto).
:- test(union4,union4(S1, {X2,Y2}, {A3/B3}, {X4,Y4}),var, chiuso, aperto, chiuso).
:- test(union4,union4(S1, {X2,Y2}, {A3/B3}, S4),var, chiuso, aperto, var).
:- test(union4,union4(S1, {X2,Y2}, {A3/B3}, {}),var, chiuso, aperto, vuoto).
:- test(union4,union4(S1, {X2,Y2}, {X3,Y3}, {A4/B4}),var, chiuso, chiuso, aperto).
:- test(union4,union4(S1, {X2,Y2}, {X3,Y3}, {X4,Y4}),var, chiuso, chiuso, chiuso).
:- test(union4,union4(S1, {X2,Y2}, {X3,Y3}, S4),var, chiuso, chiuso, var).
:- test(union4,union4(S1, {X2,Y2}, {X3,Y3}, {}),var, chiuso, chiuso, vuoto).
:- test(union4,union4(S1, {X2,Y2}, S3, {A4/B4}),var, chiuso, var, aperto).
:- test(union4,union4(S1, {X2,Y2}, S3, {X4,Y4}),var, chiuso, var, chiuso).
:- test(union4,union4(S1, {X2,Y2}, S3, S4),var, chiuso, var, var).
:- test(union4,union4(S1, {X2,Y2}, S3, {}),var, chiuso, var, vuoto).
:- test(union4,union4(S1, {X2,Y2}, {}, {A4/B4}),var, chiuso, vuoto, aperto).
:- test(union4,union4(S1, {X2,Y2}, {}, {X4,Y4}),var, chiuso, vuoto, chiuso).
:- test(union4,union4(S1, {X2,Y2}, {}, S4),var, chiuso, vuoto, var).
:- test(union4,union4(S1, {X2,Y2}, {}, {}),var, chiuso, vuoto, vuoto).
:- test(union4,union4(S1, S2, {A3/B3}, {A4/B4}),var, var, aperto, aperto).
:- test(union4,union4(S1, S2, {A3/B3}, {X4,Y4}),var, var, aperto, chiuso).
:- test(union4,union4(S1, S2, {A3/B3}, S4),var, var, aperto, var).
:- test(union4,union4(S1, S2, {A3/B3}, {}),var, var, aperto, vuoto).
:- test(union4,union4(S1, S2, {X3,Y3}, {A4/B4}),var, var, chiuso, aperto).
:- test(union4,union4(S1, S2, {X3,Y3}, {X4,Y4}),var, var, chiuso, chiuso).
:- test(union4,union4(S1, S2, {X3,Y3}, S4),var, var, chiuso, var).
:- test(union4,union4(S1, S2, {X3,Y3}, {}),var, var, chiuso, vuoto).
:- test(union4,union4(S1, S2, S3, {A4/B4}),var, var, var, aperto).
:- test(union4,union4(S1, S2, S3, {X4,Y4}),var, var, var, chiuso).
:- test(union4,union4(S1, S2, S3, S4),var, var, var, var).
:- test(union4,union4(S1, S2, S3, {}),var, var, var, vuoto).
:- test(union4,union4(S1, S2, {}, {A4/B4}),var, var, vuoto, aperto).
:- test(union4,union4(S1, S2, {}, {X4,Y4}),var, var, vuoto, chiuso).
:- test(union4,union4(S1, S2, {}, S4),var, var, vuoto, var).
:- test(union4,union4(S1, S2, {}, {}),var, var, vuoto, vuoto).
:- test(union4,union4(S1, {}, {A3/B3}, {A4/B4}),var, vuoto, aperto, aperto).
:- test(union4,union4(S1, {}, {A3/B3}, {X4,Y4}),var, vuoto, aperto, chiuso).
:- test(union4,union4(S1, {}, {A3/B3}, S4),var, vuoto, aperto, var).
:- test(union4,union4(S1, {}, {A3/B3}, {}),var, vuoto, aperto, vuoto).
:- test(union4,union4(S1, {}, {X3,Y3}, {A4/B4}),var, vuoto, chiuso, aperto).
:- test(union4,union4(S1, {}, {X3,Y3}, {X4,Y4}),var, vuoto, chiuso, chiuso).
:- test(union4,union4(S1, {}, {X3,Y3}, S4),var, vuoto, chiuso, var).
:- test(union4,union4(S1, {}, {X3,Y3}, {}),var, vuoto, chiuso, vuoto).
:- test(union4,union4(S1, {}, S3, {A4/B4}),var, vuoto, var, aperto).
:- test(union4,union4(S1, {}, S3, {X4,Y4}),var, vuoto, var, chiuso).
:- test(union4,union4(S1, {}, S3, S4),var, vuoto, var, var).
:- test(union4,union4(S1, {}, S3, {}),var, vuoto, var, vuoto).
:- test(union4,union4(S1, {}, {}, {A4/B4}),var, vuoto, vuoto, aperto).
:- test(union4,union4(S1, {}, {}, {X4,Y4}),var, vuoto, vuoto, chiuso).
:- test(union4,union4(S1, {}, {}, S4),var, vuoto, vuoto, var).
:- test(union4,union4(S1, {}, {}, {}),var, vuoto, vuoto, vuoto).
:- test(union4,union4({}, {A2/B2}, {A3/B3}, {A4/B4}),vuoto, aperto, aperto, aperto).
:- test(union4,union4({}, {A2/B2}, {A3/B3}, {X4,Y4}),vuoto, aperto, aperto, chiuso).
:- test(union4,union4({}, {A2/B2}, {A3/B3}, S4),vuoto, aperto, aperto, var).
:- test(union4,union4({}, {A2/B2}, {A3/B3}, {}),vuoto, aperto, aperto, vuoto).
:- test(union4,union4({}, {A2/B2}, {X3,Y3}, {A4/B4}),vuoto, aperto, chiuso, aperto).
:- test(union4,union4({}, {A2/B2}, {X3,Y3}, {X4,Y4}),vuoto, aperto, chiuso, chiuso).
:- test(union4,union4({}, {A2/B2}, {X3,Y3}, S4),vuoto, aperto, chiuso, var).
:- test(union4,union4({}, {A2/B2}, {X3,Y3}, {}),vuoto, aperto, chiuso, vuoto).
:- test(union4,union4({}, {A2/B2}, S3, {A4/B4}),vuoto, aperto, var, aperto).
:- test(union4,union4({}, {A2/B2}, S3, {X4,Y4}),vuoto, aperto, var, chiuso).
:- test(union4,union4({}, {A2/B2}, S3, S4),vuoto, aperto, var, var).
:- test(union4,union4({}, {A2/B2}, S3, {}),vuoto, aperto, var, vuoto).
:- test(union4,union4({}, {A2/B2}, {}, {A4/B4}),vuoto, aperto, vuoto, aperto).
:- test(union4,union4({}, {A2/B2}, {}, {X4,Y4}),vuoto, aperto, vuoto, chiuso).
:- test(union4,union4({}, {A2/B2}, {}, S4),vuoto, aperto, vuoto, var).
:- test(union4,union4({}, {A2/B2}, {}, {}),vuoto, aperto, vuoto, vuoto).
:- test(union4,union4({}, {X2,Y2}, {A3/B3}, {A4/B4}),vuoto, chiuso, aperto, aperto).
:- test(union4,union4({}, {X2,Y2}, {A3/B3}, {X4,Y4}),vuoto, chiuso, aperto, chiuso).
:- test(union4,union4({}, {X2,Y2}, {A3/B3}, S4),vuoto, chiuso, aperto, var).
:- test(union4,union4({}, {X2,Y2}, {A3/B3}, {}),vuoto, chiuso, aperto, vuoto).
:- test(union4,union4({}, {X2,Y2}, {X3,Y3}, {A4/B4}),vuoto, chiuso, chiuso, aperto).
:- test(union4,union4({}, {X2,Y2}, {X3,Y3}, {X4,Y4}),vuoto, chiuso, chiuso, chiuso).
:- test(union4,union4({}, {X2,Y2}, {X3,Y3}, S4),vuoto, chiuso, chiuso, var).
:- test(union4,union4({}, {X2,Y2}, {X3,Y3}, {}),vuoto, chiuso, chiuso, vuoto).
:- test(union4,union4({}, {X2,Y2}, S3, {A4/B4}),vuoto, chiuso, var, aperto).
:- test(union4,union4({}, {X2,Y2}, S3, {X4,Y4}),vuoto, chiuso, var, chiuso).
:- test(union4,union4({}, {X2,Y2}, S3, S4),vuoto, chiuso, var, var).
:- test(union4,union4({}, {X2,Y2}, S3, {}),vuoto, chiuso, var, vuoto).
:- test(union4,union4({}, {X2,Y2}, {}, {A4/B4}),vuoto, chiuso, vuoto, aperto).
:- test(union4,union4({}, {X2,Y2}, {}, {X4,Y4}),vuoto, chiuso, vuoto, chiuso).
:- test(union4,union4({}, {X2,Y2}, {}, S4),vuoto, chiuso, vuoto, var).
:- test(union4,union4({}, {X2,Y2}, {}, {}),vuoto, chiuso, vuoto, vuoto).
:- test(union4,union4({}, S2, {A3/B3}, {A4/B4}),vuoto, var, aperto, aperto).
:- test(union4,union4({}, S2, {A3/B3}, {X4,Y4}),vuoto, var, aperto, chiuso).
:- test(union4,union4({}, S2, {A3/B3}, S4),vuoto, var, aperto, var).
:- test(union4,union4({}, S2, {A3/B3}, {}),vuoto, var, aperto, vuoto).
:- test(union4,union4({}, S2, {X3,Y3}, {A4/B4}),vuoto, var, chiuso, aperto).
:- test(union4,union4({}, S2, {X3,Y3}, {X4,Y4}),vuoto, var, chiuso, chiuso).
:- test(union4,union4({}, S2, {X3,Y3}, S4),vuoto, var, chiuso, var).
:- test(union4,union4({}, S2, {X3,Y3}, {}),vuoto, var, chiuso, vuoto).
:- test(union4,union4({}, S2, S3, {A4/B4}),vuoto, var, var, aperto).
:- test(union4,union4({}, S2, S3, {X4,Y4}),vuoto, var, var, chiuso).
:- test(union4,union4({}, S2, S3, S4),vuoto, var, var, var).
:- test(union4,union4({}, S2, S3, {}),vuoto, var, var, vuoto).
:- test(union4,union4({}, S2, {}, {A4/B4}),vuoto, var, vuoto, aperto).
:- test(union4,union4({}, S2, {}, {X4,Y4}),vuoto, var, vuoto, chiuso).
:- test(union4,union4({}, S2, {}, S4),vuoto, var, vuoto, var).
:- test(union4,union4({}, S2, {}, {}),vuoto, var, vuoto, vuoto).
:- test(union4,union4({}, {}, {A3/B3}, {A4/B4}),vuoto, vuoto, aperto, aperto).
:- test(union4,union4({}, {}, {A3/B3}, {X4,Y4}),vuoto, vuoto, aperto, chiuso).
:- test(union4,union4({}, {}, {A3/B3}, S4),vuoto, vuoto, aperto, var).
:- test(union4,union4({}, {}, {A3/B3}, {}),vuoto, vuoto, aperto, vuoto).
:- test(union4,union4({}, {}, {X3,Y3}, {A4/B4}),vuoto, vuoto, chiuso, aperto).
:- test(union4,union4({}, {}, {X3,Y3}, {X4,Y4}),vuoto, vuoto, chiuso, chiuso).
:- test(union4,union4({}, {}, {X3,Y3}, S4),vuoto, vuoto, chiuso, var).
:- test(union4,union4({}, {}, {X3,Y3}, {}),vuoto, vuoto, chiuso, vuoto).
:- test(union4,union4({}, {}, S3, {A4/B4}),vuoto, vuoto, var, aperto).
:- test(union4,union4({}, {}, S3, {X4,Y4}),vuoto, vuoto, var, chiuso).
:- test(union4,union4({}, {}, S3, S4),vuoto, vuoto, var, var).
:- test(union4,union4({}, {}, S3, {}),vuoto, vuoto, var, vuoto).
:- test(union4,union4({}, {}, {}, {A4/B4}),vuoto, vuoto, vuoto, aperto).
:- test(union4,union4({}, {}, {}, {X4,Y4}),vuoto, vuoto, vuoto, chiuso).
:- test(union4,union4({}, {}, {}, S4),vuoto, vuoto, vuoto, var).
:- test(union4,union4({}, {}, {}, {}),vuoto, vuoto, vuoto, vuoto).


:- told.

:- halt.
