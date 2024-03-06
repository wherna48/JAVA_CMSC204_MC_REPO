import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
/*
 * Class: CMSC 204
 * Instructor: Huseyin Aygun
 * Description: A class that implements a a double linked list and implements the iterable interface
 * Due: 03/5/2024
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: William Hernandez
 */
/**
 * class that creates a generic double linked list that implements iterable
 * @author herna
 * @version 4.27
 * @param <T>
 */
public class BasicDoubleLinkedList<T> implements Iterable<T>{
	// protected attributes to be used by subclasses
	protected Node head;	
	protected Node tail;
	protected int size;
	
	/**
	 * constructor that initializes head and tail to null, sets size to zero
	 */
	public BasicDoubleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	/**
	 * Method returns the size of the list
	 * @return size of list
	 */
	public int getSize() {
		return size;
	}
	/**
	 * method that adds to the end of a list
	 * @param data
	 */
	public void addToEnd(T data) {
		Node newData = new Node(data);
		
		if (getSize() == 0) {	// if list is empty
			head = newData;		// update head
			tail = head;		// update tail
		}
		else {
			tail.next = newData;	// update tail next address to new data
			newData.prev = tail;	// update new data previous address to the tail
			tail = newData;			// update tail element with the new tail data
		}	
		size++;
	}
	/**
	 * a method which adds a newData node to the front of the list
	 * @param data
	 */
	public void addToFront(T data) {
		Node newData = new Node(data);
		
		if(getSize() == 0) {	// if list is empty
			head = newData;	// sets head to new element
			tail = head;	// sets tail to match the head
		}
		else {
			head.prev = newData;	// sets the new data to point to the previous head address
			newData.next = head;	// sets next newData address as the head
			head = newData;			// updates head with new data
		}
		size++;
	}
	/**
	 * method which gets the first data node in the list
	 * @return head
	 */
	public T getFirst() {
		if(getSize() == 0) {	// checks if list is empty
			return null;
		}
		else {
			return head.data;	// returns the data stored in head node
		}
	}
	/**
	 * method which gets the data in tail
	 * @return tail
	 */
	public T getLast() {
		if(getSize() == 0) {	// if list is empty
			return null;	// return null
		}
		else {
			return tail.data;	// returns tail data
		}
	}
	/**
	 * iterator method which returns a new DoubleLinkedListIterator()
	 */
	public ListIterator<T> iterator(){
		return new DoubleLinkedListIterator();
	}
	/**
	 * remove method which removes a target data by iterating through the list
	 * @param targetData
	 * @param comparator
	 * @return target data node
	 */
	public Node remove(T targetData, Comparator<T> comparator) {
		Node temp = head;	// temp node pointing to the first element at the start, then changes as we move through the list as the current element in the list	
		Node found = null;	// used to retutn the node found in the list
		
		if(getSize() == 0) {
			return null;
		}
		while(temp != null) {
			if(comparator.compare(targetData, temp.data) == 0) {
				if(getSize() == 1) {	// if the linked list only has one entry
					found = head;	// set the head as the found node
					head = null;	// set head to null since empty list
					tail = null;	// set tail to null since empty list
					size--;
					break;	// break out of loop
				}
				else if(temp == head) {	// list has more than one entry and finds data at the head
					found = temp;	
					head.next.prev = null; // cuts the next elements link to the previous head and sets it to null
					head = head.next; // sets next element as new head
					size--;	// reduces size
					break;
				}
				else if(temp == tail){ // when we find the element at the tail
					found = temp;
					tail.prev.next = null; // sets previous element address to null to signify it as tail
					tail = tail.prev; // sets address to previous element to new tail
					size--;
					break;
				}
				else {
					found = temp;
					temp.prev.next = temp.next; // set the next element to the previous next element to link
					temp.next.prev = temp.prev; // set previous element to the next elements prev address to complete link
					size--;
					break;
				}
			}
			temp = temp.next; // sets the next element to be the new currrent element(temp)
		}
		return found; // return element found by comparator
	}
	/**
	 * returns first element in the list then removes it
	 * @return
	 */
	public T retrieveFirstElement() {
		if(getSize() == 0) {	// when the list is empty
			return null;		// return null
		}
		if(getSize() == 1) {	// when there is only one element in the List
			T firstElement = getFirst();	// gets the first element data and sets it to an generic variable to be returned
			head = null;
			tail = null;
			size--;	
			return firstElement;
		}
		else {	// when there are more than on element in the List
			T firstElement = getFirst();
			head.next.prev = null; // cuts the next elements link to the previous head and sets it to null
			head = head.next; // sets next element as new head
			size--;
			return firstElement;
		}
	}
	/**
	 * removes last element and returns last element
	 * @return
	 */
	public T retrieveLastElement() {
		if(getSize() == 0) {	// when the list is empty
			return null;		// return null
		}
		if(getSize() == 1) {	// when there is only one element in the List
			T lastElement = getLast();	// gets the last element data and sets it to an generic variable to be returned
			head = null;
			tail = null;
			size--;	
			return lastElement;
		}
		else {	// when there are more than on element in the List
			T lastElement = getLast();
			tail.prev.next = null; // cuts the next elements link to the previous tail and sets it to null
			tail = tail.prev; // sets previous element as new tail
			size--;
			return lastElement;
		}
	}
	
