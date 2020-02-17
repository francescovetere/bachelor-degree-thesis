package JSetL.test.constraintTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass; 		//calcolo dei tempi
import java.io.PrintWriter; 		//stampa dei tempi
import java.io.File;				//stampa dei tempi
import java.io.FileOutputStream;	//stampa dei tempi
import JSetL.*;


public class MyTestTest {

	public Constraint myTest(LSet A, LSet B, LSet C) {
		return C.union(A, B).and(C.nunion(A, B));
	}
	
	@Test
	public void testMyTest_Aperto_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(myTest(A1, A2, A3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Aperto_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myTest(A1, A2, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Aperto_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		solver.add(myTest(A1, A2, V3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Aperto_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		solver.add(myTest(A1, A2, E3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Aperto_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(myTest(A1, C2, A3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Aperto_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myTest(A1, C2, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Aperto_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		solver.add(myTest(A1, C2, V3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Aperto_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		solver.add(myTest(A1, C2, E3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Aperto_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(myTest(A1, V2, A3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Aperto_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myTest(A1, V2, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Aperto_Var_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		solver.add(myTest(A1, V2, V3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Aperto_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		solver.add(myTest(A1, V2, E3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Aperto_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(myTest(A1, E2, A3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Aperto_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myTest(A1, E2, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Aperto_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		solver.add(myTest(A1, E2, V3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Aperto_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		solver.add(myTest(A1, E2, E3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Chiuso_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(myTest(C1, A2, A3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Chiuso_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myTest(C1, A2, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Chiuso_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		solver.add(myTest(C1, A2, V3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Chiuso_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		solver.add(myTest(C1, A2, E3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Chiuso_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(myTest(C1, C2, A3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Chiuso_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myTest(C1, C2, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Chiuso_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		solver.add(myTest(C1, C2, V3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Chiuso_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		solver.add(myTest(C1, C2, E3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Chiuso_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(myTest(C1, V2, A3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Chiuso_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myTest(C1, V2, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Chiuso_Var_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		solver.add(myTest(C1, V2, V3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Chiuso_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		solver.add(myTest(C1, V2, E3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Chiuso_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(myTest(C1, E2, A3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Chiuso_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myTest(C1, E2, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Chiuso_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		solver.add(myTest(C1, E2, V3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Chiuso_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		solver.add(myTest(C1, E2, E3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Var_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(myTest(V1, A2, A3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Var_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myTest(V1, A2, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Var_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		solver.add(myTest(V1, A2, V3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Var_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		solver.add(myTest(V1, A2, E3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Var_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(myTest(V1, C2, A3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Var_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myTest(V1, C2, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Var_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		solver.add(myTest(V1, C2, V3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Var_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		solver.add(myTest(V1, C2, E3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Var_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(myTest(V1, V2, A3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Var_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myTest(V1, V2, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Var_Var_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		solver.add(myTest(V1, V2, V3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Var_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		solver.add(myTest(V1, V2, E3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Var_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(myTest(V1, E2, A3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Var_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myTest(V1, E2, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Var_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		solver.add(myTest(V1, E2, V3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Var_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		solver.add(myTest(V1, E2, E3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Vuoto_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(myTest(E1, A2, A3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Vuoto_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myTest(E1, A2, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Vuoto_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		solver.add(myTest(E1, A2, V3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Vuoto_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		solver.add(myTest(E1, A2, E3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Vuoto_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(myTest(E1, C2, A3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Vuoto_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myTest(E1, C2, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Vuoto_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		solver.add(myTest(E1, C2, V3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Vuoto_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		solver.add(myTest(E1, C2, E3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Vuoto_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(myTest(E1, V2, A3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Vuoto_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myTest(E1, V2, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Vuoto_Var_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		solver.add(myTest(E1, V2, V3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Vuoto_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		solver.add(myTest(E1, V2, E3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Vuoto_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(myTest(E1, E2, A3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Vuoto_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myTest(E1, E2, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Vuoto_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		solver.add(myTest(E1, E2, V3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyTest_Vuoto_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		solver.add(myTest(E1, E2, E3));
		assertFalse(solver.check());
	
	}

}