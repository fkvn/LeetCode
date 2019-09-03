package climbingStairs70;

/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * 
 * Example:
 * 		Input: 2
 * 		Output: 2
 * Explanation: There are two ways to climb to the top.
 * 				1. 1 step + 1 step
 * 				2. 2 steps
 * 
 * Example:
 * 		Input: 3
 * 		Output: 3
 * Explanation: There are three ways to climb to the top.
 * 				1. 1 step + 1 step + 1 step
 * 				2. 1 step + 2 steps
 * 				3. 2 steps + 1 step
 * 
 */

import java.util.Stack;

public class ClimbingStairs {
	public static void main(String[] args) {
		int n = 4;
		
		System.out.println(climbStairs(n));
		System.out.println(climbStairsWithStack(n));
	}
	
    public static int climbStairs(int n) {
    	if(n <= 2){
    		return n;
    	} 
    	
    	int fibo = 2;
    	int fiboPrev = 1;
    	
    	for(int i = 3; i <= n; ++i){
    		int temp = fibo;
    		fibo += fiboPrev;
    		fiboPrev = temp;
    	}
    	
    	return fibo;
    }
    
    
    public static int climbStairsWithStack(int n) {
    	Stack<Integer> stack = new Stack<Integer>();
    	if(n <= 2)
    		return n;
    	else {
    		stack.push(1);
    		stack.push(2);
    		
    		for (int i = 2; i < n ; i++) {
    			stack.push(stack.get(i -2) + stack.get(i-1));
    		}
    		
    		return stack.pop();
    	}
    	
    }
	
}
