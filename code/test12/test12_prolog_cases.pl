:- style_check(-singleton).

test(Op,C,Arg1,Arg2) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(false),nl.
test(Op,C,Arg1,Arg2,Arg3) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2,Arg3) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(false),nl.


:- tell('test12/test12_test_cases_specs.txt').

:- test(comp,comp({[X3,Y3]/R1}, {[X4,Y4]/R2}, {[X5,Y5]/R3}),aperta, aperta, aperta).
:- test(comp,comp({[X3,Y3]/R1}, {[X4,Y4]/R2}, {[X3, X4]}),aperta, aperta, chiusaPiccolaNotGround).
:- test(comp,comp({[X3,Y3]/R1}, {[X4,Y4]/R2}, C),aperta, aperta, var).
:- test(comp,comp({[X3,Y3]/R1}, {[X4,Y4]/R2}, {}),aperta, aperta, vuota).
:- test(comp,comp({[X3,Y3]/R1}, {[X1, X2]}, {[X5,Y5]/R3}),aperta, chiusaPiccolaNotGround, aperta).
:- test(comp,comp({[X3,Y3]/R1}, {[X1, X2]}, {[X3, X4]}),aperta, chiusaPiccolaNotGround, chiusaPiccolaNotGround).
:- test(comp,comp({[X3,Y3]/R1}, {[X1, X2]}, C),aperta, chiusaPiccolaNotGround, var).
:- test(comp,comp({[X3,Y3]/R1}, {[X1, X2]}, {}),aperta, chiusaPiccolaNotGround, vuota).
:- test(comp,comp({[X3,Y3]/R1}, B, {[X5,Y5]/R3}),aperta, var, aperta).
:- test(comp,comp({[X3,Y3]/R1}, B, {[X3, X4]}),aperta, var, chiusaPiccolaNotGround).
:- test(comp,comp({[X3,Y3]/R1}, B, C),aperta, var, var).
:- test(comp,comp({[X3,Y3]/R1}, B, {}),aperta, var, vuota).
:- test(comp,comp({[X3,Y3]/R1}, {}, {[X5,Y5]/R3}),aperta, vuota, aperta).
:- test(comp,comp({[X3,Y3]/R1}, {}, {[X3, X4]}),aperta, vuota, chiusaPiccolaNotGround).
:- test(comp,comp({[X3,Y3]/R1}, {}, C),aperta, vuota, var).
:- test(comp,comp({[X3,Y3]/R1}, {}, {}),aperta, vuota, vuota).
:- test(comp,comp({[0, 0], [2, 2]}, {[X4,Y4]/R2}, {[X5,Y5]/R3}),chiusaGrossaGround, aperta, aperta).
:- test(comp,comp({[0, 0], [2, 2]}, {[X4,Y4]/R2}, {[X3, X4]}),chiusaGrossaGround, aperta, chiusaPiccolaNotGround).
:- test(comp,comp({[0, 0], [2, 2]}, {[X4,Y4]/R2}, C),chiusaGrossaGround, aperta, var).
:- test(comp,comp({[0, 0], [2, 2]}, {[X4,Y4]/R2}, {}),chiusaGrossaGround, aperta, vuota).
:- test(comp,comp({[0, 0], [2, 2]}, {[X1, X2]}, {[X5,Y5]/R3}),chiusaGrossaGround, chiusaPiccolaNotGround, aperta).
:- test(comp,comp({[0, 0], [2, 2]}, {[X1, X2]}, {[X3, X4]}),chiusaGrossaGround, chiusaPiccolaNotGround, chiusaPiccolaNotGround).
:- test(comp,comp({[0, 0], [2, 2]}, {[X1, X2]}, C),chiusaGrossaGround, chiusaPiccolaNotGround, var).
:- test(comp,comp({[0, 0], [2, 2]}, {[X1, X2]}, {}),chiusaGrossaGround, chiusaPiccolaNotGround, vuota).
:- test(comp,comp({[0, 0], [2, 2]}, B, {[X5,Y5]/R3}),chiusaGrossaGround, var, aperta).
:- test(comp,comp({[0, 0], [2, 2]}, B, {[X3, X4]}),chiusaGrossaGround, var, chiusaPiccolaNotGround).
:- test(comp,comp({[0, 0], [2, 2]}, B, C),chiusaGrossaGround, var, var).
:- test(comp,comp({[0, 0], [2, 2]}, B, {}),chiusaGrossaGround, var, vuota).
:- test(comp,comp({[0, 0], [2, 2]}, {}, {[X5,Y5]/R3}),chiusaGrossaGround, vuota, aperta).
:- test(comp,comp({[0, 0], [2, 2]}, {}, {[X3, X4]}),chiusaGrossaGround, vuota, chiusaPiccolaNotGround).
:- test(comp,comp({[0, 0], [2, 2]}, {}, C),chiusaGrossaGround, vuota, var).
:- test(comp,comp({[0, 0], [2, 2]}, {}, {}),chiusaGrossaGround, vuota, vuota).
:- test(comp,comp(A, {[X4,Y4]/R2}, {[X5,Y5]/R3}),var, aperta, aperta).
:- test(comp,comp(A, {[X4,Y4]/R2}, {[X3, X4]}),var, aperta, chiusaPiccolaNotGround).
:- test(comp,comp(A, {[X4,Y4]/R2}, C),var, aperta, var).
:- test(comp,comp(A, {[X4,Y4]/R2}, {}),var, aperta, vuota).
:- test(comp,comp(A, {[X1, X2]}, {[X5,Y5]/R3}),var, chiusaPiccolaNotGround, aperta).
:- test(comp,comp(A, {[X1, X2]}, {[X3, X4]}),var, chiusaPiccolaNotGround, chiusaPiccolaNotGround).
:- test(comp,comp(A, {[X1, X2]}, C),var, chiusaPiccolaNotGround, var).
:- test(comp,comp(A, {[X1, X2]}, {}),var, chiusaPiccolaNotGround, vuota).
:- test(comp,comp(A, B, {[X5,Y5]/R3}),var, var, aperta).
:- test(comp,comp(A, B, {[X3, X4]}),var, var, chiusaPiccolaNotGround).
:- test(comp,comp(A, B, C),var, var, var).
:- test(comp,comp(A, B, {}),var, var, vuota).
:- test(comp,comp(A, {}, {[X5,Y5]/R3}),var, vuota, aperta).
:- test(comp,comp(A, {}, {[X3, X4]}),var, vuota, chiusaPiccolaNotGround).
:- test(comp,comp(A, {}, C),var, vuota, var).
:- test(comp,comp(A, {}, {}),var, vuota, vuota).
:- test(comp,comp({}, {[X4,Y4]/R2}, {[X5,Y5]/R3}),vuota, aperta, aperta).
:- test(comp,comp({}, {[X4,Y4]/R2}, {[X3, X4]}),vuota, aperta, chiusaPiccolaNotGround).
:- test(comp,comp({}, {[X4,Y4]/R2}, C),vuota, aperta, var).
:- test(comp,comp({}, {[X4,Y4]/R2}, {}),vuota, aperta, vuota).
:- test(comp,comp({}, {[X1, X2]}, {[X5,Y5]/R3}),vuota, chiusaPiccolaNotGround, aperta).
:- test(comp,comp({}, {[X1, X2]}, {[X3, X4]}),vuota, chiusaPiccolaNotGround, chiusaPiccolaNotGround).
:- test(comp,comp({}, {[X1, X2]}, C),vuota, chiusaPiccolaNotGround, var).
:- test(comp,comp({}, {[X1, X2]}, {}),vuota, chiusaPiccolaNotGround, vuota).
:- test(comp,comp({}, B, {[X5,Y5]/R3}),vuota, var, aperta).
:- test(comp,comp({}, B, {[X3, X4]}),vuota, var, chiusaPiccolaNotGround).
:- test(comp,comp({}, B, C),vuota, var, var).
:- test(comp,comp({}, B, {}),vuota, var, vuota).
:- test(comp,comp({}, {}, {[X5,Y5]/R3}),vuota, vuota, aperta).
:- test(comp,comp({}, {}, {[X3, X4]}),vuota, vuota, chiusaPiccolaNotGround).
:- test(comp,comp({}, {}, C),vuota, vuota, var).
:- test(comp,comp({}, {}, {}),vuota, vuota, vuota).

