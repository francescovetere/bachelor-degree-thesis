package JSetL.test.constraintTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass; 		//calcolo dei tempi
import java.io.PrintWriter; 		//stampa dei tempi
import java.io.File;			//stampa dei tempi
import java.io.FileOutputStream;	//stampa dei tempi
import JSetL.*;


public class IdTest {

	
	//somma dei tempi parziali di tutti i metodi
	private static long totTime = 0;

	@Test
	public void testId_Aperto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L10.id(L11));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testId_Aperto_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L10.id(L8));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testId_Aperto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L5 = new LRel("L5");
		solver.add(L10.id(L5));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testId_Aperto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L10 = new LRel("L10").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L2 = LRel.empty();
		solver.add(L10.id(L2));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testId_Chiuso_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L7.id(L11));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testId_Chiuso_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L7.id(L8));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testId_Chiuso_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L5 = new LRel("L5");
		solver.add(L7.id(L5));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testId_Chiuso_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		LRel L2 = LRel.empty();
		solver.add(L7.id(L2));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testId_Var_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L4.id(L11));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testId_Var_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L4.id(L8));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testId_Var_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L5 = new LRel("L5");
		solver.add(L4.id(L5));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testId_Var_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L2 = LRel.empty();
		solver.add(L4.id(L2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testId_Vuoto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L11 = new LRel("L11").ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L1.id(L11));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testId_Vuoto_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L8 = LRel.empty().ins(new LPair(new LVar(),new LVar())).ins(new LPair(new LVar(),new LVar()));
		solver.add(L1.id(L8));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testId_Vuoto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L5 = new LRel("L5");
		solver.add(L1.id(L5));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testId_Vuoto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L2 = LRel.empty();
		solver.add(L1.id(L2));
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
			writer.println("Id" + " " + totTime);
			writer.close();
		} catch (Throwable t) {t.printStackTrace();}

	}

}