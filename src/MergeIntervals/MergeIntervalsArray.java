package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeIntervalsArray {
	public static void main(String[] args) {
		int[][] intervals1 = {{6, 8}, {1, 9}, {2, 4}, {4, 7}};
		int[][] intervals2 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
		int[][] intervals3 = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};
		int[][] intervals4 = {{1, 4}, {4, 5}};
		
		System.out.println("Input 1: " + print((intervals1)));
		System.out.println("Output 1: " + print(merge(intervals1)));
		
		System.out.println("\nInput 2: " + print(intervals2));
		System.out.println("Output 2: " + print(merge(intervals2)));
		
		System.out.println("\nInput 3: " + print(intervals3));
		System.out.println("Output 3: " + print(merge(intervals3)));
		
		System.out.println("\nInput 4: " + print(intervals4));
		System.out.println("Output 4: " + print(merge(intervals4)));
	
	}
    public static int[][] merge(int[][] intervals) {
		ArrayList<Integer> startList = new ArrayList<>();
		ArrayList<Integer> endList = new ArrayList<>();
		
		for (int i = 0;  i < intervals.length; i++) {
			startList.add(intervals[i][0]);
			endList.add(intervals[i][1]);
		}
		
		Collections.sort(startList);
		Collections.sort(endList);
		
		List<Interval> mergeList = new ArrayList<>();
		
		if (startList.size() > 0 && endList.size() > 0)
		{
			for (int i = 0;  i < startList.size(); i++) {
				if (mergeList.size() < 1 || startList.get(i) > endList.get(i - 1) )
					mergeList.add(new Interval(startList.get(i), endList.get(i)));
				else {
					if(startList.get(i) <= endList.get(i - 1))
						mergeList.get(mergeList.size() - 1).setEnd(endList.get(i));
				}
			}
		}

		int[][] result = new int[mergeList.size()][2];
		
		for(int i = 0; i < mergeList.size(); i++) {
			result[i][0] = mergeList.get(i).getStart();
			result[i][1] = mergeList.get(i).getEnd();
		}
		
        return result;
    }
    
    public static String print(int[][] arrays) {
    	String result = "[";
    	
    	for (int i = 0; i < arrays.length; i++) {
    		result += Arrays.toString(arrays[i]);
    		if (i < arrays.length - 1)
    			result += ", ";
    	}
    	
    	return result + "]";
    }
}
