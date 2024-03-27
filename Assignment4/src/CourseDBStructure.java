

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
/*
 * Class: CMSC 204
 * Instructor: Huseyin Aygun
 * Description: A class that implements a hash structure of an array or linked lists
 * Due: 03/26/2024
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: William Hernandez
 */
/**
 * This class implements a hash structure
 * @author William Hernandez
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface {
	
	private int sizeHash;	// size of hash table
	private int numOfEntries;	// number of entries in the hash structure

	private LinkedList<CourseDBElement>[] hashTable;	// table
	
	private ArrayList<CourseDBElement> temp; // holds element objects themselves for the showall method
	
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int n){
		sizeHash = NextPrime4k3.nextPrime4k3(n);
		hashTable = new LinkedList[sizeHash];
		temp = new ArrayList<CourseDBElement>();	// dunno yet
	}
	
	/**
	 * class constructure which initiates the hash table and initiates a temporary arraylist
	 * which will hold the elements in the order it was added in for a later method
	 * @param test
	 * @param n
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String test, int n) {
		sizeHash = n;	// sets the size of hash
		hashTable = new LinkedList[sizeHash];	// initiates size of hash table linked list
		temp = new ArrayList<CourseDBElement>();	// temp arraylist to hold element objects
	}
	/**
	 * add method which adds an element object to the hash structure
	 * 
	 * @param element object
	 */
	@Override
	public void add(CourseDBElement element) {
		temp.add(element);							// adds element object to the temp arraylist
		
		int index = getHashIndex(element);	// gets the hash index of the element object based of its CRN number
		
		if(hashTable[index] == null) {	// if hashtable index is empty/no linked list
			hashTable[index] = new LinkedList<CourseDBElement>();	// initiates linked list at a specific hashTable index
			hashTable[index].add(element);	// adds element at that point, hashIndex is the linkedlist reference
			
			numOfEntries++;	// increases number of entries in the structure

		}
		else {	// if a linked list exists at the hashTable index
			LinkedList<CourseDBElement> list = hashTable[index];	// looks through the linked list at specified hashtable index
			
			for(CourseDBElement exists : list) {	// reads through linked list
				if(exists.compareTo(element) == true) {	// if both objects have the same crn number, update all followwing fields
					// I could only update just course ID and instructor for the tests but i opted for all of them, Element class has more setter methods for that
					exists.setCourseID(element.getID());
					exists.setInstructor(element.getInstructor());
					exists.setNumOfCredits(element.getNumOfCredits());
					exists.setRoomNum(element.getRoomNum());
					return;					
				}
				else if(exists.equals(element)) {	// if both CourseDBElements objects are equal, exit
					return;
				}
			}
			
			list.add(element);	// adds element object to structure at specified index		
			numOfEntries++;	// increases number of entries
		}
		
	}
	
	/**
	 * gets the element object which contains the specific CRN number 
	 * @param crn number 
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		CourseDBElement found = null;
		CourseDBElement temp = new CourseDBElement();	// creates temporary a course element object of type CourseDBElement
		
		temp.setCRN(crn);	// sets the CRN number of this object
		
		int tempHashIndex = getHashIndex(temp);	// gets hash index of an element object with this CRN number
		
		LinkedList<CourseDBElement> list = hashTable[tempHashIndex];	// looks at the linkedList at that hashIndex
			
		if(hashTable[tempHashIndex] == null) {	// if no linked list exists at that location, throw exception
			throw new IOException();
		}else {
			for(CourseDBElement element : list) {	// finds the element at that linked list location
				if(element.getCRN() == temp.getCRN()) {	// checks if the CRN number at the current element to the temporary element 
					found = element;	// if both crn numbers match, set found to element
					
					// testing purposes
					System.out.println("\n" + "Course:" + found.getID()
							+ " CRN:" + found.getCRN()
							+ " Credits:" + found.getNumOfCredits()
							+ " Instructor:" + found.getInstructor()
							+ " Room:" + found.getRoomNum() + " - CDS structure" + " hashindex( " + numOfEntries);
				}
			}
					
			return found;	// return element object
		}
		
		
	}
	
	/**
	 * this method returns an arrayList of strings of the element objects course information
	 */
	@Override
	public ArrayList<String> showAll() {
		
		ArrayList<String> courseList = new ArrayList<>();
		
		for(int i = numOfEntries-1; i >= 0; i--) {	// orders the elements added by order it was input in 
			courseList.add("\n" + "Course:" + temp.get(i).getID()
					+ " CRN:" + temp.get(i).getCRN()
					+ " Credits:" + temp.get(i).getNumOfCredits()
					+ " Instructor:" + temp.get(i).getInstructor()
					+ " Room:" + temp.get(i).getRoomNum());
		}
		return courseList;	// return array list
	}
	
	/**
	 * returns size of the table
	 */
	@Override
	public int getTableSize() {
		return sizeHash;
	}
	
	/**
	 * receives an element object and returns the hash index of that object
	 * @param element
	 * @return
	 */
	public int getHashIndex(CourseDBElement element) {
		int hashIndex = element.hashCode() % sizeHash;	// gets hashindex of the hashcode of the size of the hash
		
		if(hashIndex < 0) {
			return hashIndex * (-1);	// if for some reason the hashIndex number is negative, just convert to positive
		}
		
		return hashIndex;
	}
	
}


/**
 *	class to find the next prime number of form 4k+3
 */
class NextPrime4k3 {
	/**
	 * this method checks if a given number is a prime number
	 * @param num
	 * @return
	 */
    public static boolean isPrime(int num) {
        boolean isItPrime = true;
        int sqrtNum = (int) Math.sqrt(num);	// square roots the input so we wont need to search every number between 2 and num and just every number between 2 and the nums sqrt
        
        if (sqrtNum <= 1) {	// prime numbers cant be less than or equal to 1
            isItPrime = false;
            return isItPrime;
        }
        else{
            for(int i = 2; i <= sqrtNum; i++){
                if((num % i) == 0){	// if the modulo of num is 0, means its not a prime num
                    isItPrime = false;
                    break;
                }
            }
            return isItPrime;	// if above fails, its a prime num
        }
        
    }
    /**
     * checks if the next parameter n is a prime and of 4k+3 prime format
     * @param n
     * @return
     */
    public static int nextPrime4k3(int n) {
        double loadFac = (n/1.5);	// load factor of n/1.5
    	int next4K = (int)loadFac + 1;	
        while (true) {
            if (isPrime(next4K) && next4K % 4 == 3) { // checks if the next number is a prime and of format 4k+3
                return next4K;
            }
            next4K++;
        }
    }
}