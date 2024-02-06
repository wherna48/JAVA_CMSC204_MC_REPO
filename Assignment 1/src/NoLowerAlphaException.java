/**
 * The class for the NoLowerAlphaException
 * @author herna
 *
 */
public class NoLowerAlphaException extends Exception {
	/**
	 * Sends custom message when NoLowerAlphaException is thrown to the parent class, Exception
	 */
	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character");
	}
}
