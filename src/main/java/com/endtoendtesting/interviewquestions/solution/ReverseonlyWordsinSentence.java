package com.endtoendtesting.interviewquestions.solution;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReverseonlyWordsinSentence {

	public static void main(String[] args) {
		
		String inputString="I Love Java";
	
		String inputStringSplit[]=inputString.split(" ");
		
		System.out.println(Arrays.toString(inputStringSplit));
		
		for(String s:inputStringSplit) {
			
		char[] stringCovertedtocharacter=	s.toCharArray();
		
		   for(int i=0;i<stringCovertedtocharacter.length-1;i++) {
			   int left=0;
			   int right=stringCovertedtocharacter.length-1;
			   char temp;
			   
			   while(left<right) {
				  temp= stringCovertedtocharacter[left];
				  stringCovertedtocharacter[left]=stringCovertedtocharacter[right];
				  stringCovertedtocharacter[right]=temp;
				  left++;
				  right--;
			   }
			   
			   //System.out.println(Arrays.toString(stringCovertedtocharacter));
		   }
		   System.out.print(new String(stringCovertedtocharacter)+" ");
		 
		
		// System.out.println(s);
		}
		

	}

}
