import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	private GradeBook g1, g2;

	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g1.addScore(95);
		g1.addScore(60);
		g1.addScore(75);
		g1.addScore(80);
		g1.addScore(55);
		
		g2 = new GradeBook(5);
		g2.addScore(49.5);
		g2.addScore(60.9);
		g2.addScore(71.4);
		g2.addScore(90.8);	
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(g1.toString().equals("95.0 60.0 75.0 80.0 55.0 "));
		assertEquals(g1.getScoreSize(), 5);
		
		assertTrue(g2.toString().equals("49.5 60.9 71.4 90.8 0.0 "));
		assertEquals(g2.getScoreSize(), 4);
		
	}

	@Test
	void testSum() {
		assertEquals(g1.sum(), 365.0);
		
		assertEquals(g2.sum(), 272.6);
	}

	@Test
	void testMinimum() {
		assertEquals(g1.minimum(), 55);
		assertEquals(g2.minimum(), 49.5);
	}

	@Test
	void testFinalScore() {
		assertEquals(g1.finalScore(), 310.0, 0.001);
		assertEquals(g2.finalScore(), 223.1, 0.001);
	}
	

}
