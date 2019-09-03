package mergeSort;

import java.util.Arrays;

public class MergerSort {

	public static void main(String[] args) {
		int[] test= {5,4,1,9,2,3,8};
		mergeSort(test,0,6);
		//		merge(test,0,3,6);
		System.out.println(Arrays.toString(test));
	}

	public static void mergeSort(int[] arr, int head, int tail){
		int middle = ((head+tail)/ 2);
		if(tail > head) {
			mergeSort(arr, head, middle);
			mergeSort(arr, middle+1 , tail);
			merge(arr, head, middle, tail);
		}
	}

	public static void merge (int[] arr, int head, int middle, int tail ) {
		int[] left = new int[middle-head+2];
		int[] right = new int[tail-middle+1];
		int leftPointer=0;
		int rightPointer=0;
		
		for (int i = 0; i < left.length-1; i++) {
			left[i] = arr[i + head];
		}
		
		left[left.length - 1]=Integer.MAX_VALUE;
		
		for (int i = 0; i < right.length-1; i++) {
			right[i] = arr[i+middle+1];
		}
		
		right[right.length - 1] = Integer.MAX_VALUE;

		for (int i = head; i <= tail; i++) {
			if(left[leftPointer] < right[rightPointer]) {
				arr[i] = left[leftPointer++];		
			}
			else {
				arr[i] = right[rightPointer++];
			}		
		}
		
	}
}
