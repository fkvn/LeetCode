package topInterviewQuestions;

import java.util.Hashtable;

/*	Given a non-empty array of integers, every element appears twice except for one. Find that single one.

	Note:
		Your algorithm should have a linear runtime complexity. 
		Could you implement it without using extra memory?
	
	* Example 1:
		Input: [2,2,1]
		Output: 1
		
	* Example 2:
		Input: [4,1,2,1,2]
		Output: 4
*/


public class Arr04_SingleNumber {

	public static void main(String[] args) {
		int[] arr = {4,1,2,1,2};
		System.out.println(singleNumberBitManipulation(arr));

	}
	
	 public static int singleNumber(int[] nums) {
		 Hashtable<Integer, Integer> hNums = new Hashtable<>();
		 
		 if (nums.length > 1) {
			 for (int i = 0; i < nums.length; i++) {
				 if (hNums.containsKey(nums[i]))
					 hNums.remove(nums[i]);
				 else {
					 hNums.put(nums[i], 1);
				 }
			 }
			 
			 return hNums.keys().nextElement();
		 }
		 
		 
		 return nums[0];
	 }
	 
	 
	 public static int singleNumberBitManipulation(int[] nums) {
        int a = nums[0];
        
        for (int i = 1; i < nums.length; i++)
            a ^= nums[i];
        
        return a;
	 }

}
