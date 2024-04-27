
public class Town {
	
	private String name;
	
	/**
	 * this the name of the town
	 * @param name
	 */
	public Town(String name) {
		this.name = name;
	}
	
	/**
	 * copy constructor
	 * @param templateTown
	 */
	public Town(Town templateTown) {
		name = templateTown.getName();
	}
	
	/**
	 * compare method
	 * 
	 * @param o
	 * @return 
	 */
	public int compareTo(Town o) {
		return name.compareTo(o.getName());
	}
	
	/**
	 * returns if object name is the same as this objects town name
	 * @return 
	 */
	public boolean equals(Object obj) {
		return ((Town)obj).getName().equals(name);
	}
	
	/**
	 * gets name of the town
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * hashcode of the town name
	 * @return hashcode
	 */
	public int hashCode() {
		String s = getName();	// gets name
		int hash = 0;
		int g = 31;	// use of 31 since its a prime number and prime numbers give a better spread 
		for(int i = 0; i < s.length(); i++) {
			hash = g * hash + s.charAt(i);	// generates hash code for each char
		}
		return hash;
	}
	
	/**
	 * returns name of the town
	 */
	public String toString() {
		return getName();
	}
}
