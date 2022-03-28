package Array4;

import java.util.Arrays;

public class FourSum{

    public static void main(String[] args) {
    	
    	// Default numberlist & target
        int[] nums = {2, -1, 1, 6, 4, 7};
        int target = 16;
        
        // Print the introduction
 		System.out.print("/ *******************************************************************************\n"
 				+ "\tThis program will print the four numbers that they add up to target.\n"
 				+ "  ******************************************************************************* /\n\n");

        
        System.out.println("\tThe numbers in the list are: " + Arrays.toString(nums));
        System.out.println("\tThe target is: " + target + "\n");
        System.out.print("\tThe possible answer(s) is/are: ");
        
        // Iterate nums
        for (int i = 0; i < nums.length; i++) {
        	
        	for (int j = i + 1; j < nums.length; j++) {
        		
        		for (int k = j + 1 ; k < nums.length; k++) {
        			
        			for (int x = k + 1 ; x < nums.length; x++) {
        				
        				if (nums[x] == target - nums[k] - nums[j]- nums[i]) { 
                			System.out.print("[" + nums[i] + "," + nums[j] + "," + nums[k] + "," + nums[x]+ "]");
                		} // end of if
        				
        			}
        			
            		
        		} // end of for loop (k)
        		
        	} // end of for loop (j)
        	
        } // end of for loop (i)
       
    }

}// end of class TwoSum
