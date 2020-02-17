package JSetL.test.constraintTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass; 		//calcolo dei tempi
import java.io.PrintWriter; 		//stampa dei tempi
import java.io.File;			//stampa dei tempi
import java.io.FileOutputStream;	//stampa dei tempi
import JSetL.*;


public class UnionTest {

	LSet genLSetFSGround(int n) {
		Integer[] values = new Integer[n];
		for(int i = 0; i < n; ++i) {values[i] = i;}
		LSet res = LSet.empty().insAll(values);
		return res;
	}

	
	//somma dei tempi parziali di tutti i metodi
	private static long totTime = 0;

	@Test
	public void testUnion_Aperto_Aperto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(A1.union(A2, A3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Aperto_Aperto_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(A1.union(A2, C3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Aperto_Aperto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		solver.add(A1.union(A2, V3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Aperto_Aperto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		solver.add(A1.union(A2, E3));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Aperto_ChiusoPiccoloNonGround_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(A1.union(C2, A3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Aperto_ChiusoPiccoloNonGround_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(A1.union(C2, C3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Aperto_ChiusoPiccoloNonGround_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		solver.add(A1.union(C2, V3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Aperto_ChiusoPiccoloNonGround_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		solver.add(A1.union(C2, E3));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Aperto_Var_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(A1.union(V2, A3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Aperto_Var_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(A1.union(V2, C3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Aperto_Var_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		solver.add(A1.union(V2, V3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Aperto_Var_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		solver.add(A1.union(V2, E3));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Aperto_Vuoto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(A1.union(E2, A3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Aperto_Vuoto_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(A1.union(E2, C3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Aperto_Vuoto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		solver.add(A1.union(E2, V3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Aperto_Vuoto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		solver.add(A1.union(E2, E3));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_ChiusoGrossoGround_Aperto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(LSetFullySpecifiedGround0.union(A2, A3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_ChiusoGrossoGround_Aperto_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(LSetFullySpecifiedGround0.union(A2, C3));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_ChiusoGrossoGround_Aperto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		solver.add(LSetFullySpecifiedGround0.union(A2, V3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_ChiusoGrossoGround_Aperto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		solver.add(LSetFullySpecifiedGround0.union(A2, E3));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_ChiusoGrossoGround_ChiusoPiccoloNonGround_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(LSetFullySpecifiedGround0.union(C2, A3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_ChiusoGrossoGround_ChiusoPiccoloNonGround_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(LSetFullySpecifiedGround0.union(C2, C3));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_ChiusoGrossoGround_ChiusoPiccoloNonGround_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		solver.add(LSetFullySpecifiedGround0.union(C2, V3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_ChiusoGrossoGround_ChiusoPiccoloNonGround_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		solver.add(LSetFullySpecifiedGround0.union(C2, E3));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_ChiusoGrossoGround_Var_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(LSetFullySpecifiedGround0.union(V2, A3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_ChiusoGrossoGround_Var_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(LSetFullySpecifiedGround0.union(V2, C3));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_ChiusoGrossoGround_Var_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		solver.add(LSetFullySpecifiedGround0.union(V2, V3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_ChiusoGrossoGround_Var_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		solver.add(LSetFullySpecifiedGround0.union(V2, E3));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_ChiusoGrossoGround_Vuoto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(LSetFullySpecifiedGround0.union(E2, A3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_ChiusoGrossoGround_Vuoto_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(LSetFullySpecifiedGround0.union(E2, C3));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_ChiusoGrossoGround_Vuoto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		solver.add(LSetFullySpecifiedGround0.union(E2, V3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_ChiusoGrossoGround_Vuoto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		solver.add(LSetFullySpecifiedGround0.union(E2, E3));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Var_Aperto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(V1.union(A2, A3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Var_Aperto_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(V1.union(A2, C3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Var_Aperto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		solver.add(V1.union(A2, V3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Var_Aperto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		solver.add(V1.union(A2, E3));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Var_ChiusoPiccoloNonGround_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(V1.union(C2, A3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Var_ChiusoPiccoloNonGround_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(V1.union(C2, C3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Var_ChiusoPiccoloNonGround_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		solver.add(V1.union(C2, V3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Var_ChiusoPiccoloNonGround_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		solver.add(V1.union(C2, E3));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Var_Var_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(V1.union(V2, A3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Var_Var_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(V1.union(V2, C3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Var_Var_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		solver.add(V1.union(V2, V3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Var_Var_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		solver.add(V1.union(V2, E3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Var_Vuoto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(V1.union(E2, A3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Var_Vuoto_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(V1.union(E2, C3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Var_Vuoto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		solver.add(V1.union(E2, V3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Var_Vuoto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		solver.add(V1.union(E2, E3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Vuoto_Aperto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(E1.union(A2, A3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Vuoto_Aperto_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(E1.union(A2, C3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Vuoto_Aperto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet V3 = new LSet("S3");
		solver.add(E1.union(A2, V3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Vuoto_Aperto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		LSet E3 = LSet.empty();
		solver.add(E1.union(A2, E3));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Vuoto_ChiusoPiccoloNonGround_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(E1.union(C2, A3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Vuoto_ChiusoPiccoloNonGround_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(E1.union(C2, C3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Vuoto_ChiusoPiccoloNonGround_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet V3 = new LSet("S3");
		solver.add(E1.union(C2, V3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Vuoto_ChiusoPiccoloNonGround_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		LSet E3 = LSet.empty();
		solver.add(E1.union(C2, E3));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Vuoto_Var_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(E1.union(V2, A3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Vuoto_Var_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(E1.union(V2, C3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Vuoto_Var_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet V3 = new LSet("S3");
		solver.add(E1.union(V2, V3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Vuoto_Var_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		LSet E3 = LSet.empty();
		solver.add(E1.union(V2, E3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Vuoto_Vuoto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet A3 = new LSet("B3").ins(new LVar("A3"));
		solver.add(E1.union(E2, A3));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Vuoto_Vuoto_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(E1.union(E2, C3));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Vuoto_Vuoto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet V3 = new LSet("S3");
		solver.add(E1.union(E2, V3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testUnion_Vuoto_Vuoto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		LSet E3 = LSet.empty();
		solver.add(E1.union(E2, E3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@AfterClass
	public static void printTotTime() {
		PrintWriter writer;
		try {
			String dir  = "/home/francesco/Documenti/tirocinio/generazione_test/test_cases_generator/test11/";
			writer = new PrintWriter(new FileOutputStream(new File(dir +  "times.txt"),true));
			writer.println("Union" + " " + totTime);
			writer.close();
		} catch (Throwable t) {t.printStackTrace();}

	}

}
