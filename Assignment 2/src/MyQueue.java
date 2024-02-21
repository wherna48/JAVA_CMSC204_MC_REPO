import java.util.ArrayList;
/*
 * Class: CMSC 204
 * Instructor: Huseyin Aygun
 * Description: A class created to keep track of what goes in and out of the queue
 * Due: 02/20/2024
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: William Hernandez
 */

/**
 * A class created to keep track of what goes in and out of the queue
 * @author herna
 * @version 4.27
 * @param <T>
 */
public class MyQueue<T> implements QueueInterface<T>{
	
	ArrayList<T> arrayQ;	// arraylist 
	private int queueSize;	// queue size
	private int numOfElements;	// num of elements
	private int first = -1;	// first position in queue
	private int last = -1; // last position in the queue
	
	/**
	 * Constructor to create an arraylist of a given size
	 * @param queueSize
	 */
	public MyQueue(int queueSize) {
		this.queueSize = queueSize;
		arrayQ = new ArrayList<T>(queueSize);
		
	}
	
	/**
	 * default constructor to make an array list of size 5
	 */
	public MyQueue() {
		this(5);
		
	}
	
	/**
	 *	a method to check if queue is empty
	 *  @return - true or false 
	 */
	public boolean isEmpty() {
		return numOfElements == 0;	// returns true or false based on how many alements are being tracked
	}

	/**
	 * a method to check if queue is full
	 * @return - true or false
	 */
	public boolean isFull() {
		return queueSize == numOfElements;	// checks if the number of elements is the same as size of queue
	}

	/**
	 * a method to get the element being removed, and pointing to the new correct first element
	 * @return - data type T
	 */
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		T temp = arrayQ.get(first);	// gets element to be dequeued and adds to temp variable to be returned
		arrayQ.set(first, null);	// set first element to null when dequeued
		
		first++;					// next index in queue becomes first in the queue
		numOfElements--;			// reduce number of elements
		
		return temp;
	}

	/**
	 * a method to check the size of the queue
	 * @return int - number of elements
	 */
	public int size() {
		return numOfElements;	// tracks size using number of elements currently in the queue
	}

	/**
	 * method to add an element to the queue
	 * @return - true or false
	 * @param e
	 */
	public boolean enqueue(T e) throws QueueOverflowException {
		if(isFull()) {
			throw new QueueOverflowException();
		}
		else {
			if(isEmpty()) {
				first = last = 0;	// if queue is empty, set pointer pointers to index 0
			}
			else {					// if queue is not empty
				last++;				// sets next index to be used as the location to add the next element
			}
			numOfElements++;		// increases the number of elements in queue
			arrayQ.add(last, e);	// adds element to back of queue
			return true;
		}
	}
	
	/**
	 * method that uses stringbuilder to append elements to a string
	 * @return String 
	 */
	public String toString() {
		StringBuilder stringBuild = new StringBuilder();	// creates a stringbuilder reference
		
		for(int i = 0; i < numOfElements; i++){
			stringBuild.append(arrayQ.get(i));	// adds each element to the String
		}		
		
		return stringBuild.toString();	// returns stringbuilder as a string
	}
	
	/**
	 * method that uses stringbuilder to append elements + delimiter to a string
	 * @return String 
	 * @param delimiter
	 */
	public String toString(String delimiter) {
		StringBuilder stringBuild = new StringBuilder();
		
		for(int i = 0; i < numOfElements; i++){
			stringBuild.append(arrayQ.get(i) + delimiter); // adds each element + delimiter to the String
		}
		stringBuild.deleteCharAt(stringBuild.length()-1);  // removes last character at the end of the previous stringbuild since it contained an extra delimiter char
		
		return stringBuild.toString();	// return string
	}

	/**
	 * method to fill a new queue with values
	 * @param list
	 */
	@SuppressWarnings("unchecked")
	public void fill(ArrayList<T> list) throws QueueOverflowException {
		ArrayList<T> newData = new ArrayList<T>(list);	// new queue arraylist
		newData = (ArrayList<T>)newData.clone();		// clones the data
		
		for(T e : newData) {	// enhanced for loop to iterate through newData
			try {
				enqueue(e); 	// enqueue elements
			}catch(QueueOverflowException ex) { 	// catches queueOverflow exception
				throw new QueueOverflowException();	// throw exception
			}
			catch(Exception ex) {					// catch other exception
				System.out.println(ex.toString());	// print error message
			}
		}
	}

}
