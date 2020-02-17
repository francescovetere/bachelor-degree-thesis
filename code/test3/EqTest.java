package JSetL.test.constraintTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass; 		//calcolo dei tempi
import java.io.PrintWriter; 		//stampa dei tempi
import java.io.File;			//stampa dei tempi
import java.io.FileOutputStream;	//stampa dei tempi
import JSetL.*;


public class EqTest {

	
	@Test
	public void testEq_Chiuso_Aperto1() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(A);
		LSet A1 = A.ins(new LVar("X"));
		solver.add(C1.eq(A1));
		assertTrue(solver.check());
	
	}

	@Test
	public void testEq_Chiuso_Aperto2() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(A);
		LSet A1 = new LSet("R").ins(A);
		solver.add(C1.eq(A1));
		assertTrue(solver.check());
	
	}

	@Test
	public void testEq_Chiuso_Chiuso() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(A);
		LSet C2 = LSet.empty().ins(A).ins(A);
		solver.add(C1.eq(C2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testEq_Chiuso_Var() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(A);
		LSet V2 = B;
		solver.add(C1.eq(V2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testEq_Var_Aperto1() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet V1 = A;
		LSet A1 = A.ins(new LVar("X"));
		solver.add(V1.eq(A1));
		assertTrue(solver.check());
	
	}

	@Test
	public void testEq_Var_Aperto2() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet V1 = A;
		LSet A1 = new LSet("R").ins(A);
		solver.add(V1.eq(A1));
		assertFalse(solver.check());
	
	}

	@Test
	public void testEq_Var_Chiuso() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet V1 = A;
		LSet C2 = LSet.empty().ins(A).ins(A);
		solver.add(V1.eq(C2));
		assertFalse(solver.check());
	
	}

	@Test
	public void testEq_Var_Var() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet V1 = A;
		LSet V2 = B;
		solver.add(V1.eq(V2));
		assertTrue(solver.check());
	
	}

}