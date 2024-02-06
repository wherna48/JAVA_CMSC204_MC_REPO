/**
 * Exception class for LengthException
 * @author herna
 *
 */
public class LengthException extends Exception {
	/**
	 * This method sends custom message for a LengthException to parent class, Exception
	 */
	public LengthException() {
		super("The password must be at least 6 characters long");
	}
}
