:- style_check(-singleton).

test(Op,C,Arg1,Arg2) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(false),nl.
test(Op,C,Arg1,Arg2,Arg3) :-
	setlog(C,_),!,write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(true),nl.
test(Op,_C,Arg1,Arg2,Arg3) :-
	write(Op),write(' '),write(Arg1),write(' '),write(Arg2),write(' '),write(Arg3),write(' '),write(false),nl.


:- tell('test8/test8_test_cases_specs.txt').

:- test(neq,{A1/B1} neq {A2/B2},aperto,aperto).
:- test(neq,{A1/B1} neq {X2,Y2},aperto,chiuso).
:- test(neq,{A1/B1} neq S2,aperto,var).
:- test(neq,{A1/B1} neq {},aperto,vuoto).
:- test(neq,{X1,Y1} neq {A2/B2},chiuso,aperto).
:- test(neq,{X1,Y1} neq {X2,Y2},chiuso,chiuso).
:- test(neq,{X1,Y1} neq S2,chiuso,var).
:- test(neq,{X1,Y1} neq {},chiuso,vuoto).
:- test(neq,S1 neq {A2/B2},var,aperto).
:- test(neq,S1 neq {X2,Y2},var,chiuso).
:- test(neq,S1 neq S2,var,var).
:- test(neq,S1 neq {},var,vuoto).
:- test(neq,{} neq {A2/B2},vuoto,aperto).
:- test(neq,{} neq {X2,Y2},vuoto,chiuso).
:- test(neq,{} neq S2,vuoto,var).
:- test(neq,{} neq {},vuoto,vuoto).

:- test(ndisj,ndisj({A1/B1}, {A2/B2}),aperto, aperto).
:- test(ndisj,ndisj({A1/B1}, {X2,Y2}),aperto, chiuso).
:- test(ndisj,ndisj({A1/B1}, S2),aperto, var).
:- test(ndisj,ndisj({A1/B1}, {}),aperto, vuoto).
:- test(ndisj,ndisj({X1,Y1}, {A2/B2}),chiuso, aperto).
:- test(ndisj,ndisj({X1,Y1}, {X2,Y2}),chiuso, chiuso).
:- test(ndisj,ndisj({X1,Y1}, S2),chiuso, var).
:- test(ndisj,ndisj({X1,Y1}, {}),chiuso, vuoto).
:- test(ndisj,ndisj(S1, {A2/B2}),var, aperto).
:- test(ndisj,ndisj(S1, {X2,Y2}),var, chiuso).
:- test(ndisj,ndisj(S1, S2),var, var).
:- test(ndisj,ndisj(S1, {}),var, vuoto).
:- test(ndisj,ndisj({}, {A2/B2}),vuoto, aperto).
:- test(ndisj,ndisj({}, {X2,Y2}),vuoto, chiuso).
:- test(ndisj,ndisj({}, S2),vuoto, var).
:- test(ndisj,ndisj({}, {}),vuoto, vuoto).

