:- style_check(-singleton).

test(Op,C,Arg1,Arg2) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(false),nl.
test(Op,C,Arg1,Arg2,Arg3) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2,Arg3) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(false),nl.


:- tell('test6/test6_test_cases_specs.txt').

:- test(comp,comp({[X1,Y1]/R1}, {[X2,Y2]/R2}, {[X3,Y3]/R3}),aperto, aperto, aperto).
:- test(comp,comp({[X1,Y1]/R1}, {[X2,Y2]/R2}, {[A5,B5],[A6,B6]}),aperto, aperto, chiuso).
:- test(comp,comp({[X1,Y1]/R1}, {[X2,Y2]/R2}, C),aperto, aperto, var).
:- test(comp,comp({[X1,Y1]/R1}, {[X2,Y2]/R2}, {}),aperto, aperto, vuoto).
:- test(comp,comp({[X1,Y1]/R1}, {[A3,B3],[A4,B4]}, {[X3,Y3]/R3}),aperto, chiuso, aperto).
:- test(comp,comp({[X1,Y1]/R1}, {[A3,B3],[A4,B4]}, {[A5,B5],[A6,B6]}),aperto, chiuso, chiuso).
:- test(comp,comp({[X1,Y1]/R1}, {[A3,B3],[A4,B4]}, C),aperto, chiuso, var).
:- test(comp,comp({[X1,Y1]/R1}, {[A3,B3],[A4,B4]}, {}),aperto, chiuso, vuoto).
:- test(comp,comp({[X1,Y1]/R1}, B, {[X3,Y3]/R3}),aperto, var, aperto).
:- test(comp,comp({[X1,Y1]/R1}, B, {[A5,B5],[A6,B6]}),aperto, var, chiuso).
:- test(comp,comp({[X1,Y1]/R1}, B, C),aperto, var, var).
:- test(comp,comp({[X1,Y1]/R1}, B, {}),aperto, var, vuoto).
:- test(comp,comp({[X1,Y1]/R1}, {}, {[X3,Y3]/R3}),aperto, vuoto, aperto).
:- test(comp,comp({[X1,Y1]/R1}, {}, {[A5,B5],[A6,B6]}),aperto, vuoto, chiuso).
:- test(comp,comp({[X1,Y1]/R1}, {}, C),aperto, vuoto, var).
:- test(comp,comp({[X1,Y1]/R1}, {}, {}),aperto, vuoto, vuoto).
:- test(comp,comp({[A1,B1],[A2,B2]}, {[X2,Y2]/R2}, {[X3,Y3]/R3}),chiuso, aperto, aperto).
:- test(comp,comp({[A1,B1],[A2,B2]}, {[X2,Y2]/R2}, {[A5,B5],[A6,B6]}),chiuso, aperto, chiuso).
:- test(comp,comp({[A1,B1],[A2,B2]}, {[X2,Y2]/R2}, C),chiuso, aperto, var).
:- test(comp,comp({[A1,B1],[A2,B2]}, {[X2,Y2]/R2}, {}),chiuso, aperto, vuoto).
:- test(comp,comp({[A1,B1],[A2,B2]}, {[A3,B3],[A4,B4]}, {[X3,Y3]/R3}),chiuso, chiuso, aperto).
:- test(comp,comp({[A1,B1],[A2,B2]}, {[A3,B3],[A4,B4]}, {[A5,B5],[A6,B6]}),chiuso, chiuso, chiuso).
:- test(comp,comp({[A1,B1],[A2,B2]}, {[A3,B3],[A4,B4]}, C),chiuso, chiuso, var).
:- test(comp,comp({[A1,B1],[A2,B2]}, {[A3,B3],[A4,B4]}, {}),chiuso, chiuso, vuoto).
:- test(comp,comp({[A1,B1],[A2,B2]}, B, {[X3,Y3]/R3}),chiuso, var, aperto).
:- test(comp,comp({[A1,B1],[A2,B2]}, B, {[A5,B5],[A6,B6]}),chiuso, var, chiuso).
:- test(comp,comp({[A1,B1],[A2,B2]}, B, C),chiuso, var, var).
:- test(comp,comp({[A1,B1],[A2,B2]}, B, {}),chiuso, var, vuoto).
:- test(comp,comp({[A1,B1],[A2,B2]}, {}, {[X3,Y3]/R3}),chiuso, vuoto, aperto).
:- test(comp,comp({[A1,B1],[A2,B2]}, {}, {[A5,B5],[A6,B6]}),chiuso, vuoto, chiuso).
:- test(comp,comp({[A1,B1],[A2,B2]}, {}, C),chiuso, vuoto, var).
:- test(comp,comp({[A1,B1],[A2,B2]}, {}, {}),chiuso, vuoto, vuoto).
:- test(comp,comp(A, {[X2,Y2]/R2}, {[X3,Y3]/R3}),var, aperto, aperto).
:- test(comp,comp(A, {[X2,Y2]/R2}, {[A5,B5],[A6,B6]}),var, aperto, chiuso).
:- test(comp,comp(A, {[X2,Y2]/R2}, C),var, aperto, var).
:- test(comp,comp(A, {[X2,Y2]/R2}, {}),var, aperto, vuoto).
:- test(comp,comp(A, {[A3,B3],[A4,B4]}, {[X3,Y3]/R3}),var, chiuso, aperto).
:- test(comp,comp(A, {[A3,B3],[A4,B4]}, {[A5,B5],[A6,B6]}),var, chiuso, chiuso).
:- test(comp,comp(A, {[A3,B3],[A4,B4]}, C),var, chiuso, var).
:- test(comp,comp(A, {[A3,B3],[A4,B4]}, {}),var, chiuso, vuoto).
:- test(comp,comp(A, B, {[X3,Y3]/R3}),var, var, aperto).
:- test(comp,comp(A, B, {[A5,B5],[A6,B6]}),var, var, chiuso).
:- test(comp,comp(A, B, C),var, var, var).
:- test(comp,comp(A, B, {}),var, var, vuoto).
:- test(comp,comp(A, {}, {[X3,Y3]/R3}),var, vuoto, aperto).
:- test(comp,comp(A, {}, {[A5,B5],[A6,B6]}),var, vuoto, chiuso).
:- test(comp,comp(A, {}, C),var, vuoto, var).
:- test(comp,comp(A, {}, {}),var, vuoto, vuoto).
:- test(comp,comp({}, {[X2,Y2]/R2}, {[X3,Y3]/R3}),vuoto, aperto, aperto).
:- test(comp,comp({}, {[X2,Y2]/R2}, {[A5,B5],[A6,B6]}),vuoto, aperto, chiuso).
:- test(comp,comp({}, {[X2,Y2]/R2}, C),vuoto, aperto, var).
:- test(comp,comp({}, {[X2,Y2]/R2}, {}),vuoto, aperto, vuoto).
:- test(comp,comp({}, {[A3,B3],[A4,B4]}, {[X3,Y3]/R3}),vuoto, chiuso, aperto).
:- test(comp,comp({}, {[A3,B3],[A4,B4]}, {[A5,B5],[A6,B6]}),vuoto, chiuso, chiuso).
:- test(comp,comp({}, {[A3,B3],[A4,B4]}, C),vuoto, chiuso, var).
:- test(comp,comp({}, {[A3,B3],[A4,B4]}, {}),vuoto, chiuso, vuoto).
:- test(comp,comp({}, B, {[X3,Y3]/R3}),vuoto, var, aperto).
:- test(comp,comp({}, B, {[A5,B5],[A6,B6]}),vuoto, var, chiuso).
:- test(comp,comp({}, B, C),vuoto, var, var).
:- test(comp,comp({}, B, {}),vuoto, var, vuoto).
:- test(comp,comp({}, {}, {[X3,Y3]/R3}),vuoto, vuoto, aperto).
:- test(comp,comp({}, {}, {[A5,B5],[A6,B6]}),vuoto, vuoto, chiuso).
:- test(comp,comp({}, {}, C),vuoto, vuoto, var).
:- test(comp,comp({}, {}, {}),vuoto, vuoto, vuoto).

