
public class QueueUnderflowException extends Exception{
	public QueueUnderflowException() {
		super("A dequeue method was used on an empty queue");
	}
}
