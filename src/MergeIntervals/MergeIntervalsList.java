package MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervalsList {
	public static void main(String[] args) {
		
		List<Interval> intervals1 = new ArrayList<>();
		intervals1.add(new Interval(6, 8)); intervals1.add(new Interval(1, 9)); intervals1.add(new Interval(2, 4)); intervals1.add(new Interval(4, 7));
		
		List<Interval> intervals2 = new ArrayList<>();
		intervals2.add(new Interval(1, 3)); intervals2.add(new Interval(2, 6)); intervals2.add(new Interval(8, 10)); intervals2.add(new Interval(15, 18));
		
		List<Interval> intervals3 = new ArrayList<>();
		intervals3.add(new Interval(1, 3)); intervals3.add(new Interval(2, 4)); intervals3.add(new Interval(6, 8)); intervals3.add(new Interval(9, 10));
		
		List<Interval> intervals4 = new ArrayList<>();
		intervals4.add(new Interval(1, 4)); intervals4.add(new Interval(4, 5));;
		
		System.out.println("Input 1: " + print(intervals1));
		System.out.println("Output 1: " + print(merge(intervals1)));
		
		System.out.println("\nInput 2: " + print(intervals2));
		System.out.println("Output 2: " + print(merge(intervals2)));
		
		System.out.println("\nInput 3: " + print(intervals3));
		System.out.println("Output 3: " + print(merge(intervals3)));
		
		System.out.println("\nInput 4: " + print(intervals4));
		System.out.println("Output 4: " + print(merge(intervals4)));
	}
	
	public static List<Interval> merge(List<Interval> intervals) {
		ArrayList<Integer> startList = new ArrayList<>();
		ArrayList<Integer> endList = new ArrayList<>();
		
		for (int i = 0;  i < intervals.size(); i++) {
			startList.add(intervals.get(i).getStart());
			endList.add(intervals.get(i).getEnd());
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

		
		
		return mergeList;
    }
	
	public static String printArrayList(ArrayList<Integer> list) {
		String result = "[";
		
		for (int i = 0; i < list.size(); i++) {
			result += list.get(i);
			if (i < list.size() - 1)
				result += ", ";
		}
		
		return result += "]";
	}

	public static String print(List<Interval> intervals) {
		String result = "[";
		
		for (int i = 0; i < intervals.size(); i++) {
			result += "[" + intervals.get(i).getStart() + ", " + intervals.get(i).getEnd() + "]";
			if (i < intervals.size() - 1)
				result += ", ";
		}
		
		return result + "]";
	}

}

class Interval {
	int start;
	int end;
	
	Interval() {
		start = 0; 
		end = 0; 
	}
	Interval(int s, int e) { 
		start = s; 
		end = e; 
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
}