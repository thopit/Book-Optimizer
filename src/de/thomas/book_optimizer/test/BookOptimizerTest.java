package de.thomas.book_optimizer.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.thomas.book_optimizer.implementation.BookOptimizer;

public class BookOptimizerTest {
	@Test
	public void testPrice() {
		int[] division = new int[5];
		division[0] = 0;
		division[1] = 0;
		division[2] = 0;
		division[3] = 0;
		division[4] = 3;

		assertEquals(3 * (1 * 8 * 1), BookOptimizer.getPrice(division), 0.001d);

		division[0] = 1;
		division[1] = 0;
		division[2] = 1;
		division[3] = 0;
		division[4] = 0;
		
		assertEquals(1 * (5 * 8 * 0.75) + 1 * (3 * 8 * 0.9), BookOptimizer.getPrice(division), 0.001d);

		division[0] = 0;
		division[1] = 2;
		division[2] = 0;
		division[3] = 0;
		division[4] = 0;

		assertEquals(2 * (4 * 8 * 0.8), BookOptimizer.getPrice(division), 0.001d);
	}

	@Test
	public void testOptimize() {
		int[] amounts = new int[5];
		amounts[0] = 0;
		amounts[1] = 0;
		amounts[2] = 0;
		amounts[3] = 0;
		amounts[4] = 0;
		
		assertEquals(0d, BookOptimizer.optimize(amounts), 0.001);
		
		
		amounts[0] = 1;
		amounts[1] = 0;
		amounts[2] = 0;
		amounts[3] = 0;
		amounts[4] = 0;

		assertEquals(8d, BookOptimizer.optimize(amounts), 0.001);

		
		amounts[0] = 2;
		amounts[1] = 2;
		amounts[2] = 2;
		amounts[3] = 1;
		amounts[4] = 1;

		assertEquals(51.2d, BookOptimizer.optimize(amounts), 0.001);
		
		amounts[0] = 2;
		amounts[1] = 1;
		amounts[2] = 1;
		amounts[3] = 1;
		amounts[4] = 0;

		assertEquals(33.6d, BookOptimizer.optimize(amounts), 0.001);
		
		
		amounts[0] = 3;
		amounts[1] = 2;
		amounts[2] = 4;
		amounts[3] = 2;
		amounts[4] = 1;
		
		assertEquals(78.8d, BookOptimizer.optimize(amounts), 0.001);
		
		
		amounts[0] = 1;
		amounts[1] = 2;
		amounts[2] = 3;
		amounts[3] = 4;
		amounts[4] = 5;
		
		assertEquals(100d, BookOptimizer.optimize(amounts), 0.001);
		
		
		amounts[0] = 5;
		amounts[1] = 5;
		amounts[2] = 4;
		amounts[3] = 5;
		amounts[4] = 4;
		
		assertEquals(141.2d, BookOptimizer.optimize(amounts), 0.001);
	}
}
