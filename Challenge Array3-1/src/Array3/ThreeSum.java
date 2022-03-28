package Array3;

import java.util.Arrays;

public class ThreeSum{

    public static void main(String[] args) {
    	
    	// Default numberlist & target
        int[] nums = {12, 3, 2, 1, 5, -6, 6, -8};
        int target = 0;
        
        // Print the introduction
 		System.out.print("/ *******************************************************************************\n"
 				+ "\tThis program will print the three numbers that they add up to target.\n"
 				+ "  ******************************************************************************* /\n\n");

        
        System.out.println("\tThe numbers in the list are: " + Arrays.toString(nums));
        System.out.println("\tThe target is: " + target + "\n");
        System.out.print("\tThe possible answer(s) is/are: ");
        
        // Iterate nums
        for (int i = 0; i < nums.length; i++) {
        	
        	for (int j = i + 1; j < nums.length; j++) {
        		
        		for (int k = j + 1 ; k < nums.length; k++) {
        			
            		if (nums[k] == target - nums[j] - nums[i]) { 
            			System.out.print("[" + nums[i] + "," + nums[j] + "," + nums[k] + "]");
            		} // end of if
            		
        		} // end of for loop (k)
        		
        	} // end of for loop (j)
        	
        } // end of for loop (i)
       
    }

}// end of class TwoSum
