import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphTest_STUDENT {
	private GraphInterface<Town, Road> graph;
	private Town[] town;
	
	
	@BeforeEach
	void setUp() throws Exception {
		graph = new Graph();
		town = new Town[10];
		
		 for (int i = 1; i < 10; i++) {
			  town[i] = new Town("Town_" + i);
			  graph.addVertex(town[i]);
		  }
		 
		  graph.addEdge(town[1], town[2], 5, "RhodesIsland blvd");
		  graph.addEdge(town[1], town[3], 4, "SilverSpring");
		  graph.addEdge(town[1], town[5], 6, "Colin Rd");
		  graph.addEdge(town[3], town[7], 2, "Texas's Warehouse");
		  graph.addEdge(town[3], town[8], 5, "Blvd of broken dreams");
		  graph.addEdge(town[4], town[8], 2, "Road_6");
		  graph.addEdge(town[6], town[9], 1, "Road_7");
	}

	@AfterEach
	void tearDown() throws Exception {
		graph = null;
	}

	@Test
	void testGetEdge() {
		assertEquals(false, graph.containsEdge(town[2], town[7]));
		graph.addEdge(town[2], town[7], 7, "Surtr's Bedroom");
		assertEquals(true, graph.containsEdge(town[2], town[7]));
	}

	@Test
	void testAddEdge() {
		assertEquals(false, graph.containsEdge(town[1], town[8]));
		graph.addEdge(town[1], town[8], 1, "Road_huh");
		assertEquals(true, graph.containsEdge(town[1], town[8]));
	}

	@Test
	void testAddVertex() {
		Town newTown = new Town("Sparta");
		
		assertEquals(false, graph.containsVertex(newTown));
		graph.addVertex(newTown);
		assertEquals(true, graph.containsVertex(newTown));
	}

	@Test
	void testContainsEdge() {
		assertEquals(true, graph.containsEdge(town[3], town[8]));
		assertEquals(false, graph.containsEdge(town[9], town[8]));
	}

	@Test
	void testContainsVertex() {
		assertEquals(false, graph.containsVertex(new Town("town_doesNotExist")));
		assertEquals(true, graph.containsVertex(new Town("Town_7")));
	}

	@Test
	void testEdgeSet() {
		Set<Road> roads = graph.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		
		Collections.sort(roadArrayList);
		
		assertEquals("Blvd of broken dreams", roadArrayList.get(0));
		assertEquals("Colin Rd", roadArrayList.get(1));
		assertEquals("RhodesIsland blvd", roadArrayList.get(2));
		assertEquals("Road_6", roadArrayList.get(3));
		assertEquals("Texas's Warehouse", roadArrayList.get(6));
			
	}

	@Test
	void testEdgesOf() {
		Set<Road> roads = graph.edgesOf(town[1]);
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		
		assertEquals("RhodesIsland blvd", roadArrayList.get(1));

		assertEquals("Colin Rd", roadArrayList.get(0));
		assertEquals("SilverSpring", roadArrayList.get(2));
	}

	@Test
	void testRemoveEdge() {
		assertEquals(true, graph.containsEdge(town[3], town[7]));
		graph.removeEdge(town[3], town[7], 2, "Texas's Warehouse");
		assertEquals(false, graph.containsEdge(town[3], town[7]));
	}

	@Test
	void testRemoveVertex() {
		assertEquals(true, graph.containsVertex(town[5]));
		graph.removeVertex(town[5]);
		assertEquals(false, graph.containsVertex(town[5]));
	}

	@Test
	void testVertexSet() {
		Set<Town> towns = graph.vertexSet();
		assertEquals(true, towns.contains(town[1]));
		assertEquals(true, towns.contains(town[9]));
		assertEquals(true, towns.contains(town[8]));
		assertEquals(true, towns.contains(town[2]));
		assertEquals(true, towns.contains(town[5]));
	}

}
