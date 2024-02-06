/**
 * Class for the WeakPasswordException
 * @author herna
 *
 */
public class WeakPasswordException extends Exception {
	/**
	 * Method that sends custom message when exception is thrown to parent class
	 */
	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters");
	}
}
