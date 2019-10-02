package tp04;
import static org.junit.Assert.*;

import java.util.*;
import org.junit.Test;

/**
 * Tests for a hybrid array linked list implementation.
 * @author Thibault Raffaillac
 * @date 2017 November 17th
 */
public class BlockLinkedListTest {
    @Test
    public void testQ3WithSize() {
	BlockLinkedList<String> list = new BlockLinkedList<>(4);
	assertTrue(list.isEmpty());
	assertEquals( 0,list.size());
	list.add("E");
	list.add("F");
	list.add("A");
	list.add("B");
	assertFalse(list.isEmpty());
	assertEquals( 4,list.size());
	list.add("G");
	list.add("C");
	list.add("D");
	assertFalse(list.isEmpty());
	assertEquals( 7,list.size());

	list.clear();
	assertTrue(list.isEmpty());
	assertEquals( 0,list.size());
    }

    @Test
    public void testQ3toString() {
	BlockLinkedList<String> list = new BlockLinkedList<>(4);
	assertEquals("[]",list.toString());
	list.add("E");
	list.add("F");
	list.add("A");
	list.add("B");
	assertEquals("[E, F, A, B]",list.toString());
	list.add("G");
	list.add("C");
	list.add("D");
	assertEquals("[E, F, A, B, G, C, D]",list.toString());

    }

    @Test
    public void testQ4() {
	BlockLinkedList<String> list = new BlockLinkedList<>(4);
	assertFalse(list.contains("C"));
	assertEquals( -1,list.indexOf("D"));
	list.add("E");
	list.add("F");
	assertTrue(list.contains("E"));
	assertEquals( 1,list.indexOf("F"));
	assertEquals( -1,list.indexOf("D"));
	list.add("A");
	list.add("B");
	list.add("G");
	list.add("C");
	list.add("D");

	assertTrue(list.contains("A"));
	assertEquals( 3,list.indexOf("B"));
	list.add("B");
	assertEquals( 7,list.lastIndexOf("B"));
    }

    @Test
    public void testQ5() {
	BlockLinkedList<String> list = new BlockLinkedList<>(4);
	list.add("E");
	list.add("F");
	assertEquals( "F",list.get(1));
	assertNull(list.get(3));
	list.add("A");
	list.add("B");
	assertEquals( "A",list.get(2));

	list.set(1,"G");
	assertEquals( "G",list.get(1));
	list.set(7,"G");

    }

    @Test
    public void testQ6() {
	BlockLinkedList<String> list = new BlockLinkedList<>(4);
	list.add("E");
	list.add("F");
	assertEquals("[E, F]", list.toString());
	list.add("A");
	list.add("B");
	list.add("G");
	assertEquals("[E, F, A, B, G]", list.toString());
	list.add("C");
	list.add("D");
	assertEquals("[E, F, A, B, G, C, D]", list.toString());

	String[] t={"Z","R","P","T"};
	List<String> c=new ArrayList<>();
	for(String s: t) c.add(s);
	list.addAll(c);
	assertEquals("[E, F, A, B, G, C, D, Z, R, P, T]", list.toString());
    }

    @Test
    public void testQ7() {
	BlockLinkedList<String> list = new BlockLinkedList<>(4);
	list.add("E");
	list.add("F");
	list.add("A");
	list.add("B");
	list.add("G");
	list.add("C");
	list.add("D");


	list.remove(1);
	assertEquals("[E, A, B, G, C, D]", list.toString());
	list.remove(0);
	assertEquals("[A, B, G, C, D]", list.toString());
	list.remove(8);
	assertEquals("[A, B, G, C, D]", list.toString());


	list.remove("G");
	assertEquals("[A, B, C, D]", list.toString());

    }

}