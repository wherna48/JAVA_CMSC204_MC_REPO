/**
 * This class extends Exception and handle InvalidNotationException when thrown
 * @author herna
 *
 */
public class InvalidNotationFormatException extends Exception{
	/**
	 * method that will send custom exception method
	 */
	InvalidNotationFormatException(){
		super("Notation format is incorrect");	// Sends custom message to exception parent class
	}
}
