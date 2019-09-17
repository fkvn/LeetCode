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

public class Arr03_RotateArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
		
		System.out.println("Ori: " + Arrays.toString(arr));
		
		int k = 1;
		rotate(arr, k);
		
		System.out.println("After rotated: " + Arrays.toString(arr));
		
	}
	
    public static void rotate(int[] nums, int k) {
    	
    	if (k >= nums.length)
    		k = k % nums.length;
    	
    	if (k != 0) {
    		
    		int startLeft = 0;
    		int endLeft = k - 1;
    		
    		int startRight = k;
    		int endRight = nums.length - 1;
    		
    		int numsLeft = endLeft - startLeft + 1;
    		int numsRight = endRight - startRight + 1;
    		
    		// the while loop will stop when the left area is 0 -> no need to swap anymore
    		while (numsLeft != 0) {
    			
    			// when the right area is larger than the left area
    			if (numsRight > numsLeft) {
    				
    				// swap the right area with the left area
    				swapArrayElementFromStartToEnd(nums, startLeft, endLeft, startRight);
    				
    				// update the start right index
    				startRight = startRight + numsLeft;
    				
    				// the right area is now on the left hand side of k
    				if (endRight > k)
    					endRight = nums.length - 1;

    				// the right area is now on the left hand side of k
    				if (startRight < k)
    				{
    					startLeft = startLeft + numsLeft;
    					endLeft = endLeft + numsLeft;
    				}
    			
    			}
    			
    			else {
    				swapArrayElementFromStartToEnd(nums, startRight, endRight, startLeft);
    				
    				// the swapping area is now on the left hand side of k
    				if (startRight < k)
    					startLeft = startLeft + numsRight; 
    				else
    					endLeft = startLeft + numsRight - 1;
    				
    				// update startRight and leftRIight 
    				startRight = endLeft + 1;
    				endRight = k - 1;
    			}
    			
    			// update the numsLeft and numsRight 
        		numsLeft = endLeft - startLeft + 1;
        		numsRight = endRight - startRight + 1;
    			
    		}
    	}
    	
    }
    
    public static void swapArrayElementFromStartToEnd(int[] arr, int start, int end, int swapIndex) {
    	
    	while (start <= end) {
    		arr[start] = arr[start] + arr[swapIndex]; 
        	arr[swapIndex] = arr[start] - arr[swapIndex]; 
        	arr[start] = arr[start] - arr[swapIndex]; 
        	start++;
        	swapIndex++;
    	}
    	
    	// swap in-place concept
//    	arr[a] = arr[a] + arr[b]; // a = 2 + 1 = 3
//    	arr[b] = arr[a] - arr[b]; // b = 3 - 1 = 2
//    	arr[a] = arr[a] - arr[b]; // a = 3 - 2 = 1
    }

}
