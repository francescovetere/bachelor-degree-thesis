package JSetL.test.constraintTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass; 		//calcolo dei tempi
import java.io.PrintWriter; 		//stampa dei tempi
import java.io.File;				//stampa dei tempi
import java.io.FileOutputStream;	//stampa dei tempi
import JSetL.*;


public class SizeTest {

	
	@Test
	public void testSize_Aperto_LVarBound1() {
	
		Solver solver = new Solver();
		LSet A = new LSet("B1").ins(new LVar("A1"));
		IntLVar LVB1 = new IntLVar(1);
		solver.add(A.size(LVB1));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSize_Aperto_LVarBound2() {
	
		Solver solver = new Solver();
		LSet A = new LSet("B1").ins(new LVar("A1"));
		IntLVar LVB2 = new IntLVar(2);
		solver.add(A.size(LVB2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSize_Aperto_LVarBound3() {
	
		Solver solver = new Solver();
		LSet A = new LSet("B1").ins(new LVar("A1"));
		IntLVar LVB3 = new IntLVar(3);
		solver.add(A.size(LVB3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSize_Aperto_LVarNotBound() {
	
		Solver solver = new Solver();
		LSet A = new LSet("B1").ins(new LVar("A1"));
		IntLVar LVNB = new IntLVar("N");
		solver.add(A.size(LVNB));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSize_Chiuso_LVarBound1() {
	
		Solver solver = new Solver();
		LSet C = LSet.empty().ins(new LVar("A")).ins(new LVar("B"));
		IntLVar LVB1 = new IntLVar(1);
		solver.add(C.size(LVB1));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSize_Chiuso_LVarBound2() {
	
		Solver solver = new Solver();
		LSet C = LSet.empty().ins(new LVar("A")).ins(new LVar("B"));
		IntLVar LVB2 = new IntLVar(2);
		solver.add(C.size(LVB2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSize_Chiuso_LVarBound3() {
	
		Solver solver = new Solver();
		LSet C = LSet.empty().ins(new LVar("A")).ins(new LVar("B"));
		IntLVar LVB3 = new IntLVar(3);
		solver.add(C.size(LVB3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testSize_Chiuso_LVarNotBound() {
	
		Solver solver = new Solver();
		LSet C = LSet.empty().ins(new LVar("A")).ins(new LVar("B"));
		IntLVar LVNB = new IntLVar("N");
		solver.add(C.size(LVNB));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSize_Var_LVarBound1() {
	
		Solver solver = new Solver();
		LSet V = new LSet("V");
		IntLVar LVB1 = new IntLVar(1);
		solver.add(V.size(LVB1));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSize_Var_LVarBound2() {
	
		Solver solver = new Solver();
		LSet V = new LSet("V");
		IntLVar LVB2 = new IntLVar(2);
		solver.add(V.size(LVB2));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSize_Var_LVarBound3() {
	
		Solver solver = new Solver();
		LSet V = new LSet("V");
		IntLVar LVB3 = new IntLVar(3);
		solver.add(V.size(LVB3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSize_Var_LVarNotBound() {
	
		Solver solver = new Solver();
		LSet V = new LSet("V");
		IntLVar LVNB = new IntLVar("N");
		solver.add(V.size(LVNB));
		assertTrue(solver.check());
	
	}

	@Test
	public void testSize_Vuoto_LVarBound1() {
	
		Solver solver = new Solver();
		LSet E = LSet.empty();
		IntLVar LVB1 = new IntLVar(1);
		solver.add(E.size(LVB1));
		assertFalse(solver.check());
	
	}

	@Test
	public void testSize_Vuoto_LVarBound2() {
	
		Solver solver = new Solver();
		LSet E = LSet.empty();
		IntLVar LVB2 = new IntLVar(2);
		solver.add(E.size(LVB2));
		assertFalse(solver.check());
	
	}

	@Test
	public void testSize_Vuoto_LVarBound3() {
	
		Solver solver = new Solver();
		LSet E = LSet.empty();
		IntLVar LVB3 = new IntLVar(3);
		solver.add(E.size(LVB3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testSize_Vuoto_LVarNotBound() {
	
		Solver solver = new Solver();
		LSet E = LSet.empty();
		IntLVar LVNB = new IntLVar("N");
		solver.add(E.size(LVNB));
		assertTrue(solver.check());
	
	}

}