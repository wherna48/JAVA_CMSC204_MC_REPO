import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SortedDoubleLinkedListTest_STUDENT {
	SortedDoubleLinkedList<HSR> sortedLinkedHSR;
	HSRComparator comparatorH;
	
	public HSR a = new HSR("Black Swan", "Wind", 5);
	public HSR b = new HSR("Acheron", "Lighting", 5);
	public HSR c = new HSR("Trailblazer", "Fire", 5);
	public HSR d = new HSR("Clara", "Physical", 5);
	public HSR e = new HSR("Seele", "Quantum", 5);
	public HSR f = new HSR("Bronya", "Wind", 5);

	// order = b, a, d, c
	
	@Before
	public void setUp() throws Exception {
		comparatorH = new HSRComparator();
		sortedLinkedHSR = new SortedDoubleLinkedList<HSR>(comparatorH);
	}

	@After
	public void tearDown() throws Exception {
		comparatorH = null;
	}

	@Test
	public void testRemove() {
		// alpha order = b, a, d, c
		sortedLinkedHSR.add(c);
		sortedLinkedHSR.add(d);
		assertEquals(d, sortedLinkedHSR.getFirst());
		assertEquals(c, sortedLinkedHSR.getLast());
		sortedLinkedHSR.add(a);
		assertEquals(a, sortedLinkedHSR.getFirst());
		//remove the front, a, d, c
		sortedLinkedHSR.remove(a, comparatorH);
		assertEquals(d, sortedLinkedHSR.getFirst());
		sortedLinkedHSR.add(b);
		assertEquals(b, sortedLinkedHSR.getFirst()); // b,d,c
		assertEquals(3, sortedLinkedHSR.getSize());
		// remove from middle
		// currently b, d, c
		sortedLinkedHSR.remove(d, comparatorH);
		assertEquals(b, sortedLinkedHSR.getFirst());
		assertEquals(c, sortedLinkedHSR.getLast());
		assertEquals(2, sortedLinkedHSR.getSize());
		// remove from last
		//currently is b, c
		sortedLinkedHSR.add(e);
		sortedLinkedHSR.add(f);
		// currently b, f, e, c
		assertEquals(c, sortedLinkedHSR.getLast());
		sortedLinkedHSR.remove(b, comparatorH);
		sortedLinkedHSR.remove(c, comparatorH);
		assertEquals(f, sortedLinkedHSR.getFirst());
		assertEquals(e, sortedLinkedHSR.getLast());
	
	}

	@Test
	public void testAdd() {
		sortedLinkedHSR.add(a);
		sortedLinkedHSR.add(b);
		sortedLinkedHSR.add(c);
		// b , a, c
		assertEquals(b, sortedLinkedHSR.getFirst());
		assertEquals(c, sortedLinkedHSR.getLast());
		sortedLinkedHSR.add(d);
		sortedLinkedHSR.add(e);
		sortedLinkedHSR.add(f);
		// b, a, f, d, e, c
		assertEquals(b, sortedLinkedHSR.getFirst());
		assertEquals(c, sortedLinkedHSR.getLast());
		assertEquals(c, sortedLinkedHSR.retrieveLastElement());
		assertEquals(e, sortedLinkedHSR.getLast());
		
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedHSR.addToFront(a);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}
	
	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedHSR.addToEnd(b);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}
	
	private class HSRComparator implements Comparator<HSR>
	{

		@Override
		public int compare(HSR arg0, HSR arg1) {
			// puts in alphabetic order
			return arg0.getCharName().compareTo(arg1.getCharName());
		}
		
	}
	
	private class HSR {
		String charName;
		String elementAttribute;
		int charStarRating;
		
		public HSR(String charName, String elementAttribute, int charStarRating) {
			this.charName = charName;
			this.elementAttribute = elementAttribute;
			this.charStarRating = charStarRating;
		}
		
		public String getCharName()	{
			return charName;
		}
		
		public String getElementAttribute() {
			return elementAttribute;
		}
		
		public int getRating() {
			return charStarRating;
		}
		
		public String toString() {
			return (getCharName() + " " + getElementAttribute() + " " + getRating());
		}
	
	}
}
