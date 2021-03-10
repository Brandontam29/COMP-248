// -------------------------------------------------------
// Assignment 3
// Written by: Brandon Tam 40100539
// For COMP 248 Section U – Winter 2021
// --------------------------------------------------------
/*
 * This program generates a random 3x3 Magic Matrix (or Magic Square).
 */

import java.util.Random;

public class MagicMatrix {
	public static void main(String[] args) {
		System.out.println(
				"******************************************\n        Welcome to Magic Matrix\n******************************************");

		System.out.println("The randomly generated matrix is: ");

		// Variable declaration and matrix initialization
		Random rand = new Random();
		int randomNum;

		int size = 3;
		int[][] magicMatrix = new int[size][size];

		// Fill in unchanging center value
		magicMatrix[1][1] = 5;

		// Generate random corner value
		randomNum = rand.nextInt(4) * 2 + 2;

		// Fill in first diagonal from random corner value
		magicMatrix[0][0] = randomNum;
		magicMatrix[2][2] = 10 - randomNum;

		// Generate different random corner value
		while (randomNum == magicMatrix[0][0] || randomNum == magicMatrix[2][2]) {
			randomNum = rand.nextInt(4) * 2 + 2;
		}

		// Fill in second diagonal
		magicMatrix[0][2] = randomNum;
		magicMatrix[2][0] = 10 - randomNum;

		// Loop through matrix and fill in unassigned squares by mathematical
		// calculation
		for (int a = 0; a < magicMatrix.length; a++) {
			for (int b = 0; b < magicMatrix.length; b++) {
				if (magicMatrix[a][b] == 0) {
					if (b == 1) {
						magicMatrix[a][b] = 15 - magicMatrix[a][b - 1] - magicMatrix[a][b + 1];
					} else {
						magicMatrix[a][b] = 15 - magicMatrix[a - 1][b] - magicMatrix[a + 1][b];
					}
				}
			}
		}

		// Print the matrix if no error
		if (!testSums(magicMatrix)) {
			for (int i = 0; i < magicMatrix.length; i++) {
				for (int j = 0; j < magicMatrix.length; j++) {
					System.out.print(magicMatrix[i][j] + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("Error in generating appropriate matrix");
		}
	}

	// Test for unique numbers
	static Boolean testUnique(int[][] matrix) {
		// Declare variables
		int[][] allValues = new int[9][9];
		int spot = 0;
		Boolean error = false;

		for (int a = 0; a < matrix.length; a++) {
			for (int b = 0; b < matrix.length; b++) {
				allValues[spot][0] = matrix[a][b];
				allValues[0][spot] = matrix[a][b];
				spot++;
			}
		}
		
		for (int a = 0; a < 1; a++) {
			for (int b = 0; b < allValues.length; b++) {
				allValues[0][b] = allValues[b][0];
				allValues[0][spot] = matrix[a][b];
				spot++;
			}
		}
		return error;
	}

	// Test matrix for unequal sums
	static Boolean testSums(int[][] matrix) {
		// Declare variables
		int[] testRow = new int[3];
		int[] testCol = new int[3];
		int[] testDiag = new int[2];
		Boolean error = false;

		// Create set of sums to compare
		for (int a = 0; a < testRow.length; a++) {
			for (int b = 0; b < testCol.length; b++) {
				testRow[a] += matrix[a][b];
				testCol[b] += matrix[a][b];
			}
		}

		// Compare row and column sums
		for (int a = 0; a < testRow.length; a++) {
			for (int b = 0; b < testCol.length; b++) {
				if (testRow[a] != testCol[b]) {
					error = true;
				}
			}
		}

		// Test diagonal sums
		testDiag[0] = matrix[0][0] + matrix[1][1] + matrix[2][2];
		testDiag[1] = matrix[0][2] + matrix[1][1] + matrix[2][0];

		if (testDiag[0] != testDiag[1]) {
			error = true;
		}

		return error;
	}

}
