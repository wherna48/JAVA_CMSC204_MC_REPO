import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class TownGraphManager implements TownGraphManagerInterface{
	
	private Graph townGraph;
	
	public TownGraphManager() {
		townGraph = new Graph();
	}
	
	/**
	 * add road to the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * 
	 * @return true if the road was added successfully
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		if(townGraph.addEdge(new Town(town1), new Town(town2), weight, roadName) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Returns the name of the road connected by the two towns
	 * @param town1 name of town 1 
	 * @param town2 name of town 2 
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	@Override
	public String getRoad(String town1, String town2) {
		String roadNAme = townGraph.getEdge(new Town(town1), new Town(town2)).getName();
		
		return roadNAme;
		
	}
	
	/**
	 * adds town to the graph
	 * @param string v
	 * @return boolean
	 */
	@Override
	public boolean addTown(String v) {
		Town town1 = new Town(v);
		
		return townGraph.addVertex(town1); 
	}
	
	/**
	 * gets town with given name
	 * @param town name
	 * @return Town
	 */
	@Override
	public Town getTown(String townname) {
		if(containsTown(townname)) {	// checks if town exists
			return new Town(townname);	// returns town obj
		}else {
			return null;
		}
	}
	
	/**
	 * determines if town is already in the graph
	 * @param String v
	 * @return boolean
	 */
	@Override
	public boolean containsTown(String v) {
		Town town = new Town(v);
		if(townGraph.containsVertex(town)) {	// checks if the graph has the town
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * contains a road connection between two towns
	 * @param town1
	 * @param town2
	 * @return boolean
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		Town townOne = new Town(town1);
		Town towntwo = new Town(town2);
		
		if(townGraph.containsEdge(townOne, towntwo)) {	// checks if these two towns have a road connections
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * returns an array list of strings of road names
	 * @return ArrayList
	 */
	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> roads = new ArrayList<>();
		
		for(Road names : townGraph.edgeSet()) {
			roads.add(names.getName());
		}
		
		Collections.sort(roads);
		return roads;
	
	}
	/**
	 * delete road connected by two towns
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String roadName) {
		Town start =  new Town(town1);
		Town finish = new Town(town2);
		
		int weight = townGraph.getEdge(start, finish).getWeight(); // gets the weight of road 
		
		Road removedRoad = townGraph.removeEdge(start, finish, weight, roadName); 
		
		if(removedRoad == null) {
			return false;
		}else {
			return true;
		}
	}
	/**
	 * deletes town
	 * @param String v
	 * @return boolean
	 */
	@Override
	public boolean deleteTown(String v) {
		Town town1 = new Town(v);
		
		return townGraph.removeVertex(town1);
	}
	/**
	 * return a list of all towns
	 */
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> towns = new ArrayList<>();
		
		for(Town names : townGraph.vertexSet()) {
			towns.add(names.getName());
		}
		
		Collections.sort(towns);
		
		return towns;
		
	}
	/**
	 * return a list of all paths
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void populateTownGraph(File selectedFile) throws FileNotFoundException{
		// TODO Auto-generated method stub
		
	}

}
