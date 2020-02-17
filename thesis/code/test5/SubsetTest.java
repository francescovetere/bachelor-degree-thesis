package JSetL.test.constraintTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass; 		//calcolo dei tempi
import java.io.PrintWriter; 		//stampa dei tempi
import java.io.File;				//stampa dei tempi
import java.io.FileOutputStream;	//stampa dei tempi
import JSetL.*;


public class SubsetTest {

	
	@Test
	public void testSubset_Aperto_Aperto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		solver.add(A1.subset(A2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSubset_Aperto_Chiuso() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		solver.add(A1.subset(C2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSubset_Aperto_Var() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet V2 = new LSet("S2");
		solver.add(A1.subset(V2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSubset_Aperto_Vuoto() {
	
		Solver solver = new Solver();
		LSet A1 = new LSet("B1").ins(new LVar("A1"));
		LSet E2 = LSet.empty();
		solver.add(A1.subset(E2));
		assertFalse(solver.check());
	
	}

	@Test
	public void testSubset_Chiuso_Aperto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		solver.add(C1.subset(A2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSubset_Chiuso_Chiuso() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		solver.add(C1.subset(C2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSubset_Chiuso_Var() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet V2 = new LSet("S2");
		solver.add(C1.subset(V2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSubset_Chiuso_Vuoto() {
	
		Solver solver = new Solver();
		LSet C1 = LSet.empty().ins(new LVar("X1")).ins(new LVar("Y1"));
		LSet E2 = LSet.empty();
		solver.add(C1.subset(E2));
		assertFalse(solver.check());
	
	}

	@Test
	public void testSubset_Var_Aperto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		solver.add(V1.subset(A2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSubset_Var_Chiuso() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		solver.add(V1.subset(C2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSubset_Var_Var() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet V2 = new LSet("S2");
		solver.add(V1.subset(V2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSubset_Var_Vuoto() {
	
		Solver solver = new Solver();
		LSet V1 = new LSet("S1");
		LSet E2 = LSet.empty();
		solver.add(V1.subset(E2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSubset_Vuoto_Aperto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet A2 = new LSet("B2").ins(new LVar("A2"));
		solver.add(E1.subset(A2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSubset_Vuoto_Chiuso() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		solver.add(E1.subset(C2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSubset_Vuoto_Var() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet V2 = new LSet("S2");
		solver.add(E1.subset(V2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSubset_Vuoto_Vuoto() {
	
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		solver.add(E1.subset(E2));
		assertTrue(solver.check());
	
	}

}