package com.Interviewquestions.programs;

public class PalindromeString {
	
	public static boolean palindromString(String str) {
		char stringchar[]=str.toCharArray();
		int left=0;
		int right=str.toCharArray().length-1;
		
		while(left<right) {
			if(stringchar[left]!=stringchar[right]) {
				return false;
			}
			left++;
			right--;
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		if(palindromString("malayalam")) {
			System.out.println("it is palindrome");
		}
		else {
			System.out.println("It is not palindrome");
		}
	}

}
