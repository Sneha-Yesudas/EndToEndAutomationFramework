package com.Interviewquestions.programs;

public class Reversestring {

	public static void main(String[] args) {
		
		String name="Sneha";
		
		String temp ="";
		
		char nameChar[]=name.toCharArray();
		
		for(int i=0;i<nameChar.length;i++) {
			
			System.out.println(nameChar[i]);
			
			 temp=nameChar[i]+temp;
		}
		
		System.out.println(temp);
				
				

	}

}
