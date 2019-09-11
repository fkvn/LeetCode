package topInterviewQuestions;

import java.util.Arrays;

//	Given an array, rotate the array to the right by k steps, where k is non-negative.

/*	Example 1:
 * 
 * 	Input: [1,2,3,4,5,6,7] and k = 3
 	Output: [5,6,7,1,2,3,4]
	Explanation:
		rotate 1 steps to the right: [7,1,2,3,4,5,6]
		rotate 2 steps to the right: [6,7,1,2,3,4,5]
		rotate 3 steps to the right: [5,6,7,1,2,3,4]
*/

/*	Example 2:
 * 	Input: [-1,-100,3,99] and k = 2
	Output: [3,99,-1,-100]
	Explanation: 
		rotate 1 steps to the right: [99,-1,-100,3]
		rotate 2 steps to the right: [3,99,-1,-100]
*/

/*	Requirement:
	Could you do it in-place with O(1) extra space?
*/

// unsolved problem

public class RotateArray {

	public static void main(String[] args) {
		int[] arr = {-1,-100,3,99};
		
		System.out.println("Ori: " + Arrays.toString(arr));
		
		int k = 2;
		rotate(arr, k);
		
		System.out.println("After rotated: " + Arrays.toString(arr));
		
	}
	
    public static void rotate(int[] nums, int k) {
    	if (nums.length > k)
    		rotateHelper(nums, k, nums[0], k);
    }
    
    public static void rotateHelper(int[] nums, int jump, int preVal, int k) {
    	if (jump != 0) {
    		int temp = nums[jump];
    		nums[jump] = preVal;
    		
    		rotateHelper(nums, (jump + k) % nums.length, temp, k);
    	}
    	
    	else
    		nums[jump] = preVal;
    }

}
