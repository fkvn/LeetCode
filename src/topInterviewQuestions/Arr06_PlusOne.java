package topInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 	Given a non-empty array of digits representing a non-negative integer, 
  		plus one to the integer.

	The digits are stored such that the most significant digit is at the head of the list, 
		and each element in the array contain a single digit.

	You may assume the integer does not contain any leading zero, 
		except the number 0 itself.

	*	Example 1:
			Input: [1,2,3]
			Output: [1,2,4]
			Explanation: The array represents the integer 123.
			
	*	Example 2:
			Input: [4,3,2,1]
			Output: [4,3,2,2]
			Explanation: The array represents the integer 4321.

*/

public class Arr06_PlusOne {
	public static void main(String[] args) {
		int[] digits = {9,9,7,6,5,4,3,2,1,9};
		
		System.out.println(Arrays.toString(plusOne(digits)));
	}
	
    public static int[] plusOne(int[] digits) {
    	
    	List<Integer> listDigits = new ArrayList<>();
    	
    	int extraNum = 1;
    	
    	for (int i = digits.length - 1;  i >= 0; i--) {
    		
    		if ((digits[i] + extraNum) >= 10)
    		{
    			extraNum = (digits[i] + extraNum) / 10;
    			listDigits.add((digits[i] + extraNum) % 10);
    		}
    		else 
    		{
    			listDigits.add((digits[i] + extraNum));
    			extraNum = 0;
    		}
    	}
    	
    	if (extraNum != 0)
    		listDigits.add(extraNum);
    	
    	
    	int[] result = new int[listDigits.size()];
    	
    	for (int i = listDigits.size() - 1; i >= 0; i--)
    		result[result.length - i - 1] = listDigits.get(i);
    	
    	return result;
    }
}
