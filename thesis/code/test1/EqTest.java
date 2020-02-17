package JSetL.test.constraintTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass; 		//calcolo dei tempi
import java.io.PrintWriter; 		//stampa dei tempi
import java.io.File;			//stampa dei tempi
import java.io.FileOutputStream;	//stampa dei tempi
import JSetL.*;


public class EqTest {

	
	//somma dei tempi parziali di tutti i metodi
	private static long totTime = 0;

	@Test
	public void testEq_Aperto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		solver.add(A1.eq(A2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testEq_Aperto_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		solver.add(A1.eq(C2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testEq_Aperto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		solver.add(A1.eq(V2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testEq_Aperto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		solver.add(A1.eq(E2));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testEq_Chiuso_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		solver.add(C1.eq(A2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testEq_Chiuso_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		solver.add(C1.eq(C2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testEq_Chiuso_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		solver.add(C1.eq(V2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testEq_Chiuso_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		solver.add(C1.eq(E2));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testEq_Var_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		solver.add(V1.eq(A2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testEq_Var_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		solver.add(V1.eq(C2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testEq_Var_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		solver.add(V1.eq(V2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testEq_Var_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		solver.add(V1.eq(E2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testEq_Vuoto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		solver.add(E1.eq(A2));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testEq_Vuoto_Chiuso() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		solver.add(E1.eq(C2));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testEq_Vuoto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		solver.add(E1.eq(V2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testEq_Vuoto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		solver.add(E1.eq(E2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@AfterClass
	public static void printTotTime() {
		PrintWriter writer;
		try {
			String dir  = "/home/francesco/Documenti/tirocinio/generazione_test/test_cases_generator/test1/";
			writer = new PrintWriter(new FileOutputStream(new File(dir +  "times.txt"),true));
			writer.println("Eq" + " " + totTime);
			writer.close();
		} catch (Throwable t) {t.printStackTrace();}

	}

}