	/**
	 * returns an arraylist with all the nodes
	 * @return
	 */
	public ArrayList<T> toArrayList(){
		Node currentNode = head;
		ArrayList<T> list = new ArrayList<>();
		int count = 0;
		
		while(count < getSize()) {
			list.add(currentNode.data);
			currentNode = currentNode.next;
			count++;
		}
		return list;
	}
	
	/**
	 * inner class Node with attributes of data T, prev Node, and next Node
	 * @author herna
	 *
	 */
	public class Node {
		protected T data;
		protected Node prev;
		protected Node next;
		/**
		 * initializes nodes and data variable
		 * @param dataNode
		 */
		public Node(T dataNode) {
			this.prev = null;
			this.next = null;
			this.data = dataNode;
		}
	}
	/**
	 * inner class iterator which implements ListIterator
	 * @author herna
	 *
	 */
	public class DoubleLinkedListIterator implements ListIterator<T>{
		Node currentNode = head;	// temporarily setting currentNode to the head
		Node lastElement;	// node which holds the previous element
		/**
		 * empty constructor
		 */
		public DoubleLinkedListIterator() {
			
		}
		
		/**
		 * checks if there is a next element in the list
		 * @return a boolean result
		 */
		@Override
		public boolean hasNext() {				
			return currentNode != null;	// checks if current node isnt null, which indicates an empty node or no data
		}
		/**
		 * method which returns the current element
		 * @return data type T
		 */
		@Override
		public T next() throws NoSuchElementException {
			if(hasNext()) {
				lastElement = currentNode;	// sets data from currentNode to lastElement node, for next
				currentNode = currentNode.next;	// sets the next element to the current element
				return lastElement.data;	// returns the previous data element
			}
			throw new NoSuchElementException();
		}
		
		/**
		 * checks if there was a previous element
		 * @returns boolean
		 */
		@Override
		public boolean hasPrevious() {
			return lastElement != null;	// checks if there was a previous element
		}
		/**
		 * method which returns the previous node
		 * @return data type T
		 */
		@Override
		public T previous() throws NoSuchElementException {
			if(hasPrevious()) {
				currentNode = lastElement;	// sets the previous element to the current element
				lastElement = lastElement.prev;	// sets previous lastElement to the new last element
				return currentNode.data;	// returns current node data
			}
			throw new NoSuchElementException();
		}
		/**
		 * method nextIndex which is unsupported
		 */
		@Override
		public int nextIndex() throws UnsupportedOperationException {				/*Unsupported*/
			throw new UnsupportedOperationException();
		}
		/**
		 * unsupported method in this class
		 */
		@Override
		public int previousIndex() throws UnsupportedOperationException {			/*Unsupported*/
			throw new UnsupportedOperationException();
		}
		/**
		 * unsupported method in this class
		 */
		@Override
		public void remove() throws UnsupportedOperationException {					/*Unsupported*/
			throw new UnsupportedOperationException();
			
		}
		/**
		 * unsupported method in this class
		 */
		@Override
		public void set(T e) throws UnsupportedOperationException {					/*Unsupported*/
			throw new UnsupportedOperationException();
			
		}
		/**
		 * unsupported method in this class
		 */
		@Override
		public void add(T e) throws UnsupportedOperationException {					/*Unsupported*/
			throw new UnsupportedOperationException();
			
		}
		
	}
	
}
