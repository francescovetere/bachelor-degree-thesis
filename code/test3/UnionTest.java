package JSetL.test.constraintTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass; 		//calcolo dei tempi
import java.io.PrintWriter; 		//stampa dei tempi
import java.io.File;			//stampa dei tempi
import java.io.FileOutputStream;	//stampa dei tempi
import JSetL.*;


public class UnionTest {

	
	@Test
	public void testUnion_Chiuso_Aperto1_Chiuso() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(A);
		LSet A1 = A.ins(new LVar("X"));
		LSet C3 = LSet.empty().ins(A).ins(B).ins(C);
		solver.add(C1.union(A1, C3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion_Chiuso_Aperto1_Var() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(A);
		LSet A1 = A.ins(new LVar("X"));
		LSet V3 = B;
		solver.add(C1.union(A1, V3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion_Chiuso_Aperto2_Chiuso() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(A);
		LSet A1 = new LSet("R").ins(A);
		LSet C3 = LSet.empty().ins(A).ins(B).ins(C);
		solver.add(C1.union(A1, C3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion_Chiuso_Aperto2_Var() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(A);
		LSet A1 = new LSet("R").ins(A);
		LSet V3 = B;
		solver.add(C1.union(A1, V3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion_Chiuso_Chiuso_Chiuso() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(A);
		LSet C2 = LSet.empty().ins(A).ins(A);
		LSet C3 = LSet.empty().ins(A).ins(B).ins(C);
		solver.add(C1.union(C2, C3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion_Chiuso_Chiuso_Var() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(A);
		LSet C2 = LSet.empty().ins(A).ins(A);
		LSet V3 = B;
		solver.add(C1.union(C2, V3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion_Chiuso_Var_Chiuso() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(A);
		LSet V2 = B;
		LSet C3 = LSet.empty().ins(A).ins(B).ins(C);
		solver.add(C1.union(V2, C3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion_Chiuso_Var_Var() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(A);
		LSet V2 = B;
		LSet V3 = B;
		solver.add(C1.union(V2, V3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion_Var_Aperto1_Chiuso() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet V1 = A;
		LSet A1 = A.ins(new LVar("X"));
		LSet C3 = LSet.empty().ins(A).ins(B).ins(C);
		solver.add(V1.union(A1, C3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion_Var_Aperto1_Var() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet V1 = A;
		LSet A1 = A.ins(new LVar("X"));
		LSet V3 = B;
		solver.add(V1.union(A1, V3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion_Var_Aperto2_Chiuso() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet V1 = A;
		LSet A1 = new LSet("R").ins(A);
		LSet C3 = LSet.empty().ins(A).ins(B).ins(C);
		solver.add(V1.union(A1, C3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion_Var_Aperto2_Var() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet V1 = A;
		LSet A1 = new LSet("R").ins(A);
		LSet V3 = B;
		solver.add(V1.union(A1, V3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion_Var_Chiuso_Chiuso() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet V1 = A;
		LSet C2 = LSet.empty().ins(A).ins(A);
		LSet C3 = LSet.empty().ins(A).ins(B).ins(C);
		solver.add(V1.union(C2, C3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion_Var_Chiuso_Var() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet V1 = A;
		LSet C2 = LSet.empty().ins(A).ins(A);
		LSet V3 = B;
		solver.add(V1.union(C2, V3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testUnion_Var_Var_Chiuso() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet V1 = A;
		LSet V2 = B;
		LSet C3 = LSet.empty().ins(A).ins(B).ins(C);
		solver.add(V1.union(V2, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testUnion_Var_Var_Var() {
	LSet A = new LSet("A");
		LSet B = new LSet("B");
		
		Solver solver = new Solver();
		LSet V1 = A;
		LSet V2 = B;
		LSet V3 = B;
		solver.add(V1.union(V2, V3));
		assertTrue(solver.check());
	
	}

}