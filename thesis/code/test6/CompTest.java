package JSetL.test.constraintTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass; 		//calcolo dei tempi
import java.io.PrintWriter; 		//stampa dei tempi
import java.io.File;			//stampa dei tempi
import java.io.FileOutputStream;	//stampa dei tempi
import JSetL.*;


public class CompTest {

	
	//somma dei tempi parziali di tutti i metodi
	private static long totTime = 0;

	@Test
	public void testComp_Aperto_Aperto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L12 = new LRel("L12").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L10.comp(L11, L12));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperto_Aperto_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L9 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L10.comp(L11, L9));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperto_Aperto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L6 = new LRel("L6");
		solver.add(L10.comp(L11, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperto_Aperto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L3 = LRel.empty();
		solver.add(L10.comp(L11, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperto_Chiuso_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L12 = new LRel("L12").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L10.comp(L8, L12));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperto_Chiuso_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L9 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L10.comp(L8, L9));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperto_Chiuso_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L6 = new LRel("L6");
		solver.add(L10.comp(L8, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperto_Chiuso_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L3 = LRel.empty();
		solver.add(L10.comp(L8, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperto_Var_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L5 = new LRel("L5");
		LRel L12 = new LRel("L12").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L10.comp(L5, L12));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperto_Var_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L5 = new LRel("L5");
		LRel L9 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L10.comp(L5, L9));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperto_Var_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L5 = new LRel("L5");
		LRel L6 = new LRel("L6");
		solver.add(L10.comp(L5, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperto_Var_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L5 = new LRel("L5");
		LRel L3 = LRel.empty();
		solver.add(L10.comp(L5, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperto_Vuoto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L2 = LRel.empty();
		LRel L12 = new LRel("L12").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L10.comp(L2, L12));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperto_Vuoto_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L2 = LRel.empty();
		LRel L9 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L10.comp(L2, L9));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperto_Vuoto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L2 = LRel.empty();
		LRel L6 = new LRel("L6");
		solver.add(L10.comp(L2, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Aperto_Vuoto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L2 = LRel.empty();
		LRel L3 = LRel.empty();
		solver.add(L10.comp(L2, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Chiuso_Aperto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L12 = new LRel("L12").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L7.comp(L11, L12));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Chiuso_Aperto_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L9 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L7.comp(L11, L9));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Chiuso_Aperto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L6 = new LRel("L6");
		solver.add(L7.comp(L11, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Chiuso_Aperto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L3 = LRel.empty();
		solver.add(L7.comp(L11, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Chiuso_Chiuso_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L12 = new LRel("L12").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L7.comp(L8, L12));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Chiuso_Chiuso_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L9 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L7.comp(L8, L9));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Chiuso_Chiuso_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L6 = new LRel("L6");
		solver.add(L7.comp(L8, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Chiuso_Chiuso_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L3 = LRel.empty();
		solver.add(L7.comp(L8, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Chiuso_Var_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L5 = new LRel("L5");
		LRel L12 = new LRel("L12").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L7.comp(L5, L12));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Chiuso_Var_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L5 = new LRel("L5");
		LRel L9 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L7.comp(L5, L9));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Chiuso_Var_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L5 = new LRel("L5");
		LRel L6 = new LRel("L6");
		solver.add(L7.comp(L5, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Chiuso_Var_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L5 = new LRel("L5");
		LRel L3 = LRel.empty();
		solver.add(L7.comp(L5, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Chiuso_Vuoto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L2 = LRel.empty();
		LRel L12 = new LRel("L12").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L7.comp(L2, L12));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Chiuso_Vuoto_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L2 = LRel.empty();
		LRel L9 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L7.comp(L2, L9));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Chiuso_Vuoto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L2 = LRel.empty();
		LRel L6 = new LRel("L6");
		solver.add(L7.comp(L2, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Chiuso_Vuoto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L2 = LRel.empty();
		LRel L3 = LRel.empty();
		solver.add(L7.comp(L2, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Aperto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L12 = new LRel("L12").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L4.comp(L11, L12));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Aperto_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L9 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L4.comp(L11, L9));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Aperto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L6 = new LRel("L6");
		solver.add(L4.comp(L11, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Aperto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L3 = LRel.empty();
		solver.add(L4.comp(L11, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Chiuso_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L12 = new LRel("L12").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L4.comp(L8, L12));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Chiuso_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L9 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L4.comp(L8, L9));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Chiuso_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L6 = new LRel("L6");
		solver.add(L4.comp(L8, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Chiuso_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L3 = LRel.empty();
		solver.add(L4.comp(L8, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Var_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L5 = new LRel("L5");
		LRel L12 = new LRel("L12").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L4.comp(L5, L12));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Var_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L5 = new LRel("L5");
		LRel L9 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L4.comp(L5, L9));
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
	public void testComp_Var_Var_Vuoto() {
	
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
	public void testComp_Var_Vuoto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L2 = LRel.empty();
		LRel L12 = new LRel("L12").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L4.comp(L2, L12));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Vuoto_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L2 = LRel.empty();
		LRel L9 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L4.comp(L2, L9));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Var_Vuoto_Var() {
	
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
	public void testComp_Var_Vuoto_Vuoto() {
	
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
	public void testComp_Vuoto_Aperto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L12 = new LRel("L12").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L1.comp(L11, L12));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuoto_Aperto_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L9 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L1.comp(L11, L9));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuoto_Aperto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L6 = new LRel("L6");
		solver.add(L1.comp(L11, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuoto_Aperto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L3 = LRel.empty();
		solver.add(L1.comp(L11, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuoto_Chiuso_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L12 = new LRel("L12").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L1.comp(L8, L12));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuoto_Chiuso_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L9 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L1.comp(L8, L9));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuoto_Chiuso_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L6 = new LRel("L6");
		solver.add(L1.comp(L8, L6));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuoto_Chiuso_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L3 = LRel.empty();
		solver.add(L1.comp(L8, L3));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuoto_Var_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L5 = new LRel("L5");
		LRel L12 = new LRel("L12").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L1.comp(L5, L12));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuoto_Var_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L5 = new LRel("L5");
		LRel L9 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L1.comp(L5, L9));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuoto_Var_Var() {
	
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
	public void testComp_Vuoto_Var_Vuoto() {
	
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
	public void testComp_Vuoto_Vuoto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L2 = LRel.empty();
		LRel L12 = new LRel("L12").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L1.comp(L2, L12));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuoto_Vuoto_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L2 = LRel.empty();
		LRel L9 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L1.comp(L2, L9));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testComp_Vuoto_Vuoto_Var() {
	
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
	public void testComp_Vuoto_Vuoto_Vuoto() {
	
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
			String dir  = "/home/francesco/Documenti/tirocinio/generazione_test/test_cases_generator/test6/";
			writer = new PrintWriter(new FileOutputStream(new File(dir +  "times.txt"),true));
			writer.println("Comp" + " " + totTime);
			writer.close();
		} catch (Throwable t) {t.printStackTrace();}

	}

}