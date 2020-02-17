package JSetL.test.constraintTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass; 		//calcolo dei tempi
import java.io.PrintWriter; 		//stampa dei tempi
import java.io.File;				//stampa dei tempi
import java.io.FileOutputStream;	//stampa dei tempi
import JSetL.*;


public class NinTest {

	
	@Test
	public void testNin_LVarBound_Aperto() {
	
		Solver solver = new Solver();
		LVar LVB = new LVar(3);
		LSet A = new LSet("B1").ins(new LVar("A1"));
		solver.add(LVB.nin(A));
		assertTrue(solver.check());
	
	}

	@Test
	public void testNin_LVarBound_Chiuso() {
	
		Solver solver = new Solver();
		LVar LVB = new LVar(3);
		LSet C = LSet.empty().ins(new LVar("A")).ins(new LVar("B"));
		solver.add(LVB.nin(C));
		assertTrue(solver.check());
	
	}

	@Test
	public void testNin_LVarBound_Var() {
	
		Solver solver = new Solver();
		LVar LVB = new LVar(3);
		LSet V = new LSet("V");
		solver.add(LVB.nin(V));
		assertTrue(solver.check());
	
	}

	@Test
	public void testNin_LVarBound_Vuoto() {
	
		Solver solver = new Solver();
		LVar LVB = new LVar(3);
		LSet E = LSet.empty();
		solver.add(LVB.nin(E));
		assertTrue(solver.check());
	
	}

	@Test
	public void testNin_LVarNotBound_Aperto() {
	
		Solver solver = new Solver();
		LVar LVNB = new LVar("X");
		LSet A = new LSet("B1").ins(new LVar("A1"));
		solver.add(LVNB.nin(A));
		assertTrue(solver.check());
	
	}

	@Test
	public void testNin_LVarNotBound_Chiuso() {
	
		Solver solver = new Solver();
		LVar LVNB = new LVar("X");
		LSet C = LSet.empty().ins(new LVar("A")).ins(new LVar("B"));
		solver.add(LVNB.nin(C));
		assertTrue(solver.check());
	
	}

	@Test
	public void testNin_LVarNotBound_Var() {
	
		Solver solver = new Solver();
		LVar LVNB = new LVar("X");
		LSet V = new LSet("V");
		solver.add(LVNB.nin(V));
		assertTrue(solver.check());
	
	}

	@Test
	public void testNin_LVarNotBound_Vuoto() {
	
		Solver solver = new Solver();
		LVar LVNB = new LVar("X");
		LSet E = LSet.empty();
		solver.add(LVNB.nin(E));
		assertTrue(solver.check());
	
	}

}