package reverseString541;
public class ReverseString541 {
	public static void main(String[] args) {
		String s = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
		
		int k = 39;
		
		System.out.println(reversedStringFinal(s, k));
		
	}
	
	public static String reversedStringFinal(String s, int k)
	{
		if (s.length() < k) {
			return reverseString(s, 0, s.length() - 1);
		}
		
		if (s.length() < 2 * k)
		{
			return reverseString(s, 0, k - 1).concat(s.substring(k, s.length()));
		}
		
		String reversedString = "";
		for (int i = 0; i < s.length(); i += 2 * k) {
			if (s.length() - i < k)
				reversedString += reverseString(s, i, s.length() - 1);
			else if (s.length() - i < 2 * k)
				reversedString += reverseString(s, i, k + i - 1).concat(s.substring(k + i, s.length()));
			else
				reversedString += reverseString(s, i, k + i - 1).concat(s.substring(k + i, 2 * k + i));
		}
		
		return reversedString;
	}
	
	public static String reverseString(String s, int head, int tail) {
		
		String reversedString = "";
		for(int i = tail; i >= head; i--) {
			reversedString += s.charAt(i);
		}
		return reversedString;	
	}
	
}
