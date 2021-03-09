package packages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTest {
	Gradebook book1;
	Gradebook book2;

	@BeforeEach
	void setUp() throws Exception {
		
		book1 = new Gradebook(5);
		book2 = new Gradebook(5);
		// grade scale from 1 to 10
		book1.addScore(7);
		book1.addScore(9);
		book1.addScore(9);
		book1.addScore(1);
		book1.addScore(10);
		
		book2.addScore(6);
		book2.addScore(5);
		book2.addScore(10);
		book2.addScore(3);
		book2.addScore(0);
	}

	@AfterEach
	void tearDown() throws Exception {
		book1 = null;
		book2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(book1.toString().equals("7.0 9.0 9.0 1.0 10.0"));
		assertEquals("addScore test case scoreSize is ",5,book1.getScoresSize());
		
		assertTrue(book1.toString().equals("6.0 5.0 10.0 3.0 0.0"));
		assertEquals("addScore test case scoreSize is ",5,book2.getScoresSize());
	}

	@Test
	void testSum() {
		assertEquals(36,book1.sum(),0.01);
		assertEquals(21,book2.sum(),0.01);
	}

	@Test
	void testMinimum() {
		assertEquals(1,book1.minimum(),0.01);
		assertEquals(0,book2.minimum(),0.01);
	}

	@Test
	void testFinalScore() {
		assertEquals("final score for book1: ", 35.0,book1.finalScore());
		assertEquals("final score for book1: ", 21.0,book2.finalScore());
	}

	@Test
	void testGetScoresSize() {
		assertEquals("ScoreSize for book1: ",5,book1.getScoresSize());
		assertEquals("ScoreSize for book2: ",5,book2.getScoresSize());
		
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
