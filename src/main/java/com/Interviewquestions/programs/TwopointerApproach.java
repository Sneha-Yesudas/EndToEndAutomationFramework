package com.Interviewquestions.programs;

public class TwopointerApproach {

	public static void main(String[] args) {
		
		
		String inputString="Sneha Yesudas";
		
		char inputChar[]=inputString.toCharArray();
		char temp;
		
		int left=0;
		int right=inputChar.length-1;
		
		while(left<right) {
			temp=inputChar[left];
			inputChar[left]=inputChar[right];
			inputChar[right]=temp;
			left++;
			right--;
			
			
			
		}
		
		System.out.println(inputChar);
		
		
		
		

	}

}
