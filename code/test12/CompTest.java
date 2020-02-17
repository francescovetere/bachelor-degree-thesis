package JSetL.test.constraintTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass; 		//calcolo dei tempi
import java.io.PrintWriter; 		//stampa dei tempi
import java.io.File;			//stampa dei tempi
import java.io.FileOutputStream;	//stampa dei tempi
import JSetL.*;


public class CompTest {

	LRel genLRelFSGround(int n) {
		LPair[] values = new LPair[n];
		for(int i = 0; i < n; ++i) {values[i] = new LPair(i*2, i*2);}
		LRel res = LRel.empty().insAll(values);
		return res;
	}

	
	//somma dei tempi parziali di tutti i metodi
	private static long totTime = 0;

	@Test
	public void testComp_Aperta_Aperta_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L11 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(L9.comp(L10, L11));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperta_Aperta_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L8 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(L9.comp(L10, L8));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperta_Aperta_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L6 = new LRel("L6");
		solver.add(L9.comp(L10, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperta_Aperta_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L3 = LRel.empty();
		solver.add(L9.comp(L10, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperta_ChiusaPiccolaNotGround_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		LRel L11 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(L9.comp(L7, L11));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperta_ChiusaPiccolaNotGround_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		LRel L8 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(L9.comp(L7, L8));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperta_ChiusaPiccolaNotGround_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		LRel L6 = new LRel("L6");
		solver.add(L9.comp(L7, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperta_ChiusaPiccolaNotGround_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		LRel L3 = LRel.empty();
		solver.add(L9.comp(L7, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperta_Var_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L5 = new LRel("L5");
		LRel L11 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(L9.comp(L5, L11));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperta_Var_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L5 = new LRel("L5");
		LRel L8 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(L9.comp(L5, L8));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperta_Var_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L5 = new LRel("L5");
		LRel L6 = new LRel("L6");
		solver.add(L9.comp(L5, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperta_Var_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L5 = new LRel("L5");
		LRel L3 = LRel.empty();
		solver.add(L9.comp(L5, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperta_Vuota_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L2 = LRel.empty();
		LRel L11 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(L9.comp(L2, L11));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperta_Vuota_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L2 = LRel.empty();
		LRel L8 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(L9.comp(L2, L8));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperta_Vuota_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L2 = LRel.empty();
		LRel L6 = new LRel("L6");
		solver.add(L9.comp(L2, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperta_Vuota_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L2 = LRel.empty();
		LRel L3 = LRel.empty();
		solver.add(L9.comp(L2, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_ChiusaGrossaGround_Aperta_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L11 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(LRelFullySpecifiedGround0.comp(L10, L11));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_ChiusaGrossaGround_Aperta_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L8 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(LRelFullySpecifiedGround0.comp(L10, L8));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_ChiusaGrossaGround_Aperta_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L6 = new LRel("L6");
		solver.add(LRelFullySpecifiedGround0.comp(L10, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_ChiusaGrossaGround_Aperta_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L3 = LRel.empty();
		solver.add(LRelFullySpecifiedGround0.comp(L10, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_ChiusaGrossaGround_ChiusaPiccolaNotGround_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		LRel L11 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(LRelFullySpecifiedGround0.comp(L7, L11));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_ChiusaGrossaGround_ChiusaPiccolaNotGround_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		LRel L8 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(LRelFullySpecifiedGround0.comp(L7, L8));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_ChiusaGrossaGround_ChiusaPiccolaNotGround_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		LRel L6 = new LRel("L6");
		solver.add(LRelFullySpecifiedGround0.comp(L7, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_ChiusaGrossaGround_ChiusaPiccolaNotGround_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		LRel L3 = LRel.empty();
		solver.add(LRelFullySpecifiedGround0.comp(L7, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_ChiusaGrossaGround_Var_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L5 = new LRel("L5");
		LRel L11 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(LRelFullySpecifiedGround0.comp(L5, L11));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_ChiusaGrossaGround_Var_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L5 = new LRel("L5");
		LRel L8 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(LRelFullySpecifiedGround0.comp(L5, L8));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_ChiusaGrossaGround_Var_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L5 = new LRel("L5");
		LRel L6 = new LRel("L6");
		solver.add(LRelFullySpecifiedGround0.comp(L5, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_ChiusaGrossaGround_Var_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L5 = new LRel("L5");
		LRel L3 = LRel.empty();
		solver.add(LRelFullySpecifiedGround0.comp(L5, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_ChiusaGrossaGround_Vuota_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L2 = LRel.empty();
		LRel L11 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(LRelFullySpecifiedGround0.comp(L2, L11));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_ChiusaGrossaGround_Vuota_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L2 = LRel.empty();
		LRel L8 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(LRelFullySpecifiedGround0.comp(L2, L8));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_ChiusaGrossaGround_Vuota_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L2 = LRel.empty();
		LRel L6 = new LRel("L6");
		solver.add(LRelFullySpecifiedGround0.comp(L2, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_ChiusaGrossaGround_Vuota_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L2 = LRel.empty();
		LRel L3 = LRel.empty();
		solver.add(LRelFullySpecifiedGround0.comp(L2, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Aperta_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L11 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(L4.comp(L10, L11));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Aperta_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L8 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(L4.comp(L10, L8));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Aperta_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L6 = new LRel("L6");
		solver.add(L4.comp(L10, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Aperta_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L3 = LRel.empty();
		solver.add(L4.comp(L10, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_ChiusaPiccolaNotGround_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		LRel L11 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(L4.comp(L7, L11));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_ChiusaPiccolaNotGround_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		LRel L8 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(L4.comp(L7, L8));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_ChiusaPiccolaNotGround_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		LRel L6 = new LRel("L6");
		solver.add(L4.comp(L7, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_ChiusaPiccolaNotGround_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		LRel L3 = LRel.empty();
		solver.add(L4.comp(L7, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Var_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L5 = new LRel("L5");
		LRel L11 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(L4.comp(L5, L11));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Var_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L5 = new LRel("L5");
		LRel L8 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(L4.comp(L5, L8));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Var_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L5 = new LRel("L5");
		LRel L6 = new LRel("L6");
		solver.add(L4.comp(L5, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Var_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L5 = new LRel("L5");
		LRel L3 = LRel.empty();
		solver.add(L4.comp(L5, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Vuota_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L2 = LRel.empty();
		LRel L11 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(L4.comp(L2, L11));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Vuota_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L2 = LRel.empty();
		LRel L8 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(L4.comp(L2, L8));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Vuota_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L2 = LRel.empty();
		LRel L6 = new LRel("L6");
		solver.add(L4.comp(L2, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Vuota_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L2 = LRel.empty();
		LRel L3 = LRel.empty();
		solver.add(L4.comp(L2, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuota_Aperta_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L11 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(L1.comp(L10, L11));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuota_Aperta_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L8 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(L1.comp(L10, L8));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuota_Aperta_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L6 = new LRel("L6");
		solver.add(L1.comp(L10, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuota_Aperta_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L3 = LRel.empty();
		solver.add(L1.comp(L10, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuota_ChiusaPiccolaNotGround_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		LRel L11 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(L1.comp(L7, L11));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuota_ChiusaPiccolaNotGround_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		LRel L8 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(L1.comp(L7, L8));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuota_ChiusaPiccolaNotGround_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		LRel L6 = new LRel("L6");
		solver.add(L1.comp(L7, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuota_ChiusaPiccolaNotGround_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		LRel L3 = LRel.empty();
		solver.add(L1.comp(L7, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuota_Var_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L5 = new LRel("L5");
		LRel L11 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(L1.comp(L5, L11));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuota_Var_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L5 = new LRel("L5");
		LRel L8 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(L1.comp(L5, L8));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuota_Var_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L5 = new LRel("L5");
		LRel L6 = new LRel("L6");
		solver.add(L1.comp(L5, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuota_Var_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L5 = new LRel("L5");
		LRel L3 = LRel.empty();
		solver.add(L1.comp(L5, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuota_Vuota_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L2 = LRel.empty();
		LRel L11 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(L1.comp(L2, L11));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuota_Vuota_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L2 = LRel.empty();
		LRel L8 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(L1.comp(L2, L8));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuota_Vuota_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L2 = LRel.empty();
		LRel L6 = new LRel("L6");
		solver.add(L1.comp(L2, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuota_Vuota_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L2 = LRel.empty();
		LRel L3 = LRel.empty();
		solver.add(L1.comp(L2, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@AfterClass
	public static void printTotTime() {
		PrintWriter writer;
		try {
			String dir  = "/home/francesco/Documenti/tirocinio/generazione_test/test_cases_generator/test12/";
			writer = new PrintWriter(new FileOutputStream(new File(dir +  "times.txt"),true));
			writer.println("Comp" + " " + totTime);
			writer.close();
		} catch (Throwable t) {t.printStackTrace();}

	}

}