:- test(inv,inv({[X3,Y3]/R1}, {[X4,Y4]/R2}),aperta, aperta).
:- test(inv,inv({[X3,Y3]/R1}, {[X1, X2]}),aperta, chiusaPiccolaNotGround).
:- test(inv,inv({[X3,Y3]/R1}, B),aperta, var).
:- test(inv,inv({[X3,Y3]/R1}, {}),aperta, vuota).
:- test(inv,inv({[0, 0], [2, 2]}, {[X4,Y4]/R2}),chiusaGrossaGround, aperta).
:- test(inv,inv({[0, 0], [2, 2]}, {[X1, X2]}),chiusaGrossaGround, chiusaPiccolaNotGround).
:- test(inv,inv({[0, 0], [2, 2]}, B),chiusaGrossaGround, var).
:- test(inv,inv({[0, 0], [2, 2]}, {}),chiusaGrossaGround, vuota).
:- test(inv,inv(A, {[X4,Y4]/R2}),var, aperta).
:- test(inv,inv(A, {[X1, X2]}),var, chiusaPiccolaNotGround).
:- test(inv,inv(A, B),var, var).
:- test(inv,inv(A, {}),var, vuota).
:- test(inv,inv({}, {[X4,Y4]/R2}),vuota, aperta).
:- test(inv,inv({}, {[X1, X2]}),vuota, chiusaPiccolaNotGround).
:- test(inv,inv({}, B),vuota, var).
:- test(inv,inv({}, {}),vuota, vuota).


:- told.

:- halt.