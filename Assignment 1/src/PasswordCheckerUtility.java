import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * Class: CMSC 204
 * Instructor: Huseyin Aygun
 * Description: A class to check if passwords meet certain criteria from GUI input and
 * 				test classes
 * Due: 02/03/2024
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: William Hernandez
 */

/**
 * This class checks passwords and throws certain exceptions if some criteria fails 
 * @author William Hernandez
 * @version 4.27
 */
public class PasswordCheckerUtility {
	/**
	 * Default constructor of PasswordCheckerUtility
	 */
	public PasswordCheckerUtility() {
		
	}
	/**
	 * This method compares two passwords and throws an exception if they do not match
	 * @param password 
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if(!password.equals(passwordConfirm)) 	
			throw new UnmatchedException();			// if passwords are not equal, throw UnmatchedException
		
	}
	/**
	 * This method compares two passwords and throws an exception if they do not match, returns true or false
	 * @param password 	
	 * @param passwordConfirm
	 * @return
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		
		if(!password.equals(passwordConfirm)) {		
			return false;							// if passwords dont equal, return false
		}else 
			return true;							// else return true
	}
	/**
	 * This method checks if the password length is valid, throws exception if length < 6
	 * @param password
	 * @return
	 * @throws LengthException
	 */
	public static boolean isValidLength(String password) throws LengthException {
		
		if(password.length() < 6) {
			throw new LengthException();			// if password < 6, throws Length Exception
		}else
			return true;							// else return true
		
	}
	/**
	 * This method checks if password has an upper case character, throws exception if no upper case character
	 * @param password
	 * @return
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		
		char[] stringArray = password.toCharArray();	// takes string and sends it to a char array
		boolean flag = false;
		
		for(char ch : stringArray) {					// Enhanced for loop to iterate through array checking for an upper case char
			if(Character.isUpperCase(ch)) {
				flag = true;							// if upper case is found, flag == true
			}
		}
		
		if(flag != true) {
			throw new NoUpperAlphaException();			// if flag not equal true, throws NoUpper exception
		}
		return flag;									// return boolean output
		
	}
	/**
	 * This method checks if password has a Lower case character, throws exception if no Lower case character
	 * @param password
	 * @return
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		
		char[] stringArray = password.toCharArray();
		boolean flag = false;
		
		for(char ch : stringArray) {
			if(Character.isLowerCase(ch)) {				// Similar to previous method but checks if char is LowerCase
				flag = true;
			}
		}
		
		if(flag != true) {
			throw new NoLowerAlphaException();			// throw noLowerAlpha Exception if no lower case was found
		}
		return flag;
		
	}
	/**
	 * This method checks if password has a digit, throws exception if digit not found
	 * @param password
	 * @return
	 * @throws NoDigitException
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		
		char[] stringArray = password.toCharArray();	// password string to char array
		boolean flag = false;							
		
		for(char ch : stringArray) {					// iterate through char array
			if(Character.isDigit(ch)) {					// checks for a digit
				flag = true;							// change flag to true if there is a digit
			}
		}
		
		if(flag != true) {
			throw new NoDigitException();				// throw no digit exception if no digit was found
		}
		return flag;
	}
	/**
	 * Method checks if password contains a special character, uses Pattern and Matcher and returns result
	 * @param password
	 * @return
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar​(String password) throws NoSpecialCharacterException {
		String re = "[a-zA-Z0-9]*"; 	  // pattern to find special char	  
		String text = password;			  
		
		Pattern pt = Pattern.compile(re); // compiles the regex pattern for the matcher
		Matcher mt = pt.matcher(text);	  // compares pattern to the password string	
		
		
		return (!mt.matches());			  // returns result
	}
	/**
	 * Method checks if password has more than 2 elements in a string share the same char
	 * @param password
	 * @return
	 * @throws InvalidSequenceException
	 */
	public static boolean NoSameCharInSequence​(String password) throws InvalidSequenceException {
		
		boolean noSameChar = true;										
		for(int i = 0; i < password.length()-2; i++) {
			if(password.charAt(i) == password.charAt(i + 1)) {		// Checks if current char at position i == char at position i + 1 (next element over)
				if(password.charAt(i+1) == password.charAt(i+2)) {	// Check if char at position (i+1) == char at position (i+2) (second char equals third char)
					noSameChar = false;		
					throw new InvalidSequenceException();
				}
			}
		}
		return noSameChar;											// return true if no exception was thrown
		
	}
	/**
	 * Checks password if its valid, throw appropriate exception if certain criteria fails
	 * @param password
	 * @return
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword​(String password) throws LengthException, NoUpperAlphaException, 
																			NoLowerAlphaException, NoDigitException, 
																			NoSpecialCharacterException, InvalidSequenceException {
		boolean valid = false;
		boolean length = true,
				upAlpha = true,
				lowAlpha = true,
				digit = true,
				specChar = true,
				inSeq = true;
		
		if(isValidLength(password) == false) {					// if statement that calls isValidLength method and checks if output == false
			length = false;										// throw exception if condition is met
			throw new LengthException();
		}
		if(hasUpperAlpha(password) == false) {					
			upAlpha = false;
			throw new NoUpperAlphaException();					// throw exception if condition is met
		}
		if(hasLowerAlpha(password) == false) {
			lowAlpha = false;
			throw new NoLowerAlphaException();					// throw exception if condition is met
		}
		if(hasDigit(password) == false) {
			digit = false;
			throw new NoDigitException();						// throw exception if condition is met
		}
		if(hasSpecialChar​(password) == false) {
			specChar = false;
			throw new NoSpecialCharacterException();			// throw exception if condition is met
		}
		if(NoSameCharInSequence​(password) == false) {
			inSeq = false;
			throw new InvalidSequenceException();				// throw exception if condition is met
		}			
		if(length&&upAlpha&&lowAlpha&&digit&&specChar&&inSeq != true) {	// checks if at least one variable != true
			valid = false;
			return valid;										// return false if condition is met		
		}
		else {
			valid = true;										
			return valid;										// else return true
		}
		
	}
	/**
	 * This method checks if password parameter is between 6 and 9, then returns result
	 * @param password
	 * @return
	 */
	public static boolean hasBetweenSixAndNineChars​(String password) {
		if(password.length() >= 6 && password.length() <= 9) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * This method checks if password is weak, first checks if password is valid then checks if the password is between 6 and 9, returns result
	 * @param password
	 * @return
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword​(String password) throws WeakPasswordException {
		boolean weak = false;
		try {
			if(isValidPassword​(password) == true) {					// asserts that its a valid password
				if(hasBetweenSixAndNineChars​(password) == true) {	// checks if password is between 6 and 9 
					weak = true;									
				}
			}
		}catch(Exception e) {			// catches exceptions thrown by isValidPassword method, keeps saying method does not handle sequence exception for some reason
			e.printStackTrace();		// print throwable
		}
		if(weak == true) {
			throw new WeakPasswordException();	// throw exception if password is indeed true
		}
		return weak;
	}
	/**
	 * Method takes an array of passwords and collects those that are invalid into another array and returns it
	 * @param passwords
	 * @return
	 */
	public static ArrayList<String> getInvalidPasswords​(ArrayList<String> passwords) {
		ArrayList<String> invalidP = new ArrayList<>();	// new arrayList for invalid passwords
		for(String p : passwords) {						// enhanced for loop to read through ArrayList for each String
			try {										// try/ catch method to catch which ever exception is thrown
			isValidPassword​(p);	
			}catch(Exception e) {
				String s = p + " " + e.getMessage();	// creates a string containing password and the exception it threw
				invalidP.add(s);						// adds it to ArrayList
			}
		}
		return invalidP;								// returns ArrayList
	}
	
	
}
