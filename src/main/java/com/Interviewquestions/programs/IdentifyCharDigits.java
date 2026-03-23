package com.Interviewquestions.programs;

public class IdentifyCharDigits {

	public static boolean verifyIsDigit(String str) {
		
		
		for(char c: str.toCharArray()) {
			if(!Character.isAlphabetic(c)){
				return false;
			}
		}

		return true;

	}

	public static void main(String[] args) {
		
		if(verifyIsDigit("jsdjsfa")) {
			System.out.println("This is fully alphabetic");
		}
		
		else {
			System.out.println("This is not alphabetic");
		}

	}
}
