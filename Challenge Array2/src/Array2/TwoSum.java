package Array2;

import java.util.Arrays;

public class TwoSum{

    public static void main(String[] args) {
    	
    	// Default numberlist & target
        int[] nums = {6, -1, 1, 11, 8, -4, 5, 3};
        int target = 11;
        
        // Print the introduction
 		System.out.print("/ *******************************************************************************\n"
 				+ "\tThis program will print the two numbers that they add up to target.\n"
 				+ "  ******************************************************************************* /\n\n");

        
        System.out.println("\tThe numbers in the list are: " + Arrays.toString(nums));
        System.out.println("\tThe target is: " + target + "\n");
        System.out.print("\tThe possible answer(s) is/are: ");
        
        // Iterate nums
        for (int i = 0; i < nums.length; i++) {
        	
        	for (int j = i + 1; j < nums.length; j++) {
        		
        		// i = 6, j = 5 & i = 8, j = 3
        		if (nums[j] == target - nums[i]) { // if (5 == 11 - 6) & if (8 == 11 - 3)
        			System.out.print("[" + nums[i] + "," + nums[j] + "]");
        		} // end of if
        		
        	} // end of for loop (j)
        	
        } // end of for loop (i)
       
    }

}// end of class TwoSum
