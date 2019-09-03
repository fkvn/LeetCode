package removeOutermostParentheses1021;


public class Remove_Outermost_Parentheses {

	public static void main(String[] args) {
		removeOuterParentheses("(()())(())(()(()))");

	}
	
	public static String removeOuterParentheses(String S) {
		
		StringBuilder result = new StringBuilder();
		
		int complete = 1;
		
		for (int i = 1; i < S.length(); i++) {
			if (S.charAt(i) == ')')
				complete -= 1;			
			else
				complete += 1;
			
			if (complete != 0)
				result.append(S.charAt(i));	
			else
            {
                i += 1;
                complete = 1;
            }	
		}
    
        return result.toString();
	}

}
