package com.endtoendtesting.interviewquestions.solution;

import java.util.Arrays;

public class ReverserWordOrderinSentence {

	public static void main(String[] args) {
		String inputString="I Love Java";
		
	String[] inputStringArray=	inputString.split(" ");
    System.out.println(Arrays.toString(inputStringArray));
	int length=inputStringArray.length;
	System.out.println(length);
	
	for(int j=0;j<length;j++) {
		System.out.print(inputStringArray[j]+" ");
	}
	System.out.println(" ");
	for(int i=length-1;i>=0;i--) {
		System.out.print(inputStringArray[i] +" ");
	}

	}

}
