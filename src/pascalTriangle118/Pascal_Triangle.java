package pascalTriangle118;
import java.util.LinkedList;
import java.util.List;

/*Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/

public class Pascal_Triangle {
	public static void main(String[] args) {
		int n = 5;
		List<List<Integer>> result = generate(n);
		System.out.println(print(result));
	}
	
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
        	List<Integer> insideResult = new LinkedList<>();
        	for (int j = 0; j < i + 1; j++) {
        		if (j == 0 ||  j == i) 
        			insideResult.add(1);
        		else 
        		{
        			insideResult.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
        		}
        	}
        	result.add(insideResult);
        }
        
        return result;
    }
    
    public static String print(List<List<Integer>> result) {
    	String resultString = "";
    	for (int i = 0; i < result.size(); i++) {
    		resultString += "[";
    		for (int j = 0; j < result.get(i).size(); j++) {
    			if ( j!= result.get(i).size() - 1)
    				resultString += result.get(i).get(j) + ", ";
    			else 
    				resultString += result.get(i).get(j);
    		}
    		
    	
    		resultString += (i == result.size() - 1)? "]\n": "],\n";
    	}
    	
    	return resultString;
    }
}
