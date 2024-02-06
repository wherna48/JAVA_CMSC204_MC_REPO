/**
 * The class for the NoDigitException 
 * @author herna
 *
 */
public class NoDigitException extends Exception {
	/**
	 * Sends custom message when NoDigitException is thrown in Utility program
	 */
	public NoDigitException() {
		super("The password must contain at least one digit");
	}
}
