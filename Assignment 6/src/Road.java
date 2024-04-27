
public class Road implements Comparable<Road>{
	private Town source;
	private Town destination;
	private int weight;
	private String name;
	
	/**
	 * constructor
	 * 
	 * @param source
	 * @param destination
	 * @param degrees
	 * @param name
	 */
	public Road(Town source, 
				Town destination, 
				int degrees,
				String name) {
		this.source = source;
		this.destination = destination;
		weight = degrees;
		this.name = name;
	}
	
	/**
	 * constructor with weight prest of 1
	 * @param source
	 * @param destination
	 * @param name
	 */
	public Road(Town source,
				Town destination,
				String name) {
		this.source = source;
		this.destination = destination;
		this.name = name;
		weight = 1;
	}
	
	/**
	 * returns boolean result if the road contains a given town
	 * @param town
	 * @return
	 */
	public boolean contains(Town town) {
		if(source.equals(town)) {
			return true;
		}else if(destination.equals(town)){
			return true;
		}else {
			return false;
		}
	}
	/**
	 * gets road name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * gets destination towm
	 */
	public Town getDestination() {
		return destination;
	}
	
	/**
	 * gets the town origin point
	 * @return
	 */
	public Town getSource() {
		return source;
	}
	
	/**
	 * to string method returning distance from source to destination
	 */
	public String toString() {
		return source + " via " + name + " to " + destination + weight + " mi";
	}
	
	/**
	 * return weight of this object
	 * @return weight
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * equals method to check if another road object matches this object
	 */
	public boolean equals(Object r) {
		Road newRoad = (Road)r;
		if (newRoad.destination == destination && newRoad.source == source) {
			return true;
		} else if(newRoad.destination == source && newRoad.source == destination) {
			return true;
		}
		return false;
	}
	/**
	 * compare to method
	 */
	@Override
	public int compareTo(Road o) {
		return weight - o.getWeight(); // 0 means the same, positive or negative = not the same 
	}

}
