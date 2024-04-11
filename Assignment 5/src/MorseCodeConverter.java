import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Class: CMSC 204
 * Instructor: Huseyin Aygun
 * Description: A class that converts morse code to english
 * Due: 03/26/2024
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: William Hernandez
 */
/**
 * This class converts a code string and code read from a file and converts the code to
 * english
 * 
 * @author William Hernandez
 *
 */
public class MorseCodeConverter {
	
	static MorseCodeTree morseTree = new MorseCodeTree(); // element object for MorseCodeTree
	/**
	 * Empty class constructor
	 */
	public MorseCodeConverter() {}
	
	/**
	 * Returns a string with all the data in the tree in 
	 * LNR order with an space in between them
	 * 
	 * @return String
	 */
	public static String printTree() {
		String data = "";	
		
		for(String chara : morseTree.toArrayList()) {	// for each loop, calls method in the morseCodeTree which gets an array list of the tree
			data +=  " " + chara; // adds each letter in string
		}
		return data.substring(1); // takes out the white space in the beginning
		
	}
	
	/**
	 * Converts morse code string to English
	 * @param code
	 * @return String
	 */
	public static String convertToEnglish(String code) {
		StringBuilder codeToEnglish = new StringBuilder();
		String[] arr = code.split(" / "); // split morse code to separate the words
		String[] arr2;	// this is used to add the individual letters to array
		
		for(String codeSnip : arr) {
			
			arr2 = codeSnip.split(" ");	// splits the individual letters from the code and adds to array
			
			for(String temp : arr2) {
				
				codeToEnglish.append(morseTree.fetch(temp)); // fetches data of letter in the tree
				
			}
			
			codeToEnglish.append(" ");	// adds a white space to the stringbuilder to separate the words
			
		}
		
		return codeToEnglish.toString().trim();	// returns the stringbuilder and removes whitespaces at both ends of the string
		
	}
	
	/**
	 * Reads a file, adds line to a string and converts to english as in the prior method
	 * @param codeFile
	 * @return String
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		Scanner sc = new Scanner(codeFile);	// scanner to read file
		StringBuilder codeToEnglish = new StringBuilder();
		String codeString = "";
		
		while(sc.hasNextLine()) {
			codeString = sc.nextLine(); // reads line from file and insert into a string
		}
		
		sc.close(); // closes the scanner
		
		//System.out.println(codeString);
		
		String[] arr = codeString.split(" / ");
		String[] arr2;
		
		for(String codeSnip : arr) {
			
			arr2 = codeSnip.split(" ");	// splits the individual letters from the code
			
			for(String temp : arr2) {
				
				codeToEnglish.append(morseTree.fetch(temp));
				
			}
			
			codeToEnglish.append(" ");
			
		}
		
		return codeToEnglish.toString().trim();
	}
	
}
