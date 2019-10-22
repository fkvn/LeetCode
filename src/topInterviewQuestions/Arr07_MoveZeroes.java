package topInterviewQuestions;

import java.util.Arrays;

/* 	Given an array nums, write a function to move all 0's to the end of it 
  		while maintaining the relative order of the non-zero elements.
  		
 *	Example:		
		Input: [0,1,0,3,12]
		Output: [1,3,12,0,0]
		
 * 	Note:
		You must do this in-place without making a copy of the array.
		Minimize the total number of operations.*/


public class Arr07_MoveZeroes {

	
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		
		moveZeroes(nums);
		
		
		System.out.println(Arrays.toString(nums));

	}

    public static void moveZeroes(int[] nums) {
        int index = -1;
        
        for (int i = 0; i < nums.length; i++)
        	if (nums[i] != 0)
        		swap(nums, i, ++index);
    }
    
    public static void swap(int[] arr, int a, int b) {
    	
    	//swap in-place concept
    	if (a != b) {
	    	arr[a] = arr[a] + arr[b]; // a = 2 + 1 = 3
	    	arr[b] = arr[a] - arr[b]; // b = 3 - 1 = 2
	    	arr[a] = arr[a] - arr[b]; // a = 3 - 2 = 1
    	}
    }
}
