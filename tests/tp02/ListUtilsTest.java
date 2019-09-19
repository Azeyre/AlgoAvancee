package tp02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ListUtilsTest extends ListUtils {

	ListUtils lUtils;
	final int MAX = 100;
	final int MAX_SIZE = 30;
	final int MIN = 1;



	@Before
	public void setUp() {
		lUtils = new ListUtils();
	}


	@Test
	public void testGenereRdmIntList() {
		List<Integer> l = lUtils.genereRdmIntList();
		boolean listOk = true;
		if((!l.isEmpty())&&l.size()<=30){
			for(Integer i: l)
				if(i < MIN || i > MAX )
					listOk = false;
		}else
			listOk = false;

		assertTrue(listOk);
	}

	@Test
	public void testAffiche() {
		String separator = System.getProperty("line.separator");
		PrintStream originalOut = System.out;
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		List<Integer> l = new ArrayList<Integer>();
		System.setOut(ps);

		l.add(2);
	    l.add(45);
		l.add(12);
		l.add(58);
		l.add(24);

		String expected = "2 -> 45 -> 12 -> 58 -> 24";

		lUtils.affiche(l);

		assertEquals(expected + separator, os.toString());
		System.setOut(originalOut);
	}




	@Test
	public void testAfficheInverse() {
		String separator = System.getProperty("line.separator");
		PrintStream originalOut = System.out;
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		List<Integer> l = new ArrayList<Integer>();
		System.setOut(ps);

		l.add(2);
	    l.add(45);
		l.add(12);
		l.add(58);
		l.add(24);

		String expected = "24 -> 58 -> 12 -> 45 -> 2";

		lUtils.afficheInverse(l);

		assertEquals(expected + separator, os.toString());
		System.setOut(originalOut);
	}

	@Test
	public void testSomme() {
		List <Integer> l = new ArrayList<Integer>();
		l.add(45);
		l.add(12);
		l.add(58);
		l.add(24);
		assertEquals(139, lUtils.somme(l));
	}

	@Test
	public void testMoyenne() {
		List <Integer> l = new ArrayList<Integer>();
		l.add(2);
		l.add(12);
		l.add(33);
		l.add(24);
		assertEquals(17, lUtils.moyenne(l));
	}

	@Test
	public void testMax() {
		List <Integer> l = new ArrayList<Integer>();
		l.add(2);
		l.add(12);
		l.add(88);
		l.add(24);
		assertEquals(88, lUtils.max(l));
	}

	@Test
	public void testMin() {
		List <Integer> l = new ArrayList<Integer>();
		l.add(2);
		l.add(12);
		l.add(1);
		l.add(24);
		assertEquals(1, lUtils.min(l));
	}

	@Test
	public void testPositions() {
		List <Integer> l = new ArrayList<Integer>();
		List <Integer> lPositions = new ArrayList<Integer>();

		l.add(1);l.add(22);
		l.add(45);l.add(56);
		l.add(1);l.add(34);
		l.add(1);

		lPositions.add(0);
		lPositions.add(4);
		lPositions.add(6);

		assertEquals(lPositions, lUtils.positions(l, 1));

	}


	@Test
	public void testPaire() {
		List <Integer> l = new ArrayList<Integer>();
		List <Integer> lPaire = new ArrayList<Integer>();
		l.add(2);
		l.add(12);
		l.add(24);
		l.add(55);
		l.add(88);
		l.add(7);
		lPaire.add(2);
		lPaire.add(12);
		lPaire.add(24);
		lPaire.add(88);

		Collections.sort(lUtils.paire(l));
		Collections.sort(lPaire);
		assertEquals(lPaire, lUtils.paire(l));
	}

	@Test
	public void testEstTrie() {
		List <Integer> l = new ArrayList<Integer>();
		List <Integer> lTrie = new ArrayList<Integer>();

		l.add(88);lTrie.add(5);
		l.add(55);lTrie.add(12);
		l.add(36);lTrie.add(36);
		l.add(12);lTrie.add(55);
		l.add(5);lTrie.add(88);

		assertTrue(!lUtils.estTrie(l)&&lUtils.estTrie(lTrie));
	}

	@Test
	public void testTrie() {
		List <Integer> l = new ArrayList<Integer>();
		List <Integer> lTrie = new ArrayList<Integer>();

		//88 55 5 12 36
		l.add(88);
		l.add(55);
		l.add(5);
		l.add(12);
		l.add(36);
		lTrie.addAll(l);

		Collections.sort(lTrie);
		assertEquals(lTrie, lUtils.trie(l));
	}

}