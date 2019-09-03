package bestTimetoBuyandSellStock121;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
	If you were only permitted to complete at most one transaction 
	(i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
	
	Note that you cannot sell a stock before you buy one.
 * 
 * Example:
 * 		Input: [7,1,5,3,6,4]
 * 		Output: 5
 * 		Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
 * 
 * Example2: 
 * 		Input: [7,6,4,3,1]
 * 		Output: 0
 * 		Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */


import java.util.Arrays;

public class CompleteAtMostOneTransaction121 {

	public CompleteAtMostOneTransaction121() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] arr = {7,6,4,3,1};
		
		int result = maxProfit(arr);
		
		System.out.println("arr: " + Arrays.toString(arr));
		System.out.println("Most Profit: " + result);

	}
	
    public static int maxProfit(int[] prices) {
        if (prices.length > 1)
        {
            int[] diffPrices = new int[prices.length - 1];
            int maxProfit = 0;

            for (int i = 0; i < diffPrices.length; i++) {
                diffPrices[i] = prices[i + 1] - prices[i];
            }

            maxProfit = MaximumSubArray(diffPrices, 0, diffPrices.length - 1);
            
            if (maxProfit < 0)
                maxProfit = 0;
            
            return maxProfit;
        }
        
        return 0;
    }
    
    public static int MaximumSubArray(int[] prices, int start, int end) {
        if (start == end)
            return prices[start];
        else 
        {
            int mid = (start + end) / 2;
            int leftMax = MaximumSubArray(prices, start, mid);
            int rightMax = MaximumSubArray(prices, mid + 1, end);
            int crossMax = MaximumCrossSubArray(prices, start, mid, end);
            
            if (leftMax >= rightMax && leftMax >= crossMax)
                return leftMax;
            else if (rightMax >= leftMax && rightMax >= crossMax)
                return rightMax;
            else
                return crossMax;
        }
    }
    
    public static int MaximumCrossSubArray(int[] prices, int start, int mid, int end) {
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int maxProfit = 0;
    
        for (int i = mid; i >= start; i--) {
            maxProfit += prices[i];
            if (maxProfit >= leftMax) 
                leftMax = maxProfit;
        }
        
        maxProfit = 0;
        
        for (int i = mid + 1; i <= end; i++) {
            maxProfit += prices[i];
            if (maxProfit >= rightMax)
                rightMax = maxProfit;
        }
        
        maxProfit = leftMax + rightMax;
        
        return maxProfit;
    }

}
