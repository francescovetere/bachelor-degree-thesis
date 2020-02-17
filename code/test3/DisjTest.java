package JSetL.test.constraintTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass; 		//calcolo dei tempi
import java.io.PrintWriter; 		//stampa dei tempi
import java.io.File;			//stampa dei tempi
import java.io.FileOutputStream;	//stampa dei tempi
import JSetL.*;


public class DisjTest {

	
	@Test
	public void testDisj_Chiuso_Aperto1() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(A);
		LSet A1 = A.ins(new LVar("X"));
		solver.add(C1.disj(A1));
		assertTrue(solver.check());
	
	}

	@Test
	public void testDisj_Chiuso_Aperto2() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(A);
		LSet A1 = new LSet("R").ins(A);
		solver.add(C1.disj(A1));
		assertFalse(solver.check());
	
	}

	@Test
	public void testDisj_Chiuso_Chiuso() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(A);
		LSet C2 = LSet.empty().ins(A).ins(A);
		solver.add(C1.disj(C2));
		assertFalse(solver.check());
	
	}

	@Test
	public void testDisj_Chiuso_Var() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(A);
		LSet V2 = B;
		solver.add(C1.disj(V2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testDisj_Var_Aperto1() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet V1 = A;
		LSet A1 = A.ins(new LVar("X"));
		solver.add(V1.disj(A1));
		assertTrue(solver.check());
	
	}

	@Test
	public void testDisj_Var_Aperto2() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet V1 = A;
		LSet A1 = new LSet("R").ins(A);
		solver.add(V1.disj(A1));
		assertTrue(solver.check());
	
	}

	@Test
	public void testDisj_Var_Chiuso() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet V1 = A;
		LSet C2 = LSet.empty().ins(A).ins(A);
		solver.add(V1.disj(C2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testDisj_Var_Var() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet V1 = A;
		LSet V2 = B;
		solver.add(V1.disj(V2));
		assertTrue(solver.check());
	
	}

}