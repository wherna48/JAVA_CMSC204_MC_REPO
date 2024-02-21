
public class StackUnderflowException extends Exception{
	public StackUnderflowException() {
		super("top or pop method is called on an empty stack");
	}
}
