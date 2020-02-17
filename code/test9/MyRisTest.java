package JSetL.test.constraintTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass; 		//calcolo dei tempi
import java.io.PrintWriter; 		//stampa dei tempi
import java.io.File;			//stampa dei tempi
import java.io.FileOutputStream;	//stampa dei tempi
import JSetL.*;


public class MyRisTest {

	public Constraint myRis(LVar controlTerm, LSet domain, Constraint filter, LObject pattern, LSet insiemeDaUnificare) {
		return insiemeDaUnificare.eq(new Ris(controlTerm, domain, filter, pattern));
	}
	
	@Test
	public void testMyRis_Lvar_Chiuso_FiltroCustom_Pattern1_Chiuso() {
	
		Solver solver = new Solver();
		LVar LV1 = new LVar("LV1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		Constraint ConstrCustom = LV1.eq(4);
		LObject pattern1 = LV1;
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myRis(LV1, C2, ConstrCustom, pattern1, C3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testMyRis_Lvar_Chiuso_FiltroCustom_Pattern1_Vuoto() {
	
		Solver solver = new Solver();
		LVar LV1 = new LVar("LV1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		Constraint ConstrCustom = LV1.eq(4);
		LObject pattern1 = LV1;
		LSet E3 = LSet.empty();
		solver.add(myRis(LV1, C2, ConstrCustom, pattern1, E3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testMyRis_Lvar_Chiuso_FiltroFalse_Pattern1_Chiuso() {
	
		Solver solver = new Solver();
		LVar LV1 = new LVar("LV1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		Constraint ConstrFalse = new Constraint("_false");
		LObject pattern1 = LV1;
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myRis(LV1, C2, ConstrFalse, pattern1, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyRis_Lvar_Chiuso_FiltroFalse_Pattern1_Vuoto() {
	
		Solver solver = new Solver();
		LVar LV1 = new LVar("LV1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		Constraint ConstrFalse = new Constraint("_false");
		LObject pattern1 = LV1;
		LSet E3 = LSet.empty();
		solver.add(myRis(LV1, C2, ConstrFalse, pattern1, E3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testMyRis_Lvar_Chiuso_FiltroTrue_Pattern1_Chiuso() {
	
		Solver solver = new Solver();
		LVar LV1 = new LVar("LV1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		Constraint ConstrTrue = new Constraint("_true");
		LObject pattern1 = LV1;
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myRis(LV1, C2, ConstrTrue, pattern1, C3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testMyRis_Lvar_Chiuso_FiltroTrue_Pattern1_Vuoto() {
	
		Solver solver = new Solver();
		LVar LV1 = new LVar("LV1");
		LSet C2 = LSet.empty().ins(new LVar("X2")).ins(new LVar("Y2"));
		Constraint ConstrTrue = new Constraint("_true");
		LObject pattern1 = LV1;
		LSet E3 = LSet.empty();
		solver.add(myRis(LV1, C2, ConstrTrue, pattern1, E3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyRis_Lvar_Vuoto_FiltroCustom_Pattern1_Chiuso() {
	
		Solver solver = new Solver();
		LVar LV1 = new LVar("LV1");
		LSet E2 = LSet.empty();
		Constraint ConstrCustom = LV1.eq(4);
		LObject pattern1 = LV1;
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myRis(LV1, E2, ConstrCustom, pattern1, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyRis_Lvar_Vuoto_FiltroCustom_Pattern1_Vuoto() {
	
		Solver solver = new Solver();
		LVar LV1 = new LVar("LV1");
		LSet E2 = LSet.empty();
		Constraint ConstrCustom = LV1.eq(4);
		LObject pattern1 = LV1;
		LSet E3 = LSet.empty();
		solver.add(myRis(LV1, E2, ConstrCustom, pattern1, E3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testMyRis_Lvar_Vuoto_FiltroFalse_Pattern1_Chiuso() {
	
		Solver solver = new Solver();
		LVar LV1 = new LVar("LV1");
		LSet E2 = LSet.empty();
		Constraint ConstrFalse = new Constraint("_false");
		LObject pattern1 = LV1;
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myRis(LV1, E2, ConstrFalse, pattern1, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyRis_Lvar_Vuoto_FiltroFalse_Pattern1_Vuoto() {
	
		Solver solver = new Solver();
		LVar LV1 = new LVar("LV1");
		LSet E2 = LSet.empty();
		Constraint ConstrFalse = new Constraint("_false");
		LObject pattern1 = LV1;
		LSet E3 = LSet.empty();
		solver.add(myRis(LV1, E2, ConstrFalse, pattern1, E3));
		assertTrue(solver.check());
	
	}

	@Test
	public void testMyRis_Lvar_Vuoto_FiltroTrue_Pattern1_Chiuso() {
	
		Solver solver = new Solver();
		LVar LV1 = new LVar("LV1");
		LSet E2 = LSet.empty();
		Constraint ConstrTrue = new Constraint("_true");
		LObject pattern1 = LV1;
		LSet C3 = LSet.empty().ins(new LVar("X3")).ins(new LVar("Y3"));
		solver.add(myRis(LV1, E2, ConstrTrue, pattern1, C3));
		assertFalse(solver.check());
	
	}

	@Test
	public void testMyRis_Lvar_Vuoto_FiltroTrue_Pattern1_Vuoto() {
	
		Solver solver = new Solver();
		LVar LV1 = new LVar("LV1");
		LSet E2 = LSet.empty();
		Constraint ConstrTrue = new Constraint("_true");
		LObject pattern1 = LV1;
		LSet E3 = LSet.empty();
		solver.add(myRis(LV1, E2, ConstrTrue, pattern1, E3));
		assertTrue(solver.check());
	
	}

}