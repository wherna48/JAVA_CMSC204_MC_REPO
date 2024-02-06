/**
 * This class is for the NoUpperAlphaExcpetion
 * @author herna
 *
 */
public class NoUpperAlphaException extends Exception {
	/**
	 * Method that sends custom message when exception is thrown to parent class
	 */
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}
}
