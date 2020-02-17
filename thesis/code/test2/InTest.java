package JSetL.test.constraintTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass; 		//calcolo dei tempi
import java.io.PrintWriter; 		//stampa dei tempi
import java.io.File;				//stampa dei tempi
import java.io.FileOutputStream;	//stampa dei tempi
import JSetL.*;


public class InTest {

	
	@Test
	public void testIn_LVarBound_Aperto() {
	
		Solver solver = new Solver();
		LVar LVB = new LVar(3);
		LSet A = new LSet("B1").ins(new LVar("A1"));
		solver.add(LVB.in(A));
		assertTrue(solver.check());
	
	}

	@Test
	public void testIn_LVarBound_Chiuso() {
	
		Solver solver = new Solver();
		LVar LVB = new LVar(3);
		LSet C = LSet.empty().ins(new LVar("A")).ins(new LVar("B"));
		solver.add(LVB.in(C));
		assertTrue(solver.check());
	
	}

	@Test
	public void testIn_LVarBound_Var() {
	
		Solver solver = new Solver();
		LVar LVB = new LVar(3);
		LSet V = new LSet("V");
		solver.add(LVB.in(V));
		assertTrue(solver.check());
	
	}

	@Test
	public void testIn_LVarBound_Vuoto() {
	
		Solver solver = new Solver();
		LVar LVB = new LVar(3);
		LSet E = LSet.empty();
		solver.add(LVB.in(E));
		assertFalse(solver.check());
	
	}

	@Test
	public void testIn_LVarNotBound_Aperto() {
	
		Solver solver = new Solver();
		LVar LVNB = new LVar("X");
		LSet A = new LSet("B1").ins(new LVar("A1"));
		solver.add(LVNB.in(A));
		assertTrue(solver.check());
	
	}

	@Test
	public void testIn_LVarNotBound_Chiuso() {
	
		Solver solver = new Solver();
		LVar LVNB = new LVar("X");
		LSet C = LSet.empty().ins(new LVar("A")).ins(new LVar("B"));
		solver.add(LVNB.in(C));
		assertTrue(solver.check());
	
	}

	@Test
	public void testIn_LVarNotBound_Var() {
	
		Solver solver = new Solver();
		LVar LVNB = new LVar("X");
		LSet V = new LSet("V");
		solver.add(LVNB.in(V));
		assertTrue(solver.check());
	
	}

	@Test
	public void testIn_LVarNotBound_Vuoto() {
	
		Solver solver = new Solver();
		LVar LVNB = new LVar("X");
		LSet E = LSet.empty();
		solver.add(LVNB.in(E));
		assertFalse(solver.check());
	
	}

}