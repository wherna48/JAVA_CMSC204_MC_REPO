
public class StackOverflowException extends Exception{
	public StackOverflowException() {
		super("A push method was called on a full stack");
	}
}
