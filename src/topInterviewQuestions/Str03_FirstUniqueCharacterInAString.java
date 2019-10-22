package topInterviewQuestions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*	Given a string, find the first non-repeating character in it and return it's index. 
  	If it doesn't exist, return -1.

 *	Example 1:
		Input: "leetcode"
		Output: 0

 *	Example 2:
		Input: "loveleetcode"
		Output: 2
		
 *	Note: You may assume the string contain only lowercase letters.

*/

public class Str03_FirstUniqueCharacterInAString {

	public static void main(String[] args) {
		String s = "loveleetcode";
		
		System.out.println(firstUniqChar(s));

	}
	
    public static int firstUniqChar(String s) { 
        int index = -1;
        
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
        	if(map.containsKey(s.charAt(i))) 
        		map.replace(s.charAt(i), -1);
        	else
        		map.put(s.charAt(i), i);
        }
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
        	if (entry.getValue() >= 0)
        		return  entry.getValue();
        }
        
        return index;
    }
    
    public static void PrintGardenLayout() {
        Scanner in = new Scanner(System.in);
        String[] temp = in.nextLine().split(",");

        int rows = Integer.parseInt(temp[0]);
        int cols = Integer.parseInt(temp[1]);

        String[][] layout = new String[cols][rows];

        for (int i = 0; i < layout.length; i++)
            for (int j = 0; j < layout[i].length; j++) 
                layout[i][j] = "B";

        while (in.hasNext()) {
            temp = in.nextLine().split(",");
            int row = Integer.parseInt(temp[1]);
            int col = Integer.parseInt(temp[2]);
            layout[col][row] = temp[0];
        }
        
        for (int i = 0; i < layout.length; i++)
        {
            for (int j = 0; j < layout[i].length; j++) 
                System.out.print(layout[i][j]);
            System.out.println();
        }   

        in.close();
    }

}
