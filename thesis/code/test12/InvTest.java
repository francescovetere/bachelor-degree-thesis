package JSetL.test.constraintTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass; 		//calcolo dei tempi
import java.io.PrintWriter; 		//stampa dei tempi
import java.io.File;			//stampa dei tempi
import java.io.FileOutputStream;	//stampa dei tempi
import JSetL.*;


public class InvTest {

	LRel genLRelFSGround(int n) {
		LPair[] values = new LPair[n];
		for(int i = 0; i < n; ++i) {values[i] = new LPair(i*2, i*2);}
		LRel res = LRel.empty().insAll(values);
		return res;
	}

	
	//somma dei tempi parziali di tutti i metodi
	private static long totTime = 0;

	@Test
	public void testInv_Aperta_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(L9.inv(L10));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testInv_Aperta_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(L9.inv(L7));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testInv_Aperta_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L5 = new LRel("L5");
		solver.add(L9.inv(L5));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testInv_Aperta_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L9 = new LRel().ins(new LPair(new LVar(), new LVar()));
		LRel L2 = LRel.empty();
		solver.add(L9.inv(L2));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testInv_ChiusaGrossaGround_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(LRelFullySpecifiedGround0.inv(L10));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testInv_ChiusaGrossaGround_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(LRelFullySpecifiedGround0.inv(L7));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testInv_ChiusaGrossaGround_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L5 = new LRel("L5");
		solver.add(LRelFullySpecifiedGround0.inv(L5));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testInv_ChiusaGrossaGround_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel LRelFullySpecifiedGround0 = genLRelFSGround(2);
		LRel L2 = LRel.empty();
		solver.add(LRelFullySpecifiedGround0.inv(L2));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testInv_Var_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(L4.inv(L10));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testInv_Var_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(L4.inv(L7));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testInv_Var_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L5 = new LRel("L5");
		solver.add(L4.inv(L5));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testInv_Var_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L4 = new LRel("L4");
		LRel L2 = LRel.empty();
		solver.add(L4.inv(L2));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testInv_Vuota_Aperta() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L10 = new LRel().ins(new LPair(new LVar(), new LVar()));
		solver.add(L1.inv(L10));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testInv_Vuota_ChiusaPiccolaNotGround() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L7 = LRel.empty().ins(new LPair(new LVar(), new LVar()));
		solver.add(L1.inv(L7));
		assertFalse(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testInv_Vuota_Var() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L5 = new LRel("L5");
		solver.add(L1.inv(L5));
		assertTrue(solver.check());
	
		//timer stop
		long stop = System.currentTimeMillis();
		synchronized(this){totTime += (stop - start);}
	}

	@Test
	public void testInv_Vuota_Vuota() {
	
		//timer start
		long start = System.currentTimeMillis();

		Solver solver = new Solver();
		LRel L1 = LRel.empty();
		LRel L2 = LRel.empty();
		solver.add(L1.inv(L2));
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
			writer.println("Inv" + " " + totTime);
			writer.close();
		} catch (Throwable t) {t.printStackTrace();}

	}

}