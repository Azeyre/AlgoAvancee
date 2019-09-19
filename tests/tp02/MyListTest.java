package tp02;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyListTest {

	@Test
	public void testIsEmpty() {
		MyList<Integer> list = new MyList<Integer>();
		assertTrue(list.isEmpty());
		list.add(20);
		assertFalse(list.isEmpty());
	}

	@Test
	public void testClear() {
		MyList<Integer> list = new MyList<Integer>();
		assertNull(list.first);
		assertNull(list.last);
		list.add(33);
		list.add(45);
		assertNotNull(list.first);
		assertNotNull(list.last);
		list.clear();
		assertNull(list.first);
		assertNull(list.last);
	}

	@Test
	public void testToString() {
		MyList<Integer> list = new MyList<Integer>();
		assertEquals(list.toString(), "");
		list.add(33);
		list.add(45);
		list.add(7);
		assertEquals(list.toString(), "33 45 7");
	}



/******************************************************/




	@Test
	public void testAddE() {
		MyList<Integer> list = new MyList<Integer>();
		assertTrue(list.add(33));
		list.add(45);
		list.add(7);
		assertEquals(new Integer(33), list.first.value);
		assertEquals(new Integer(45), list.first.next.value);
		assertEquals(new Integer(7), list.last.value);
	}

	@Test
	public void testSize() {
		MyList<Integer> list = new MyList<Integer>();
		assertEquals(0, list.size());
		list.add(33);
		list.add(45);
		list.add(7);
		assertEquals(3, list.size());
		list.remove(0);
		assertEquals(2, list.size());
		list.remove(1);
		assertEquals(1, list.size());
		list.remove(0);
		assertEquals(0, list.size());
		list.add(7);
		assertEquals(1, list.size());
	}

	@Test
	public void testGet() {
		MyList<Integer> list = new MyList<Integer>();
		list.add(33);
		list.add(45);
		list.add(7);
		assertEquals(new Integer(45), list.get(1));
		assertNotEquals(new Integer(33), list.get(2));
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetWrongIndex1() {
		MyList<Integer> list = new MyList<Integer>();
		list.add(33);
		list.add(45);
		list.add(7);
		list.get(-1);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetWrongIndex2() {
		MyList<Integer> list = new MyList<Integer>();
		list.add(33);
		list.add(45);
		list.add(7);
		list.get(3);
	}

	@Test
	public void testIndexOf() {
		MyList<Integer> list = new MyList<Integer>();
		list.add(33);
		list.add(45);
		list.add(7);
		list.add(33);

		assertEquals(1, list.indexOf(new Integer(45)));
		assertEquals(0, list.indexOf(new Integer(33)));
		assertEquals(2, list.indexOf(new Integer(7)));
		assertEquals(-1, list.indexOf(new Integer(25)));
	}

	@Test
	public void testLastIndexOf() {
		MyList<Integer> list = new MyList<Integer>();
		list.add(33);
		list.add(45);
		list.add(7);
		list.add(33);

		assertEquals(3, list.lastIndexOf(new Integer(33)));
		assertEquals(2, list.lastIndexOf(new Integer(7)));
		assertEquals(-1, list.lastIndexOf(new Integer(25)));
	}

	@Test
	public void testContains() {
		MyList<Integer> list = new MyList<Integer>();
		list.add(33);
		list.add(45);
		list.add(7);
		assertTrue(list.contains(new Integer(33)));
		assertFalse(list.contains(new Integer(8)));
	}

	@Test
	public void testAddIntE() {
		MyList<Integer> list = new MyList<Integer>();
		list.add(5);
		list.add(4);
		list.add(33);
		assertEquals(new Integer(33), list.first.next.next.value);
		assertEquals(new Integer(33), list.last.value);
		list.add(0,96);
		assertEquals(new Integer(96), list.first.value);
		assertEquals(new Integer(33), list.last.value);
	}

	@Test
	public void testRemoveObject() {
		MyList<Integer> list = new MyList<Integer>();
		list.add(5);
		list.add(4);
		list.add(33);
		assertFalse(list.remove(new Integer(20)));
		assertEquals(new Integer(33), list.first.next.next.value);
		assertTrue(list.remove(new Integer(33)));
		list.add(new Integer(35));
		assertNotEquals(new Integer(33), list.first.next.next.value);
	}

	@Test
	public void testRemoveInt() {
		MyList<Integer> list = new MyList<Integer>();
		list.add(5);
		list.add(4);
		list.add(33);
		assertEquals(new Integer(33), list.remove(2));
		assertEquals(new Integer(4), list.last.value);
		assertEquals(new Integer(5), list.remove(0));
		assertEquals(new Integer(4), list.first.value);
		assertEquals(new Integer(4), list.last.value);
		assertEquals(new Integer(4), list.remove(0));
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testRemoveFromEmpty() {
		MyList<Integer> list = new MyList<Integer>();
		list.remove(0);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testRemoveWrongIndex1() {
		MyList<Integer> list = new MyList<Integer>();
		list.add(2);
		list.add(5);
		list.add(21);
		list.remove(-1);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testRemoveWrongIndex2() {
		MyList<Integer> list = new MyList<Integer>();
		list.add(2);
		list.add(5);
		list.add(21);
		list.remove(3);
	}
}