package maximumSubArray;

import java.util.Arrays;

public class MaximumSubArray {

	public MaximumSubArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
//		int[] arr = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
		int[] arr = {7,6,4,3,1};
		int[] arrDiff = new int[arr.length - 1];
		
		for (int i = 0; i < arrDiff.length; i++) {
			arrDiff[i] = arr[i + 1] - arr[i];
		}
		
		int[] result = maximumSubArray(arrDiff, 0, arrDiff.length - 1);
		
		System.out.println("arrDiff: " + Arrays.toString(arrDiff));
		System.out.println("leftMax: " + result[0] + " -> " + arrDiff[result[0]]);
		System.out.println("rightMax: " + result[1] + " -> " + arrDiff[result[1]]);
		System.out.println("Revenue: " + result[2]);
	}
	
	public static int[] maximumSubArray(int[] arr, int start, int end) {
		int[] result = new int[3];
		if (start == end)
		{
			result[0] = start;
			result[1] = end;
			result[2] = arr[start];
		}
		else {
			int mid = (start + end) / 2;
			int[] leftResult = maximumSubArray(arr, start, mid);
			int[] rightResult = maximumSubArray(arr, mid + 1, end);
			int[] crossResult = maximumCrossSubArray(arr, start, mid, end);
			if (leftResult[2] >= rightResult[2] && leftResult[2] >= crossResult[2])
				return leftResult;
			else if (rightResult[2] >= leftResult[2] && rightResult[2] >= crossResult[2])
				return rightResult;
			else
				return crossResult;
		}
		return result;
	}
	
	public static int[] maximumCrossSubArray(int[] arr, int start, int mid, int end) {
		int[] result = new int[3];
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;
		int maxLeft = 0;
		int maxRight = 0;
		
		for (int i = mid; i >= start; i--) {
			sum +=  arr[i];
			if (sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
		}
		
		int rightSum = Integer.MIN_VALUE;
		sum = 0;
		
		for (int i = mid + 1; i <= end; i++) {
			sum +=  arr[i];
			if (sum > rightSum) {
				rightSum = sum;
				maxRight = i;
			}
		}
		
		result[0] = maxLeft;
		result[1] = maxRight;
		result[2] = leftSum + rightSum;
		
		return result;
	}

}
