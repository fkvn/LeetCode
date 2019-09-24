package topInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*	Given two arrays, write a function to compute their intersection.

	Example 1:
		Input: nums1 = [1,2,2,1], nums2 = [2,2]
		Output: [2,2]
		
	Example 2:
		Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
		Output: [4,9]	
		
	Note:
		Each element in the result should appear as many times as it shows in both arrays.
		The result can be in any order
*/

public class Arr05_IntersectionOfTwoArraysII {

	public static void main(String[] args) {
		
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		
		System.out.println(Arrays.toString(intersect(nums1, nums2)));

	}
	
    @SuppressWarnings("deprecation")
	public static int[] intersect(int[] nums1, int[] nums2) {
        int[] emptyArr = {};
        
    	if (nums1.length < 1 || nums2.length < 1)
    		return emptyArr;
    	
    	List<Integer> nums2_v1 = new ArrayList<>();
    	
    	for (int i = 0; i < nums2.length; i++) {
    		nums2_v1.add(nums2[i]);
    	}
    	
    	List<Integer> intersect = new ArrayList<>();
    	
    	for (int i = 0; i < nums1.length; i++) {
    		if (nums2_v1.contains(nums1[i]))
    		{
    			intersect.add(nums1[i]);
    			nums2_v1.remove(new Integer(nums1[i]));
    		}
    	}
    	
    	int[] intersectArr = new int[intersect.size()];
    	
    	for (int i = 0; i < intersectArr.length; i++) {
    		intersectArr[i] = intersect.get(i);
    	}

    	return intersectArr;
    }

    public static int[] intersect1(int[] nums1, int[] nums2) {
    	
        if(nums1.length < 1 || nums2.length < 1){
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        if(nums1[nums1.length-1] < nums2[0]){
            return new int[]{};
        }

        int[] res = new int[nums1.length];
        int index = 0;
        for(int i=0, j=0; i<nums1.length && j<nums2.length; ){
            if(nums1[i]==nums2[j]){
                res[index++] = nums1[i];
                i++; j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return Arrays.copyOf(res, index);
    }
}
