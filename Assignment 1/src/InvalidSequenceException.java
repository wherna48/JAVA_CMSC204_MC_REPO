/**
 * This Class extends Exception and will handle the invalidSequence exception and send the Exception message to the parent class
 * @author herna
 *
 */
public class InvalidSequenceException extends Exception {
	/**
	 * Custom InvalidSequence exception message to be displayed when password has 2 or more of the same char
	 */
	public InvalidSequenceException() {
		super("Password contains more than 2 of the same character in sequence");
	}
}
