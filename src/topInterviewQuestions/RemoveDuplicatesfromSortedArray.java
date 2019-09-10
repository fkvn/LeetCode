package topInterviewQuestions;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {

	public RemoveDuplicatesfromSortedArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] arr = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10);
		}
		
		Arrays.sort(arr);
		
		System.out.println("Original: " + Arrays.toString(arr));
		
		System.out.println("\n# Distinct Element: " + removeDuplicates(arr));
		
		System.out.println("\nAfter duplicated: " + Arrays.toString(arr));

	}
	
    public static int removeDuplicates(int[] nums) {
        int count = 0;
        
        
        if (nums.length < 1)
            return count;
    
        int flagNum = nums[0];
        count += 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != flagNum)
            {
                flagNum = nums[i];
                count += 1;
                nums[count - 1] = flagNum;
            }
        }
        
        return count;
    }

}
