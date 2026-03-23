package com.Interviewquestions.programs;

public class PrintCharArray {

	public static void main(String[] args) {
		String name="Sneha";
		
		char[] namecharArray=name.toCharArray();
		
		
		for(char c:namecharArray) {
			System.out.print(c);
		}
		
		System.out.println(namecharArray);
		
		

	}

}
