package tp05;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChainageTest {

	@Test
	public void test() {
		Chainage c = new Chainage();
		assertEquals(0, c.size());
		c.put("ABC", 25);
		c.put("BBB", 4);
		c.put("PCH", 12);
		assertEquals(3, c.size());
		assertEquals((Integer) 5, c.put("AAA", 5));
		assertEquals((Integer) 25, c.remove("ABC"));
		assertTrue(c.contains("BBB"));
		assertFalse(c.contains("ABC"));
	}

}
