package tp04;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ExoSetTest {

	@Test
	public void testInter() {
		Set<Integer> ens1 = new HashSet<>();
		Set<Integer> ens2 = new HashSet<>();
		ens1.add(1);
		ens1.add(2);
		ens1.add(3);
		ens1.add(4);
		ens2.add(3);
		ens2.add(6);
		ens2.add(1);
		Set<Integer> s = new HashSet<>();
		s.add(1);
		s.add(3);
		assertEquals(s, ExoSet.inter(ens1, ens2));
	}

	@Test
	public void testUnion() {
		Set<Integer> ens1 = new HashSet<>();
		Set<Integer> ens2 = new HashSet<>();
		ens1.add(1);
		ens1.add(2);
		ens1.add(3);
		ens1.add(4);
		ens2.add(3);
		ens2.add(6);
		ens2.add(1);
		Set<Integer> s = new HashSet<>();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(6);
		assertEquals(s, ExoSet.union(ens1, ens2));
	}

	@Test
	public void testIsIn() {
		Set<Integer> ens1 = new HashSet<>();
		Set<Integer> ens2 = new HashSet<>();
		ens1.add(1);
		ens1.add(2);
		ens1.add(3);
		ens1.add(4);
		ens2.add(3);
		ens2.add(1);
		assertTrue(ExoSet.isIn(ens2, ens1));
		ens2.add(10);
		assertFalse(ExoSet.isIn(ens2, ens1));
	}

}
