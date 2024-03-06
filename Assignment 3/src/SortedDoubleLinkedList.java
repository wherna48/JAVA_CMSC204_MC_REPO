import java.util.Comparator;
import java.util.ListIterator;
/*
 * Class: CMSC 204
 * Instructor: Huseyin Aygun
 * Description: A class that implements a sorted double linked list and extends BasicDoubleLinkedList
 * Due: 03/5/2024
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: William Hernandez
 */

/**
 * class which creates a sorted double linked list wwhich extends BasicDoubleLinkedList
 * @author herna
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	
	private Comparator<T> comparator;
	
	/**
	 * contructor method that initializes comparator 
	 * @param comparableObj
	 */
	public SortedDoubleLinkedList(Comparator<T> comparableObj) {
		comparator = comparableObj;
	}
	
	/**
	 * this class adds elements to a list in a sorted order, doesnt work well
	 * @param data
	 */
	public void add(T data) {
		Node newData = new Node(data);
		Node currentNode;
		Node previous = null;
		
		if(head == null) {	// if list empty
			head = newData;
			tail = head;
		}	// if list is not empty and new data node is less than or equal to the the current data node, add new node to the front of the list
		else if(comparator.compare(newData.data, head.data) < 0 || comparator.compare(newData.data, head.data) == 0)
		{
			newData.next = head;	// sets newData->next address to the head data
			newData.prev = null;	// sets prev<-newData address to null
			head.prev = newData;	// sets the previous head address to new data
			head = newData;			// update head node to new data
		}
		else // here we add stuff after the head
		{		
			currentNode = head;	// set the head as currentNode
			
			// here we are traversing through the list until the currentNode is null or when newData is less than the next node in the list
			while(currentNode != null && comparator.compare(newData.data, currentNode.data) > 0) {
				previous = currentNode;	// setting currentNode as previous node
				currentNode = currentNode.next; // updating to next node
			}
			// if the currentNode is equal to null (means we reached the end of the list)
			if(currentNode == null) {
				newData.prev = previous;	// 
				newData.next = null;	// sets new data next address to null since this new data is at the end of the list
				previous.next = newData;	// sets previous node next address to new data
				tail = previous.next;	// update tail
			}
			else {	// here we are inserting somewhere between the head and tail
				newData.prev = previous; // setting newData prev pointer to the previous node
				newData.next = previous.next;	// set newData next pointer to the previous->next pointer 
				previous.next = newData;	// has previous node point to the new data
				newData.next.prev = newData;	// have the newData node thats pointing to the next nodes previous node set to the newdATA
			}	
			
		}	
		size++;	// increment size of list since we added something by the end of all this
	}
	
	/**
	 * iterator method that returns the super class call to the iterator of type Listiterator<T>
	 */
	public ListIterator<T> iterator(){
		return super.iterator();	// calls super class iterator and returns this
	}
	/**
	 * remove method that takes two parameters and returns element to be removed
	 * @param data type T and a comparator obj
	 */
	public Node remove (T data, Comparator<T> comparator) {
		return super.remove(data, comparator);	// calls super class method of remove and set the parameters, return this
	}
	/**
	 * a method that throws an exception if called in the class
	 * @param data
	 */
	public void addToFront(T data) {
		throw new UnsupportedOperationException();
	}
	/**
	 * a method that throws an exception if called in this class
	 * @param data
	 */
	public void addToEnd(T data) {
		throw new UnsupportedOperationException();
	}
}
