package sortColors75;

import java.util.Arrays;

/*
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively
 * Note: You are not suppose to use the library's sort function for this problem.
 * 
 * Example:
 * 		Input: [2,0,2,1,1,0]
 * 		Output: [0,0,1,1,2,2]
 * 
 * Follow up:
 * 		A rather straight forward solution is a two-pass algorithm using counting sort.
 * 		First, iterate the array counting number of 0's, 1's, and 2's, 
 * 		then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Challenge
 * 		Come up with a one-pass algorithm using only constant space!
 */

public class SortColors {
	public static void main(String[] args) {

		int[] arr = new int[(int)(Math.random() * 20)];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 3);
		}

		sortColors(arr);

		System.out.println(Arrays.toString(arr));
	}

	public static void sortColors(int[] nums) {
		// The idea is divide the array into 3 areas based on 2 index
		
		// Represent the index that the last 1s appear 
		int indexOfOnes = -1;
		
		// Represent the index that the last 0s appear 
		int indexOfZeros = -1;

		for (int i = 0; i < nums.length; i++) {
			// when the current index value is 0
			if (nums[i] == 0) {
				
				// the case that there is no 1s so far
				// For example: 0, 0, 2,.... or 0,2,2,2,....
				if (indexOfOnes < 0)
				{
					// swap the index of the element next to the last 0s 
										// with the current index
					swapInPlace(nums, i, indexOfZeros + 1);
					
					// update the index of the last 0s
					indexOfZeros += 1;
				}
				
				// the case that there is at least 1s appear so far
				else {
					// the case the the last 1s is next to the current index
					// For example: 1 0
					if(indexOfOnes + 1 == i)
					{
						// swap the last 1s with the current index
						swapInPlace(nums, indexOfOnes, i);
						
						// swap the last 1s with the last 0s
						swapInPlace(nums, indexOfOnes, indexOfZeros + 1);
						
						// update the index of the last 0s
						indexOfZeros += 1;
						
						// update the index of the last 1s
						indexOfOnes += 1;
					}
					
					// the case the the last 1s is not next to the current index
					// For example: 1 2 0
					else
					{
						// swap the index of the element next to the last 1s 
						// with the current index -> swap 2 with 0
						swapInPlace(nums, indexOfOnes + 1, i);
						
						// update the index of the last 1s which is 0 now
						indexOfOnes += 1;
						
						// swap the index of the element next to the last 0s 
						// with the index of the last 1s which is 0 above  
						swapInPlace(nums, indexOfOnes, indexOfZeros + 1);
						
						// update the index of the last 0s
						indexOfZeros += 1;
					}

				}
			}

			// when the current index value is 1
			else if (nums[i] == 1) {
				// if there is no 1s so far
				// for example: 2,2,2,1 or 0,0,0,1
				if(indexOfOnes < 0) {
					
					// swap the index of the element next to the last 0s 
					// with the current index  
					swapInPlace(nums, indexOfZeros + 1, i);
					
					// update the index of the last 1s = the index next to last 0s
					indexOfOnes = indexOfZeros + 1;
				}
				// if there is at least 1s appear before
				// for example: 1,2,2,2, 1
				else {
					// swap the index of the element next to the last 1s 
					// with the current index  
					swapInPlace(nums, indexOfOnes + 1, i);
					
					// update the index of the last 1s
					indexOfOnes += 1;
				}
			}
		} 
	}

	public static void swapInPlace(int[] arr, int index1, int index2) {
		if(arr[index1] != arr[index2]){
			arr[index1] = arr[index1] + arr[index2]; // a = A + B
			arr[index2] = arr[index1] - arr[index2]; // b = A + B - B = A
			arr[index1] = arr[index1] - arr[index2]; // a = A + B - A = B 
		}
	}
}
