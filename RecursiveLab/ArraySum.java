/**
 * Computes the sum of the array using Recurions
 * @author herna
 *
 */
public class ArraySum {
	/**
	 * Method to return the sum of the array
	 * @param a
	 * @param index
	 * @return
	 */
	public int sumOfArray (Integer[] a,int index) {
		if(index < 0) {
			return 0;	// Default statement - when index is less tham 0, return 0
		}else {
			return a[index] + sumOfArray(a, index-1);	// recursive code to calculate sum
		}		
	}
}
