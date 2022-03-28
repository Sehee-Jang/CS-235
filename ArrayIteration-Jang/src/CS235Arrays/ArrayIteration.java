package CS235Arrays;

import java.util.Arrays;
import java.util.Random;

public class ArrayIteration {

	public static void main(String[] args) {
		long startTime;
		double run;

		// Create an array
		int[] numbers = new int[100];

		// Store Start Time
		startTime = System.nanoTime();

		randomNumber(100, numbers);

		// Subtract startTime from the time when it ends
		run = System.nanoTime() - startTime;

		System.out.println("Generated random numbers are: " + Arrays.toString(numbers));
		System.out.println(" > Time Elapsed of Generating Random Numbers: " + run + " ns");
		System.out.println("");

		// Store Start Time
		startTime = System.nanoTime();

		populateArray(100, numbers);

		// Subtract startTime from the time when it ends
		run = System.nanoTime() - startTime;

		System.out.println("The size of the Arrays is: " + numbers.length);
		System.out.println(" > Time Elapsed of Populating Random Numbers: " + run + " ns");

	}

	public static void randomNumber(int number, int[] numbers) {

		Random r = new Random();

		// Generate 100 random numbers
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = r.nextInt(100) + 1; // range 0 - 100, if you want to generate negative numbers, change +1 to
												// *(-1)
		}

	}

	public static void populateArray(int size, int[] numbers) {
		int temp = 0;
		size = numbers.length;

		// Arrange in Assending Order
		Arrays.sort(numbers);

	}

}
