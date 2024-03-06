import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BasicDoubleLinkedListTest_STUDENT {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	BasicDoubleLinkedList<Car> linkedCar;
	StringComparator comparator;
	DoubleComparator comparatorD;
	CarComparator comparatorCar;
	
	public Car a=new Car("Ford", "F150", 2005);
	public Car b=new Car("Jeep", "Renegade", 2005);
	public Car c=new Car("Honda", "Civic", 2005);
	public Car d=new Car("Subaru", "Outback", 2005);
	public Car e=new Car("Chevrolet", "Silverado", 2005);
	public Car f=new Car("Chrysler", "PTCruiser", 2005);

	public ArrayList<Car> fill = new ArrayList<Car>();
	
	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("Hello");
		linkedString.addToEnd("Rhodes");
		linkedString.addToEnd("Island");
		comparator = new StringComparator();
		
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(69.420);
		linkedDouble.addToEnd(55.0);
		linkedDouble.addToEnd(57.0);
		linkedDouble.addToEnd(56.0);
		comparatorD = new DoubleComparator();
		
		linkedCar= new BasicDoubleLinkedList<Car>();
		linkedCar.addToEnd(b);
		linkedCar.addToEnd(c);
		linkedCar.addToEnd(c);
		linkedCar.addToEnd(c);
		linkedCar.addToEnd(c);
		
		comparatorCar = new CarComparator();
	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
		linkedDouble = null;
		linkedCar = null;
		comparatorD = null;
		comparator = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(3,linkedString.getSize());
		assertEquals(4,linkedDouble.getSize());
		assertEquals(5,linkedCar.getSize());
	}

	@Test
	public void testAddToEnd() {
		assertEquals("Island", linkedString.getLast());
		linkedString.addToEnd("Surtr");
		assertEquals("Surtr", linkedString.getLast());
		
		assertEquals(0, comparatorD.compare(56.0, linkedDouble.getLast()));
		linkedDouble.addToEnd(100.0);
		assertEquals(0, comparatorD.compare(100.0, linkedDouble.getLast()));
	}

	@Test
	public void testAddToFront() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("Typhon");
		assertEquals("Typhon", linkedString.getFirst());
		
		assertEquals(0, comparatorD.compare(69.420, linkedDouble.getFirst()));
		linkedDouble.addToFront(150.0);
		assertEquals(0, comparatorD.compare(150.0, linkedDouble.getFirst()));
	}

	@Test
	public void testGetFirst() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("Penance");
		assertEquals("Penance", linkedString.getFirst());
		
		assertEquals(0, comparatorD.compare(69.420, linkedDouble.getFirst()));
		linkedDouble.addToFront(65.30);
		assertEquals(0, comparatorD.compare(65.30, linkedDouble.getFirst()));
	}

	@Test
	public void testGetLast() {
		assertEquals("Island", linkedString.getLast());
		linkedString.addToEnd("Acheron");
		assertEquals("Acheron", linkedString.getLast());
		
		assertEquals(0, comparatorD.compare(56.0, linkedDouble.getLast()));
		linkedDouble.addToEnd(9562.0);
		assertEquals(0, comparatorD.compare(9562.0, linkedDouble.getLast()));
	}

	@Test
	public void testRemove() {
		// remove first
		assertEquals(0, comparatorD.compare(69.420, linkedDouble.getFirst()));
		assertEquals(0, comparatorD.compare(56.0, linkedDouble.getLast()));
		linkedDouble.addToFront(500.0);
		assertEquals(0, comparatorD.compare(500.0, linkedDouble.getFirst()));
		linkedDouble.remove(500.0, comparatorD);
		assertEquals(0, comparatorD.compare(69.420, linkedDouble.getFirst()));
		// remove last
		linkedDouble.addToEnd(856.0);
		assertEquals(0, comparatorD.compare(856.0, linkedDouble.getLast()));
		linkedDouble.remove(856.0, comparatorD);
		assertEquals(0, comparatorD.compare(56.0, linkedDouble.getLast()));
		// remove somewhere in between
		linkedCar.addToFront(f);
		assertEquals(f, linkedCar.getFirst());
		assertEquals(c, linkedCar.getLast());
		linkedCar.remove(b, comparatorCar);
		assertEquals(f, linkedCar.getFirst());
		assertEquals(c, linkedCar.getLast());
		
		
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("Firefly");
		linkedString.addToFront("Sam");
		assertEquals("Sam", linkedString.getFirst());
		assertEquals("Sam", linkedString.retrieveFirstElement());
		assertEquals("Firefly",linkedString.getFirst());
		assertEquals("Firefly", linkedString.retrieveFirstElement());
		assertEquals("Hello",linkedString.getFirst());
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals("Island", linkedString.getLast());
		linkedString.addToEnd("Acheron");
		linkedString.addToEnd("Black Swan");
		assertEquals("Black Swan", linkedString.getLast());
		assertEquals("Black Swan", linkedString.retrieveLastElement());
		assertEquals("Acheron", linkedString.getLast());
		
	}
	
	
	
	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class CarComparator implements Comparator<Car>
	{

		@Override
		public int compare(Car arg0, Car arg1) {
			// Just put cars in alphabetic order by make
			return arg0.toString().compareTo(arg1.toString());
		}
		
	}
	
	private class Car{
		String make;
		String model;
		int year;
		
		public Car(String make, String model, int year){
			this.make = make;
			this.model = model;
			this.year = year;
		}
		
		public String getMake(){
			return make;
		}
		public String getModel(){
			return model;
		}
		public int getYear(){
			return year;
		}
		
		public String toString() {
			return (getMake()+" "+getModel()+" "+getYear());
		}
	}

}
