package rotateArray189;

import java.util.Arrays;

/*
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * 
 * Example 1:
 * 		Input: [1,2,3,4,5,6,7] and k = 3
 * 		Output: [5,6,7,1,2,3,4]
 * 
 * Example 2:
 * 		Input: [-1,-100,3,99] and k = 2
 * 		Output: [3,99,-1,-100]
 * 
 * Challenge
 * 		Could you do it in-place with O(1) extra space or O(n) complexity, or both?
 */


public class RotateArray {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int k = 3;
		// 2, 3, 4, 1
		
		
		System.out.println("Original: " + Arrays.toString(arr));
		
		rotate(arr, k);
		
		System.out.println("After rotating: " + Arrays.toString(arr));

	}
	
	
    public static void rotate(int[] nums, int k) {
    	if (nums.length > 1)
    	{
    		int anchorIndex = k;
	        
	        for (int i = nums.length - 1; i >= 0; i--) {
	        	swapArrayElement(nums, i, anchorIndex);
	        	if (anchorIndex % k + k != i) {
	        		swapArrayElement(nums, i, anchorIndex  % k + k - 1);
	        	}
	        	anchorIndex -= 1;
	        	k -= 1;
	        }
	      
    	}
    }
    
    public static void swapArrayElement(int[] arr, int a, int b) {
    	// a = 2, b = 1; 
    	arr[a] = arr[a] + arr[b]; // a = 2 + 1 = 3
    	arr[b] = arr[a] - arr[b]; // b = 3 - 1 = 2
    	arr[a] = arr[a] - arr[b]; // a = 3 - 2 = 1
    }

}
