package Array3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListThreeSum {

	public static List<List<Integer>> threeSum(int[] numbers) {
		List<List<Integer>> numbers_list = new ArrayList<>();
		
		// Sort the list
		// [-8, -6, 1, 2, 3, 5, 6, 12]
		Arrays.sort(numbers);
		
		
		for (int i = 0; i < numbers.length; i++) {
			// i -> "-8"
			
			// Points to the second number -> "-6"
			int start = i + 1;
			
			// Points to the last number -> "12"
			int end = numbers.length - 1;
			
			// Ignore duplicate
			if (i > 0 && numbers[i] == numbers[i -1]) {
				continue;
			}
		
			// Terminate the value of a start index [0] at the end
			while (start < end) {
				
				// Ignore the duplicate 
				if (end < numbers.length - 1 && numbers[end] == numbers[end +1]) {
					end--;
					continue;
				}
				
				// Find possible answers
				if (numbers[i] + numbers[start] + numbers[end] == 0) {			// (-8) + (-6) + (12) = -2 != 0, then go to else if
					List<Integer> val = Arrays.asList(numbers[i], numbers[start], numbers[end]);
					numbers_list.add(val);
					start++;
					end--;	
				} else if (numbers[i] + numbers[start] + numbers[end] < 0) {	// (-8) + (-6) + (12) = -2 < 0 
					start++;	// It will be (-8) + (1) + (12) = 5 > 0, then execute this again until at the end
				} else {
					end--;		
				}
			}
		}
		return numbers_list;
	} // end of List<List<Integer>> threeSum(int[] numbers)
	
	
	public static void main(String[] args) {
		int [] numbers = {12, 3, 2, 1, 5, -6, 6, -8};
		
		List<List<Integer>> numbers_list = threeSum(numbers);
		
		
		// Print the introduction & result
 		System.out.print("/ *******************************************************************************\n"
 				+ "\tThis program will print the three numbers that they add up to target.\n"
 				+ "  ******************************************************************************* /\n\n");
 		System.out.println("\tThe numbers in the array are: " + Arrays.toString(numbers));
        System.out.println();
 		System.out.println("\tThe possible answer(s) is/are:" + numbers_list);


	} // end of  main(String[] args)
	
	
} // end of class ArrayListThreeSum


