
public class QueueOverflowException extends Exception{
	public QueueOverflowException() {
		super("An enqueue method was called on a full queue");
	}
}
