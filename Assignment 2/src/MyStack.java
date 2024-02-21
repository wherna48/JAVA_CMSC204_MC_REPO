import java.util.ArrayList;
/*
 * Class: CMSC 204
 * Instructor: Huseyin Aygun
 * Description: A class created to keep track of what goes in and out of the stack
 * Due: 02/20/2024
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: William Hernandez
 */
/**
 * A class created to keep track of what goes in and out of the stack
 * @author herna
 * @version 4.27
 * @param <T>
 */
public class MyStack<T> implements StackInterface<T> {
	ArrayList<T> arrayL;
	private int numOfElements;
	private int sizeStack;
	
	/**
	 * Default constructor that creates a arraylist of size 5 
	 */
	public MyStack() {
		this(5); // default capacity = 5
	}
	
	/**
	 * method that sets a size to the stack
	 * @param sizeStack
	 */
	public MyStack(int sizeStack) {
		this.sizeStack = sizeStack;
		
		arrayL = new ArrayList<T>(sizeStack);
	}
	
	
	/**
	 * method to check if stack is empty
	 * @return - true or false
	 */
	public boolean isEmpty() {
		return numOfElements == 0;	// stack is empty if elements equals 0
	}

	/**
	 * method to check if stack is full
	 * @return - true or false
	 */
	public boolean isFull() {
		return numOfElements == sizeStack;	// stack is full if number of elements and size of stack is equal
	}

	/**
	 * method that pops elements in the stack
	 * @return - data type T
	 */
	public T pop() throws StackUnderflowException {
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		else {
			T temp = top();	// places element about to get popped in a temp variable
			arrayL.remove(arrayL.size()-1);	// removes the last element from array to simulate it being popped
			numOfElements--;				// reduces number of elements in the stack
			return temp;					// return popped element
		}
	}

	/**
	 * method that returns what the top element of the stack is
	 * @return - data type T
	 */
	public T top() throws StackUnderflowException {
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		else {
			T top = arrayL.get(arrayL.size()-1); // gets the last element in the stack
			return top;
		}
	}

	/**
	 * method to check what the size of the stack is
	 * @return int
	 */
	public int size() {
		return numOfElements; // returns number of elements in the stack
	}

	
	/**
	 * push method to add an element to the stack
	 * @return - true or false
	 * @param e
	 */
	public boolean push(T e) throws StackOverflowException {
		if(isFull()) {	
			throw new StackOverflowException();			
		}else {
	
			arrayL.add(e);	// add an element to the stack
			numOfElements++; // adds an element
			return true;
		}	
		
	}


	/**
	 * a toString method to show the elements in the stack
	 * @return String
	 */
	public String toString() {
		StringBuilder stringBuild = new StringBuilder();	// creates a stringbuilder reference
		
		for(int i = 0; i < numOfElements; i++){
			stringBuild.append(arrayL.get(i));	// adds each element to the String
		}		
		
		return stringBuild.toString();	// return string
	}

	/**
	 * a toString method to show the elements in the stack + delimiter
	 * @return String
	 * @param delimiter
	 */
	public String toString(String delimiter) {
		StringBuilder stringBuild = new StringBuilder();
		
		for(int i = 0; i < numOfElements; i++){
			stringBuild.append(arrayL.get(i) + delimiter); // adds each element to the String + delimiter
		}
		stringBuild.deleteCharAt(stringBuild.length()-1);	// removes last character at the end of the previous stringbuild since it contained an extra delimiter char
		return stringBuild.toString();	// return string
	}
	
	/**
	 * method to fill a new queue with values
	 * @param list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void fill(ArrayList<T> list) throws StackOverflowException {
		ArrayList<T> newData = new ArrayList<T>(list);	// new stack arraylist
		newData = (ArrayList<T>)newData.clone();		// clones stack
		
		for(T e : newData) {	// looks through cloned array
			try {
				push(e);	// push element in stack
			}catch(StackOverflowException ex) {
				throw new StackOverflowException();
			}
			catch(Exception ex) {
				System.out.println(ex.toString());
			}
		}
	}

}
