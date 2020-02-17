package JSetL.test.constraintTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass; 		//calcolo dei tempi
import java.io.PrintWriter; 		//stampa dei tempi
import java.io.File;				//stampa dei tempi
import java.io.FileOutputStream;	//stampa dei tempi
import JSetL.*;


public class Union4Test {

	public Constraint union4(LSet A, LSet B, LSet C, LSet D) {
		return C.union(A, B).and(D.union(A, B));
	}
	
	@Test
	public void testUnion4_Aperto_Aperto_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(A1, A2, A3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Aperto_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(A1, A2, A3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Aperto_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(A1, A2, A3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Aperto_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet E4 = LSet.empty();
		solver.add(union4(A1, A2, A3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Aperto_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(A1, A2, C3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Aperto_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(A1, A2, C3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Aperto_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(A1, A2, C3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Aperto_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet E4 = LSet.empty();
		solver.add(union4(A1, A2, C3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Aperto_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(A1, A2, V3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Aperto_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(A1, A2, V3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Aperto_Var_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		LSet V4 = new LSet("S4");
		solver.add(union4(A1, A2, V3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Aperto_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		LSet E4 = LSet.empty();
		solver.add(union4(A1, A2, V3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Aperto_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(A1, A2, E3, A4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Aperto_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(A1, A2, E3, C4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Aperto_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		LSet V4 = new LSet("S4");
		solver.add(union4(A1, A2, E3, V4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Aperto_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		LSet E4 = LSet.empty();
		solver.add(union4(A1, A2, E3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Chiuso_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(A1, C2, A3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Chiuso_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(A1, C2, A3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Chiuso_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(A1, C2, A3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Chiuso_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet E4 = LSet.empty();
		solver.add(union4(A1, C2, A3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Chiuso_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(A1, C2, C3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Chiuso_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(A1, C2, C3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Chiuso_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(A1, C2, C3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Chiuso_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet E4 = LSet.empty();
		solver.add(union4(A1, C2, C3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Chiuso_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(A1, C2, V3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Chiuso_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(A1, C2, V3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Chiuso_Var_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		LSet V4 = new LSet("S4");
		solver.add(union4(A1, C2, V3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Chiuso_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		LSet E4 = LSet.empty();
		solver.add(union4(A1, C2, V3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Chiuso_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(A1, C2, E3, A4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Chiuso_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(A1, C2, E3, C4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Chiuso_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		LSet V4 = new LSet("S4");
		solver.add(union4(A1, C2, E3, V4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Chiuso_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		LSet E4 = LSet.empty();
		solver.add(union4(A1, C2, E3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Var_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(A1, V2, A3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Var_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(A1, V2, A3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Var_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(A1, V2, A3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Var_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet E4 = LSet.empty();
		solver.add(union4(A1, V2, A3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Var_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(A1, V2, C3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Var_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(A1, V2, C3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Var_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(A1, V2, C3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Var_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet E4 = LSet.empty();
		solver.add(union4(A1, V2, C3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Var_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(A1, V2, V3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Var_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(A1, V2, V3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Var_Var_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		LSet V4 = new LSet("S4");
		solver.add(union4(A1, V2, V3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Var_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		LSet E4 = LSet.empty();
		solver.add(union4(A1, V2, V3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Var_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(A1, V2, E3, A4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Var_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(A1, V2, E3, C4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Var_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		LSet V4 = new LSet("S4");
		solver.add(union4(A1, V2, E3, V4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Var_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		LSet E4 = LSet.empty();
		solver.add(union4(A1, V2, E3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Vuoto_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(A1, E2, A3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Vuoto_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(A1, E2, A3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Vuoto_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(A1, E2, A3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Vuoto_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet E4 = LSet.empty();
		solver.add(union4(A1, E2, A3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Vuoto_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(A1, E2, C3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Vuoto_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(A1, E2, C3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Vuoto_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(A1, E2, C3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Vuoto_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet E4 = LSet.empty();
		solver.add(union4(A1, E2, C3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Vuoto_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(A1, E2, V3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Vuoto_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(A1, E2, V3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Vuoto_Var_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		LSet V4 = new LSet("S4");
		solver.add(union4(A1, E2, V3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Vuoto_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		LSet E4 = LSet.empty();
		solver.add(union4(A1, E2, V3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Vuoto_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(A1, E2, E3, A4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Vuoto_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(A1, E2, E3, C4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Vuoto_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		LSet V4 = new LSet("S4");
		solver.add(union4(A1, E2, E3, V4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Aperto_Vuoto_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		LSet E4 = LSet.empty();
		solver.add(union4(A1, E2, E3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Aperto_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(C1, A2, A3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Aperto_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(C1, A2, A3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Aperto_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(C1, A2, A3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Aperto_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet E4 = LSet.empty();
		solver.add(union4(C1, A2, A3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Aperto_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(C1, A2, C3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Aperto_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(C1, A2, C3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Aperto_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(C1, A2, C3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Aperto_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet E4 = LSet.empty();
		solver.add(union4(C1, A2, C3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Aperto_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(C1, A2, V3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Aperto_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(C1, A2, V3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Aperto_Var_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		LSet V4 = new LSet("S4");
		solver.add(union4(C1, A2, V3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Aperto_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		LSet E4 = LSet.empty();
		solver.add(union4(C1, A2, V3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Aperto_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(C1, A2, E3, A4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Aperto_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(C1, A2, E3, C4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Aperto_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		LSet V4 = new LSet("S4");
		solver.add(union4(C1, A2, E3, V4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Aperto_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		LSet E4 = LSet.empty();
		solver.add(union4(C1, A2, E3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Chiuso_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(C1, C2, A3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Chiuso_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(C1, C2, A3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Chiuso_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(C1, C2, A3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Chiuso_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet E4 = LSet.empty();
		solver.add(union4(C1, C2, A3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Chiuso_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(C1, C2, C3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Chiuso_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(C1, C2, C3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Chiuso_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(C1, C2, C3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Chiuso_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet E4 = LSet.empty();
		solver.add(union4(C1, C2, C3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Chiuso_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(C1, C2, V3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Chiuso_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(C1, C2, V3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Chiuso_Var_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		LSet V4 = new LSet("S4");
		solver.add(union4(C1, C2, V3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Chiuso_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		LSet E4 = LSet.empty();
		solver.add(union4(C1, C2, V3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Chiuso_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(C1, C2, E3, A4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Chiuso_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(C1, C2, E3, C4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Chiuso_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		LSet V4 = new LSet("S4");
		solver.add(union4(C1, C2, E3, V4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Chiuso_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		LSet E4 = LSet.empty();
		solver.add(union4(C1, C2, E3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Var_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(C1, V2, A3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Var_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(C1, V2, A3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Var_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(C1, V2, A3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Var_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet E4 = LSet.empty();
		solver.add(union4(C1, V2, A3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Var_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(C1, V2, C3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Var_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(C1, V2, C3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Var_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(C1, V2, C3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Var_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet E4 = LSet.empty();
		solver.add(union4(C1, V2, C3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Var_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(C1, V2, V3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Var_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(C1, V2, V3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Var_Var_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		LSet V4 = new LSet("S4");
		solver.add(union4(C1, V2, V3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Var_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		LSet E4 = LSet.empty();
		solver.add(union4(C1, V2, V3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Var_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(C1, V2, E3, A4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Var_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(C1, V2, E3, C4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Var_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		LSet V4 = new LSet("S4");
		solver.add(union4(C1, V2, E3, V4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Var_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		LSet E4 = LSet.empty();
		solver.add(union4(C1, V2, E3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Vuoto_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(C1, E2, A3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Vuoto_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(C1, E2, A3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Vuoto_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(C1, E2, A3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Vuoto_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet E4 = LSet.empty();
		solver.add(union4(C1, E2, A3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Vuoto_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(C1, E2, C3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Vuoto_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(C1, E2, C3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Vuoto_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(C1, E2, C3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Vuoto_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet E4 = LSet.empty();
		solver.add(union4(C1, E2, C3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Vuoto_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(C1, E2, V3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Vuoto_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(C1, E2, V3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Vuoto_Var_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		LSet V4 = new LSet("S4");
		solver.add(union4(C1, E2, V3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Vuoto_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		LSet E4 = LSet.empty();
		solver.add(union4(C1, E2, V3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Vuoto_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(C1, E2, E3, A4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Vuoto_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(C1, E2, E3, C4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Vuoto_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		LSet V4 = new LSet("S4");
		solver.add(union4(C1, E2, E3, V4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Chiuso_Vuoto_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		LSet E4 = LSet.empty();
		solver.add(union4(C1, E2, E3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Aperto_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(V1, A2, A3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Aperto_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(V1, A2, A3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Aperto_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(V1, A2, A3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Aperto_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet E4 = LSet.empty();
		solver.add(union4(V1, A2, A3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Aperto_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(V1, A2, C3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Aperto_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(V1, A2, C3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Aperto_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(V1, A2, C3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Aperto_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet E4 = LSet.empty();
		solver.add(union4(V1, A2, C3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Aperto_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(V1, A2, V3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Aperto_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(V1, A2, V3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Aperto_Var_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		LSet V4 = new LSet("S4");
		solver.add(union4(V1, A2, V3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Aperto_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		LSet E4 = LSet.empty();
		solver.add(union4(V1, A2, V3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Aperto_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(V1, A2, E3, A4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Aperto_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(V1, A2, E3, C4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Aperto_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		LSet V4 = new LSet("S4");
		solver.add(union4(V1, A2, E3, V4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Aperto_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		LSet E4 = LSet.empty();
		solver.add(union4(V1, A2, E3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Chiuso_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(V1, C2, A3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Chiuso_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(V1, C2, A3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Chiuso_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(V1, C2, A3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Chiuso_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet E4 = LSet.empty();
		solver.add(union4(V1, C2, A3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Chiuso_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(V1, C2, C3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Chiuso_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(V1, C2, C3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Chiuso_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(V1, C2, C3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Chiuso_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet E4 = LSet.empty();
		solver.add(union4(V1, C2, C3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Chiuso_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(V1, C2, V3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Chiuso_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(V1, C2, V3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Chiuso_Var_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		LSet V4 = new LSet("S4");
		solver.add(union4(V1, C2, V3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Chiuso_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		LSet E4 = LSet.empty();
		solver.add(union4(V1, C2, V3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Chiuso_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(V1, C2, E3, A4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Chiuso_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(V1, C2, E3, C4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Chiuso_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		LSet V4 = new LSet("S4");
		solver.add(union4(V1, C2, E3, V4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Chiuso_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		LSet E4 = LSet.empty();
		solver.add(union4(V1, C2, E3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Var_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(V1, V2, A3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Var_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(V1, V2, A3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Var_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(V1, V2, A3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Var_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet E4 = LSet.empty();
		solver.add(union4(V1, V2, A3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Var_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(V1, V2, C3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Var_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(V1, V2, C3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Var_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(V1, V2, C3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Var_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet E4 = LSet.empty();
		solver.add(union4(V1, V2, C3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Var_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(V1, V2, V3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Var_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(V1, V2, V3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Var_Var_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		LSet V4 = new LSet("S4");
		solver.add(union4(V1, V2, V3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Var_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		LSet E4 = LSet.empty();
		solver.add(union4(V1, V2, V3, E4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Var_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(V1, V2, E3, A4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Var_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(V1, V2, E3, C4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Var_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		LSet V4 = new LSet("S4");
		solver.add(union4(V1, V2, E3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Var_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		LSet E4 = LSet.empty();
		solver.add(union4(V1, V2, E3, E4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Vuoto_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(V1, E2, A3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Vuoto_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(V1, E2, A3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Vuoto_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(V1, E2, A3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Vuoto_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet E4 = LSet.empty();
		solver.add(union4(V1, E2, A3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Vuoto_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(V1, E2, C3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Vuoto_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(V1, E2, C3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Vuoto_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(V1, E2, C3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Vuoto_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet E4 = LSet.empty();
		solver.add(union4(V1, E2, C3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Vuoto_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(V1, E2, V3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Vuoto_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(V1, E2, V3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Vuoto_Var_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		LSet V4 = new LSet("S4");
		solver.add(union4(V1, E2, V3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Vuoto_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		LSet E4 = LSet.empty();
		solver.add(union4(V1, E2, V3, E4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Vuoto_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(V1, E2, E3, A4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Vuoto_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(V1, E2, E3, C4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Vuoto_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		LSet V4 = new LSet("S4");
		solver.add(union4(V1, E2, E3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Var_Vuoto_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		LSet E4 = LSet.empty();
		solver.add(union4(V1, E2, E3, E4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Aperto_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(E1, A2, A3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Aperto_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(E1, A2, A3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Aperto_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(E1, A2, A3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Aperto_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet E4 = LSet.empty();
		solver.add(union4(E1, A2, A3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Aperto_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(E1, A2, C3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Aperto_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(E1, A2, C3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Aperto_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(E1, A2, C3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Aperto_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet E4 = LSet.empty();
		solver.add(union4(E1, A2, C3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Aperto_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(E1, A2, V3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Aperto_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(E1, A2, V3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Aperto_Var_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		LSet V4 = new LSet("S4");
		solver.add(union4(E1, A2, V3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Aperto_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		LSet E4 = LSet.empty();
		solver.add(union4(E1, A2, V3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Aperto_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(E1, A2, E3, A4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Aperto_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(E1, A2, E3, C4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Aperto_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		LSet V4 = new LSet("S4");
		solver.add(union4(E1, A2, E3, V4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Aperto_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		LSet E4 = LSet.empty();
		solver.add(union4(E1, A2, E3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Chiuso_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(E1, C2, A3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Chiuso_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(E1, C2, A3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Chiuso_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(E1, C2, A3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Chiuso_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet E4 = LSet.empty();
		solver.add(union4(E1, C2, A3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Chiuso_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(E1, C2, C3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Chiuso_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(E1, C2, C3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Chiuso_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(E1, C2, C3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Chiuso_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet E4 = LSet.empty();
		solver.add(union4(E1, C2, C3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Chiuso_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(E1, C2, V3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Chiuso_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(E1, C2, V3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Chiuso_Var_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		LSet V4 = new LSet("S4");
		solver.add(union4(E1, C2, V3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Chiuso_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		LSet E4 = LSet.empty();
		solver.add(union4(E1, C2, V3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Chiuso_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(E1, C2, E3, A4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Chiuso_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(E1, C2, E3, C4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Chiuso_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		LSet V4 = new LSet("S4");
		solver.add(union4(E1, C2, E3, V4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Chiuso_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		LSet E4 = LSet.empty();
		solver.add(union4(E1, C2, E3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Var_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(E1, V2, A3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Var_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(E1, V2, A3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Var_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(E1, V2, A3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Var_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet E4 = LSet.empty();
		solver.add(union4(E1, V2, A3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Var_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(E1, V2, C3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Var_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(E1, V2, C3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Var_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(E1, V2, C3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Var_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet E4 = LSet.empty();
		solver.add(union4(E1, V2, C3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Var_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(E1, V2, V3, A4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Var_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(E1, V2, V3, C4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Var_Var_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		LSet V4 = new LSet("S4");
		solver.add(union4(E1, V2, V3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Var_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		LSet E4 = LSet.empty();
		solver.add(union4(E1, V2, V3, E4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Var_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(E1, V2, E3, A4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Var_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(E1, V2, E3, C4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Var_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		LSet V4 = new LSet("S4");
		solver.add(union4(E1, V2, E3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Var_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		LSet E4 = LSet.empty();
		solver.add(union4(E1, V2, E3, E4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Vuoto_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(E1, E2, A3, A4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Vuoto_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(E1, E2, A3, C4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Vuoto_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(E1, E2, A3, V4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Vuoto_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		LSet E4 = LSet.empty();
		solver.add(union4(E1, E2, A3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Vuoto_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(E1, E2, C3, A4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Vuoto_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(E1, E2, C3, C4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Vuoto_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet V4 = new LSet("S4");
		solver.add(union4(E1, E2, C3, V4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Vuoto_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		LSet E4 = LSet.empty();
		solver.add(union4(E1, E2, C3, E4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Vuoto_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(E1, E2, V3, A4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Vuoto_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(E1, E2, V3, C4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Vuoto_Var_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		LSet V4 = new LSet("S4");
		solver.add(union4(E1, E2, V3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Vuoto_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		LSet E4 = LSet.empty();
		solver.add(union4(E1, E2, V3, E4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Vuoto_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		LSet A4 = new LSet("B4").ins(new LVar("A4"));
		solver.add(union4(E1, E2, E3, A4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Vuoto_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		LSet C4 = LSet.empty().ins(new LVar("X4")).ins(new LVar("Y4"));
		solver.add(union4(E1, E2, E3, C4));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Vuoto_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		LSet V4 = new LSet("S4");
		solver.add(union4(E1, E2, E3, V4));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion4_Vuoto_Vuoto_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		LSet E4 = LSet.empty();
		solver.add(union4(E1, E2, E3, E4));
		assertTrue(solver.check());
	
	}

}