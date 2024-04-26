import java.util.Queue;
import java.util.*;
import java.util.Random;

public class CarQueue {
	public Queue<Integer> queue;
	private Random random = new Random();
	
	public CarQueue(){
		queue = new LinkedList<>();
		
		queue.add(random.nextInt(4)); 	// random number between 0 - 3
		queue.add(random.nextInt(4));
		queue.add(random.nextInt(4));
		queue.add(random.nextInt(4));
		queue.add(random.nextInt(4));
		queue.add(random.nextInt(4));
	}
	public void addToQueue() {
		class addRandom implements Runnable{

			@Override
			public void run() {
				while (true) {
					queue.add(random.nextInt(4));
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
	}
	
	public int deleteQueue() {
		return queue.remove();
	}
}
