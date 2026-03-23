package com.Interviewquestions.programs.revision;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReverseString {
	
	public static void reverseStringStringBuilder() {
		StringBuilder builder=new StringBuilder("Sneha is working deloitte");
		builder.reverse();
		System.out.println(builder);
	}
	
	public static void tempVariable() {
		String inputString ="Sneha is working deloitte";
		String reverse="";
		
		char[] manipulateString=inputString.toCharArray();
		
		for(int i=0;i<manipulateString.length;i++) {
			
			reverse=manipulateString[i]+reverse;
		}
		System.out.println(reverse);
		
	}
	
	public static void twoPointerApprach() {
		String inputString="Sneha is working in deloitte";
		char[] charString=inputString.toCharArray();
		
		int left=0;
		int right=charString.length-1;
		char temp;
		
		while(left<right) {
			temp=charString[left];
			charString[left]=charString[right];
			charString[right]=temp;
			
			left++;
			right--;
			
		}
		String reversed=String.valueOf(charString);
		System.out.println(reversed);
		
			
		
	}

	public static void main(String[] args) {
		
		reverseStringStringBuilder();
		System.out.println("---------------------------------------");
		tempVariable();
		System.out.println("---------------------------------------");
		twoPointerApprach();

	}

}
