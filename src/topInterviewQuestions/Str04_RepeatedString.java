package topInterviewQuestions;

import java.util.Scanner;

public class Str04_RepeatedString {

	public static void main(String[] args) {
		String s = "a";
		
		Scanner in = new Scanner(System.in);
		long n =  in.nextLong();
		
		System.out.println("hello : " + repeatedString(s, n));

	}
	
    public static long repeatedString(String s, long n) {
        int oriStrLen = s.length();
        int index = 0;
        long nums = 0;
//    	n = n % 100;
    	
        System.out.println(n);
    	
        while ( n > 0) {
        	System.out.println(n);
        	System.out.println("d");
            nums = s.charAt(index) == 'a' ? nums + 1 : nums;
            index = index + 1 >= oriStrLen ? 0 : index + 1 ; 
        	n--;
        	System.out.println(n);
        	
        }
        return nums;
    	
//    	  int i = 0;
//          long lCountA = 0, rCountA = 0;
//          long sTimes = n / s.length();
//          long remainChars = n % s.length();
//
//          if(remainChars > 0){
//              for(; i < remainChars; i++){
//                  if(s.charAt(i) == 'a') lCountA++;
//              }
//          }
//          if(sTimes > 0){
//              for(; i < s.length(); i++){
//                  if(s.charAt(i) == 'a') rCountA++;
//              }
//          }
//          return sTimes * (rCountA + lCountA) + lCountA;


    }

}
