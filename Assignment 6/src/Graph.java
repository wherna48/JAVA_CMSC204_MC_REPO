import java.util.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road>{
	
	Set<Town> towns;	// set of towns
	Set<Road> roads; 	// set of roads
	
	Map<Town, Integer> distances;
	Map<Town, Town> predecessors;
	
	Set<Town> visited;
    Set<Town> unvisited;
    

    /**
     * graph constructor
     */
	public Graph() {
		roads = new HashSet<>();
		towns = new HashSet<>();
		
		distances = new HashMap<>();	// left over maps for shortest path algorithms that i could not get to work
		predecessors = new HashMap<>();
		
		visited = new HashSet<>();
		unvisited = new HashSet<>();
	}
	
	/**
	 * gets the road of two given towns
	 * @return Road
	 * @param sourceVertex
	 * @parm destinationVertex
	 */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		for (Road road : roads) {
			if(road.contains(sourceVertex) && road.contains(destinationVertex)) { // checks if road contains the proper vertexs, i.e. the correct Towns
				return road;
			}
		}
			return null;	// return null if road does not exist
	}
	
	/**
	 * adds edge to road set
	 * @return Road
	 * @param sourceVertex
	 * @param destinationVertex
	 * @param weight
	 * @param description
	 */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road addRoad = new Road(sourceVertex, destinationVertex, weight, description); // creates instance of road
		
		roads.add(addRoad); // adds road to the set
		
		return addRoad;	// return set
		
	}
	/**
	 * add vertex to town set
	 * @param v
	 * @param boolean
	 */
	@Override
	public boolean addVertex(Town v) {
		 Town addTown = new Town(v);
		 
		 for(Town town : towns) {
			 if(town.equals(v)) {	// checks if there are matches
				 return false;	// returns false if there is another town v
			 }
		 }
		 towns.add(addTown);	// else adds vertex to the set
		 
		 return true;
	}
	/**
	 * checks if two given towns contain a road or edge
	 * @return boolean
	 * @param sourceVertex
	 * @param destinationVertex
	 */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for(Road road : roads) {
			if(road.contains(sourceVertex)&& road.contains(destinationVertex)) {
				return true;	// return true if edge contains going to source and destination vertexs
			}
		}
		return false;
	}
	/**
	 * checks if town set contains vertex
	 * @return boolean
	 * @param v
	 */
	@Override
	public boolean containsVertex(Town v) {
		for(Town town : towns) {
			if(town.equals(v)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * returns set of roads
	 * @return Set<Road>
	 */
	@Override
	public Set<Road> edgeSet() {
		return roads;
	}
	/**
	 * gets the edges of a vertex
	 * @return Set<Road>
	 */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> roadsOfTown = new HashSet<>();	
		
		for(Road road : roads) {
			if(road.contains(vertex)) {	
				roadsOfTown.add(road);	// adds road to the set
			}
		}
		return roadsOfTown;
	}
	/**
	 * removes an edge
	 * @return road
	 * @param sourceVertex
	 * @param destinationVertex
	 * @param weight
	 * @param description
	 */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road toRemove = null;
		
		for(Road road : roads) {
			if(road.contains(sourceVertex) && road.contains(destinationVertex)) {	// check if road contains source and destination
				if(road.getWeight()==weight && road.getName().equals(description)) {	// checks if road matches weight and town name
					toRemove = road;	// set value to the road
					roads.remove(road);	// remove road from the set
					break;	// break out of for loop
				}
			}
		}
		return toRemove;	// return road that was remove
	}
	/**
	 * remove vertex
	 */
	@Override
	public boolean removeVertex(Town v) {
		towns.remove(v);	// remove town
		removeRoadsConnectedToTown(v);	// helper method to remove edges connected to the town
		return true;
	}
	/**
	 * helper method to remove edges from town
	 * @param town
	 */
	public void removeRoadsConnectedToTown(Town town) {
		Set<Road> conRoads = edgesOf(town);	// gets the edges of the town in the parameter
		
		for(Road road : conRoads) {	// loop the roads in the set and remove the edges
			removeEdge(road.getSource(), road.getDestination(), road.getWeight(), road.getName());	
		}
	}
	/**
	 * returns set of towns
	 * return Set<Town>
	 */
	@Override
	public Set<Town> vertexSet() {
		return towns;
	}
	/**
	 * method to find the shortest path, could not get it to work so left empty in frustration
	 */
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
				return null;
	}
	/**
	 * same deal as prior method
	 */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		// TODO Auto-generated method stub
	}
	
}
