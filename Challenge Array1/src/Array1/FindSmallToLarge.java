package Array1;


/**
 * @author Sehee
 *
 */

public class FindSmallToLarge {

	public static void main(String[] args) {
		// Create an array
		int[] arr = {-5, 10, 8, 5, 3, 1, 9, 7, 6, 20, 4, 2};
		
		// Default Value of max & min
		int max = arr[0];
		int min = arr[0];
		
		// Find max & min
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] > max) {
					max = arr[i];
				}
				if (arr[j] < min) {
					min = arr[i];
				}
			}
			
		}
		
		// Print the result
		System.out.print("/ ****************************************************************************\n"
				+ "\tThis program will print the smallest and the largest elements.\n"
				+ "  **************************************************************************** /\n\n");

		System.out.println("\tSmallest Element: " + min);
		System.out.println("\tLargest Element: " + max);
		

	}

}