:- test(nunion,nun({A1/B1}, {A2/B2}, {A3/B3}),aperto, aperto, aperto).
:- test(nunion,nun({A1/B1}, {A2/B2}, {X3,Y3}),aperto, aperto, chiuso).
:- test(nunion,nun({A1/B1}, {A2/B2}, S3),aperto, aperto, var).
:- test(nunion,nun({A1/B1}, {A2/B2}, {}),aperto, aperto, vuoto).
:- test(nunion,nun({A1/B1}, {X2,Y2}, {A3/B3}),aperto, chiuso, aperto).
:- test(nunion,nun({A1/B1}, {X2,Y2}, {X3,Y3}),aperto, chiuso, chiuso).
:- test(nunion,nun({A1/B1}, {X2,Y2}, S3),aperto, chiuso, var).
:- test(nunion,nun({A1/B1}, {X2,Y2}, {}),aperto, chiuso, vuoto).
:- test(nunion,nun({A1/B1}, S2, {A3/B3}),aperto, var, aperto).
:- test(nunion,nun({A1/B1}, S2, {X3,Y3}),aperto, var, chiuso).
:- test(nunion,nun({A1/B1}, S2, S3),aperto, var, var).
:- test(nunion,nun({A1/B1}, S2, {}),aperto, var, vuoto).
:- test(nunion,nun({A1/B1}, {}, {A3/B3}),aperto, vuoto, aperto).
:- test(nunion,nun({A1/B1}, {}, {X3,Y3}),aperto, vuoto, chiuso).
:- test(nunion,nun({A1/B1}, {}, S3),aperto, vuoto, var).
:- test(nunion,nun({A1/B1}, {}, {}),aperto, vuoto, vuoto).
:- test(nunion,nun({X1,Y1}, {A2/B2}, {A3/B3}),chiuso, aperto, aperto).
:- test(nunion,nun({X1,Y1}, {A2/B2}, {X3,Y3}),chiuso, aperto, chiuso).
:- test(nunion,nun({X1,Y1}, {A2/B2}, S3),chiuso, aperto, var).
:- test(nunion,nun({X1,Y1}, {A2/B2}, {}),chiuso, aperto, vuoto).
:- test(nunion,nun({X1,Y1}, {X2,Y2}, {A3/B3}),chiuso, chiuso, aperto).
:- test(nunion,nun({X1,Y1}, {X2,Y2}, {X3,Y3}),chiuso, chiuso, chiuso).
:- test(nunion,nun({X1,Y1}, {X2,Y2}, S3),chiuso, chiuso, var).
:- test(nunion,nun({X1,Y1}, {X2,Y2}, {}),chiuso, chiuso, vuoto).
:- test(nunion,nun({X1,Y1}, S2, {A3/B3}),chiuso, var, aperto).
:- test(nunion,nun({X1,Y1}, S2, {X3,Y3}),chiuso, var, chiuso).
:- test(nunion,nun({X1,Y1}, S2, S3),chiuso, var, var).
:- test(nunion,nun({X1,Y1}, S2, {}),chiuso, var, vuoto).
:- test(nunion,nun({X1,Y1}, {}, {A3/B3}),chiuso, vuoto, aperto).
:- test(nunion,nun({X1,Y1}, {}, {X3,Y3}),chiuso, vuoto, chiuso).
:- test(nunion,nun({X1,Y1}, {}, S3),chiuso, vuoto, var).
:- test(nunion,nun({X1,Y1}, {}, {}),chiuso, vuoto, vuoto).
:- test(nunion,nun(S1, {A2/B2}, {A3/B3}),var, aperto, aperto).
:- test(nunion,nun(S1, {A2/B2}, {X3,Y3}),var, aperto, chiuso).
:- test(nunion,nun(S1, {A2/B2}, S3),var, aperto, var).
:- test(nunion,nun(S1, {A2/B2}, {}),var, aperto, vuoto).
:- test(nunion,nun(S1, {X2,Y2}, {A3/B3}),var, chiuso, aperto).
:- test(nunion,nun(S1, {X2,Y2}, {X3,Y3}),var, chiuso, chiuso).
:- test(nunion,nun(S1, {X2,Y2}, S3),var, chiuso, var).
:- test(nunion,nun(S1, {X2,Y2}, {}),var, chiuso, vuoto).
:- test(nunion,nun(S1, S2, {A3/B3}),var, var, aperto).
:- test(nunion,nun(S1, S2, {X3,Y3}),var, var, chiuso).
:- test(nunion,nun(S1, S2, S3),var, var, var).
:- test(nunion,nun(S1, S2, {}),var, var, vuoto).
:- test(nunion,nun(S1, {}, {A3/B3}),var, vuoto, aperto).
:- test(nunion,nun(S1, {}, {X3,Y3}),var, vuoto, chiuso).
:- test(nunion,nun(S1, {}, S3),var, vuoto, var).
:- test(nunion,nun(S1, {}, {}),var, vuoto, vuoto).
:- test(nunion,nun({}, {A2/B2}, {A3/B3}),vuoto, aperto, aperto).
:- test(nunion,nun({}, {A2/B2}, {X3,Y3}),vuoto, aperto, chiuso).
:- test(nunion,nun({}, {A2/B2}, S3),vuoto, aperto, var).
:- test(nunion,nun({}, {A2/B2}, {}),vuoto, aperto, vuoto).
:- test(nunion,nun({}, {X2,Y2}, {A3/B3}),vuoto, chiuso, aperto).
:- test(nunion,nun({}, {X2,Y2}, {X3,Y3}),vuoto, chiuso, chiuso).
:- test(nunion,nun({}, {X2,Y2}, S3),vuoto, chiuso, var).
:- test(nunion,nun({}, {X2,Y2}, {}),vuoto, chiuso, vuoto).
:- test(nunion,nun({}, S2, {A3/B3}),vuoto, var, aperto).
:- test(nunion,nun({}, S2, {X3,Y3}),vuoto, var, chiuso).
:- test(nunion,nun({}, S2, S3),vuoto, var, var).
:- test(nunion,nun({}, S2, {}),vuoto, var, vuoto).
:- test(nunion,nun({}, {}, {A3/B3}),vuoto, vuoto, aperto).
:- test(nunion,nun({}, {}, {X3,Y3}),vuoto, vuoto, chiuso).
:- test(nunion,nun({}, {}, S3),vuoto, vuoto, var).
:- test(nunion,nun({}, {}, {}),vuoto, vuoto, vuoto).


:- told.

:- halt.