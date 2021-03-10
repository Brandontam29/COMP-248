// -------------------------------------------------------
// Assignment 3
// Written by: Brandon Tam 40100539
// For COMP 248 Section U – Winter 2021
// --------------------------------------------------------
/*
 * This program compresses images by the quantization of pixel values.
 */

import java.util.Scanner;

public class ImageQuantization {

	public static void main(String[] args) {
		// On open program message
		System.out.println(
				"******************************************\n  Welcome to Image Quantization\n******************************************");
		System.out.println("\nPlease input the pixel values");

		// Variable declaration
		Scanner keyIn = new Scanner(System.in);
		int pixel;
		int[] imagePixels = new int[10];

		for (int i = 0; i < imagePixels.length; i++) {

			// Prompt for pixel value
			System.out.print("Pixel " + (i + 1) + ": ");
			pixel = keyIn.nextInt();

			// Store compressed the value
			imagePixels[i] = compressPixel(pixel);

		}

		// Print final quantized values
		System.out.println("\nQuantized pixel values: ");
		for (int i = 0; i < imagePixels.length; i++) {
			System.out.print(imagePixels[i] + " ");
		}

		keyIn.close();
	}

	// Return compressed pixel value
	static int compressPixel(int pix) {
		// Declare double variable decimal sensitive calculations
		double doubleP;

		// Analyze and manipulate integer
		if (pix == 0) {
			pix = 10;
		} else {
			if (pix > 180) {
				pix = 190;
			} else {
				if (pix % 20 == 0) {
					pix -= 10;
				} else {
					doubleP = (double) pix;
					doubleP = Math.ceil(doubleP / 10) * 10;
					pix = (int) doubleP;
					if (pix % 20 == 0) {
						pix -= 10;
					}
				}
			}
		}
		return pix;
	}
}
