package de.thomas.book_optimizer.implementation;

import java.util.Arrays;

public class BookOptimizer {


	//bookDivision[i] has to contain number of book sets with size 5 - i 
	public static double getPrice(int[] bookDivision) {
		double[] discount = {0.75d, 0.8d, 0.9d, 0.95d, 1.0d };
		double amount = 0d;

		for (int i = 0; i < bookDivision.length; i++) {
			amount += (5 - i) * bookDivision[i] * 8 * discount[i];
		}

		return amount;
	}

	//bookAmounts[i] has to contain the amount of books of type i + 1
	public static double optimize(int[] bookAmounts) {

		//Divide books into sets as large as possible
		Arrays.sort(bookAmounts);

		int[] divisions = new int[5];

		for (int step = 0; step < bookAmounts.length; step++) {
			divisions[step] = bookAmounts[step];

			for (int k = 0; k < bookAmounts.length; k++) {
				bookAmounts[k] -= divisions[step];
			}
		}

		//Merge 5 and 3 sets to 2 new 4 sets
		while (divisions[0] > 0 && divisions[2] > 0) {
			divisions[0]--;
			divisions[2]--;
			divisions[1] += 2;
		}

		return getPrice(divisions);
	}

	public static void main(String[] args) {
		if (args.length != 5) {
			System.out.println("Usage: BookOptimizer <a> <b> <c> <d> <e>");
			System.exit(1);
		}

		int[] bookAmounts = new int[5];

		try {
			for (int k = 0; k < bookAmounts.length; k++) {
				bookAmounts[k] = Integer.parseInt(args[k]);
			}
		} catch (NumberFormatException e) {
			System.out.println("a, b, c, d, e must be integers");
			System.exit(1);
		}

		System.out.println(optimize(bookAmounts));
	}
}
