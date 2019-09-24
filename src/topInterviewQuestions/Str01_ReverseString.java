package topInterviewQuestions;

import java.util.Arrays;
import topInterviewQuestions.CustomMethods;

/*	Write a function that reverses a string. 
 	The input string is given as an array of characters char[].

	Do not allocate extra space for another array, 
		you must do this by modifying the input array in-place with O(1) extra memory.

	You may assume all the characters consist of printable ascii characters.
	
 *	Example 1:
		Input: {'h','e','l','l','o'}
		Output: {'o','l','l','e','h'}
		
 *	Example 2:
 		Input: {'H','a','n','n','a','h'}
		Output: {'h','a','n','n','a','H'}
*/

public class Str01_ReverseString {

	private static CustomMethods ctMe = new CustomMethods();

	public static void main(String[] args) {
		char[] s = {'H','a','n','n','a','h'};
		
		System.out.println(Arrays.toString(s));
		
		reverseString(s);
		
		System.out.println(Arrays.toString(s));

	}
	
    public static void reverseString(char[] s) {
        
    	for (int i = 0; i < s.length / 2; i++) {
    		ctMe.swapCharElement(s, i, s.length - i - 1);
    	}
    }
    
    


}
