package topInterviewQuestions;

/*	Given a 32-bit signed integer, reverse digits of an integer.

	Example 1:
		Input: 123
		Output: 321

	Example 2:
		Input: -123
		Output: -321

	Example 3:
		Input: 120
		Output: 21

	Note:
		Assume we are dealing with an environment 
			which could only store integers within 
				the 32-bit signed integer range: [−231,  231 − 1]. 

		For the purpose of this problem, 
			assume that your function returns 0 when the reversed integer overflows.
 */

public class Str02_ReverseInteger {

	public static void main(String[] args) {
		int x = 1534236469;

		System.out.println(x);

		System.out.println(reverse(x));

	}

	// 1ms
	public static int reverse(int x) {
		long n = (int)x;
		long result = 0;
		boolean isNeg = false; 
		
		if (n < 0)
		{
			n = -n;
			isNeg = true;
		}

		while (n != 0)
		{
			
			result = result * 10 + n % 10;
			n /= 10;
			if (result > Integer.MAX_VALUE - 1)
				return 0;
		}
		
		if (isNeg)
			result *= -1;
		
		return (int)result;
	}
	
	// 2ms
    public static int reverse2(int x) {
        String strInteger =  "";
    	
    	if (x < 0)
    	{
    		x = -x;
    		strInteger += "-";
    	}
    	
    	while (x != 0)
    	{
    		strInteger += String.valueOf(x % 10);
    		x /= 10;
    	}
        
		try {
			return  Integer.parseInt(strInteger);
		} catch (Exception e)
		{
			return 0;
		}
    }

}
