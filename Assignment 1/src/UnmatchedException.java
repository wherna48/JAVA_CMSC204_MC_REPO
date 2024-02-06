/**
 * Class for the UnmatchedException
 * @author herna
 *
 */
public class UnmatchedException extends Exception {
	/**
	 * Method that sends custom message when exception is thrown to parent class
	 */
	public UnmatchedException() {
		super("Passwords do not match");
	}
}
