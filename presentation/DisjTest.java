public class DisjTest {
	//...

	@Test
	public void testDisj_Vuoto_Vuoto() {
		Solver solver = new Solver();
		LSet E1 = LSet.empty();
		LSet E2 = LSet.empty();
		solver.add(E1.disj(E2));
		assertTrue(solver.check());
	}
	//...
}
