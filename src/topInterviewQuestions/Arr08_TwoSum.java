package topInterviewQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*	Given an array of integers, return indices of the two numbers 
		such that they add up to a specific target.

 *	You may assume that each input would have exactly one solution, 
 		and you may not use the same element twice.

 *	Example:
		Input: [2, 7, 11, 15], target = 9.
		Output: return [0, 1]
		Explanation: Because nums[0] + nums[1] = 2 + 7 = 9, 
*/

public class Arr08_TwoSum {

	public static void main(String[] args) {
		int[] nums = {2,11, 15, 7};
		int target = 9;
		
		System.out.println(Arrays.toString(twoSum(nums, target)));
 		
	}
	
    public static int[] twoSum(int[] nums, int target) {
    	Map<Integer, Integer> mapInt = new HashMap<>();
    	
    	for (int i = 0; i < nums.length; i++) {
    		int addend = target - nums[i];
    		
    		if (mapInt.containsKey(addend))
    			return new int[] {mapInt.get(addend), i};
    		else
    			mapInt.put(nums[i],i);
    	}
    	
    	return new int[] {};
    }

}
