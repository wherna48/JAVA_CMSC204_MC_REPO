/**
 * The clas for the NoSpecialChar Exception
 * @author herna
 *
 */
public class NoSpecialCharacterException extends Exception {
	/**
	 * Method that sends custom message when exception is thrown to parent class
	 */
	public NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}
}
