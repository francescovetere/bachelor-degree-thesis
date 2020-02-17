package JSetL.test.constraintTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass; 		//calcolo dei tempi
import java.io.PrintWriter; 		//stampa dei tempi
import java.io.File;			//stampa dei tempi
import java.io.FileOutputStream;	//stampa dei tempi
import JSetL.*;


public class DisjTest {

	LSet genLSetFSGround(int n) {
		Integer[] values = new Integer[n];
		for(int i = 0; i < n; ++i) {values[i] = i;}
		LSet res = LSet.empty().insAll(values);
		return res;
	}

	
	//somma dei tempi parziali di tutti i metodi
	private static long totTime = 0;

	@Test
	public void testDisj_Aperto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		solver.add(A1.disj(A2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testDisj_Aperto_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		solver.add(A1.disj(C2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testDisj_Aperto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		solver.add(A1.disj(V2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testDisj_Aperto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		solver.add(A1.disj(E2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testDisj_ChiusoGrossoGround_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		solver.add(LSetFullySpecifiedGround0.disj(A2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testDisj_ChiusoGrossoGround_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		solver.add(LSetFullySpecifiedGround0.disj(C2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testDisj_ChiusoGrossoGround_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet V2 = new LSet("S2");
		solver.add(LSetFullySpecifiedGround0.disj(V2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testDisj_ChiusoGrossoGround_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet LSetFullySpecifiedGround0 = genLSetFSGround(20);
		LSet E2 = LSet.empty();
		solver.add(LSetFullySpecifiedGround0.disj(E2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testDisj_Var_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		solver.add(V1.disj(A2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testDisj_Var_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		solver.add(V1.disj(C2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testDisj_Var_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		solver.add(V1.disj(V2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testDisj_Var_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		solver.add(V1.disj(E2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testDisj_Vuoto_Aperto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		solver.add(E1.disj(A2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testDisj_Vuoto_ChiusoPiccoloNonGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		solver.add(E1.disj(C2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testDisj_Vuoto_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		solver.add(E1.disj(V2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testDisj_Vuoto_Vuoto() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		solver.add(E1.disj(E2));
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
			writer.println("Disj" + " " + totTime);
			writer.close();
		} catch (Throwable t) {t.printStackTrace();}

	}

}