:- test(inv,inv({[X1,Y1]/R1}, {[X2,Y2]/R2}),aperto, aperto).
:- test(inv,inv({[X1,Y1]/R1}, {[A3,B3],[A4,B4]}),aperto, chiuso).
:- test(inv,inv({[X1,Y1]/R1}, B),aperto, var).
:- test(inv,inv({[X1,Y1]/R1}, {}),aperto, vuoto).
:- test(inv,inv({[A1,B1],[A2,B2]}, {[X2,Y2]/R2}),chiuso, aperto).
:- test(inv,inv({[A1,B1],[A2,B2]}, {[A3,B3],[A4,B4]}),chiuso, chiuso).
:- test(inv,inv({[A1,B1],[A2,B2]}, B),chiuso, var).
:- test(inv,inv({[A1,B1],[A2,B2]}, {}),chiuso, vuoto).
:- test(inv,inv(A, {[X2,Y2]/R2}),var, aperto).
:- test(inv,inv(A, {[A3,B3],[A4,B4]}),var, chiuso).
:- test(inv,inv(A, B),var, var).
:- test(inv,inv(A, {}),var, vuoto).
:- test(inv,inv({}, {[X2,Y2]/R2}),vuoto, aperto).
:- test(inv,inv({}, {[A3,B3],[A4,B4]}),vuoto, chiuso).
:- test(inv,inv({}, B),vuoto, var).
:- test(inv,inv({}, {}),vuoto, vuoto).

:- test(id,id({[X1,Y1]/R1}, {[X2,Y2]/R2}),aperto, aperto).
:- test(id,id({[X1,Y1]/R1}, {[A3,B3],[A4,B4]}),aperto, chiuso).
:- test(id,id({[X1,Y1]/R1}, B),aperto, var).
:- test(id,id({[X1,Y1]/R1}, {}),aperto, vuoto).
:- test(id,id({[A1,B1],[A2,B2]}, {[X2,Y2]/R2}),chiuso, aperto).
:- test(id,id({[A1,B1],[A2,B2]}, {[A3,B3],[A4,B4]}),chiuso, chiuso).
:- test(id,id({[A1,B1],[A2,B2]}, B),chiuso, var).
:- test(id,id({[A1,B1],[A2,B2]}, {}),chiuso, vuoto).
:- test(id,id(A, {[X2,Y2]/R2}),var, aperto).
:- test(id,id(A, {[A3,B3],[A4,B4]}),var, chiuso).
:- test(id,id(A, B),var, var).
:- test(id,id(A, {}),var, vuoto).
:- test(id,id({}, {[X2,Y2]/R2}),vuoto, aperto).
:- test(id,id({}, {[A3,B3],[A4,B4]}),vuoto, chiuso).
:- test(id,id({}, B),vuoto, var).
:- test(id,id({}, {}),vuoto, vuoto).


:- told.

:- halt.