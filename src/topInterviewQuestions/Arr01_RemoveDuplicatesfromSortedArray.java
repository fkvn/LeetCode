package topInterviewQuestions;

/*	Given a sorted array nums, 
 		remove the duplicates in-place such that each element appear only once 
 		and return the new length.

	Do not allocate extra space for another array, 
		you must do this by modifying the input array in-place with O(1) extra memory.
		
	* 	Example 1:

			Given nums = [1,1,2],

			Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

			It doesn't matter what you leave beyond the returned length.
			
	*	Example 2:

			Given nums = [0,0,1,1,1,2,2,3,3,4],
	
			Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

			It doesn't matter what values are set beyond the returned length.
*/


import java.util.Arrays;

public class Arr01_RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		int[] arr = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10);
		}
		
		Arrays.sort(arr);
		
		System.out.println("Original: " + Arrays.toString(arr));
		
		System.out.println("\n# Distinct Element: " + removeDuplicates(arr));
		
		System.out.println("\nAfter duplicated: " + Arrays.toString(arr));

	}
	
    public static int removeDuplicates(int[] nums) {
        int count = 0;
        
        
        if (nums.length < 1)
            return count;
    
        int flagNum = nums[0];
        count += 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != flagNum)
            {
                flagNum = nums[i];
                count += 1;
                nums[count - 1] = flagNum;
            }
        }
        
        return count;
    }

}
