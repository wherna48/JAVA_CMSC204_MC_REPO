import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * Class: CMSC 204
 * Instructor: Huseyin Aygun
 * Description: A Manager class that adds an element inputed by the user in the gui
 * Due: 03/26/2024
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: William Hernandez
 */
/**
 * A Manager class that adds an element inputed by the user in the gui
 * @author William Hernandez
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {
	CourseDBStructure hashStructure;	// hash structure object
	/**
	 * class constructor
	 */
	public CourseDBManager(){
		hashStructure = new CourseDBStructure(50);	// creates a hash structure of size 50
	}
	
	/**
	 * method to add an CourseDBElement object to the hash structure
	 * @param id - course id
	 * @param crn - course CRN number
	 * @param credits - course credits
	 * @param roomNum - Room Number
	 * @param instructor - instructor name
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement add1 = new CourseDBElement(id, crn, credits, roomNum, instructor);	// builds a CourseDBElement object
		hashStructure.add(add1);	// adds the element object into the hash structure using the CDS add method
	}
	/**
	 * method which returns a CDE object with the given CRN number
	 * @param crn
	 * @return CourseDBElement object
	 */
	@Override
	public CourseDBElement get(int crn) {
		CourseDBElement returnElement = new CourseDBElement();	// creates a element object to be returned
		
		try {
			returnElement = hashStructure.get(crn);	// call the CDS class structure and gets the element with the crn number
			

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return returnElement;
	}
	/**
	 * method to read file input by the user
	 * @param input
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		CourseDBElement cde;			
		int crn, credits;
		String course;	// holds current line being read
		String[] courses;	// string array to hold 
		
		try {
		Scanner read = new Scanner(input);	
		while(read.hasNextLine()) {
			course = read.nextLine();	// reads current line
			courses = course.split(" ", 5);	// splits the line by spaces to add into cde object
			crn = Integer.valueOf(courses[1]);	// this gets the crn number since after the first space its the crn number
			credits = Integer.valueOf(courses[2]);	// gets the number of credits after crn number
			cde = new CourseDBElement(courses[0], crn, credits, courses[3], courses[4]);	// build cde object with proper elements
			hashStructure.add(cde);	// adds the newly created object to the hash structure
		}
		
		read.close();	// close scanner
		
		}catch(FileNotFoundException e)	{	// catch if the file doesnt exist
			throw new FileNotFoundException();
		}
		
		
	}
	
	/**
	 * shows all the elements using cds showAll() method
	 * @return ArrayList<String>
	 */
	@Override
	public ArrayList<String> showAll() {	// using show all method from cds class
		return hashStructure.showAll();
	}

}
