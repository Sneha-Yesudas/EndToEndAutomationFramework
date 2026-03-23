package com.endtoendtesting.interviewquestions.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseThirdworkdfromaSentence {

	public static void main(String[] args) {
		String inputString="I am earning in anbundance";
		String[] inputStringSplit=inputString.split(" ");
		List<String> inputStringArrayList=new ArrayList(Arrays.asList(inputStringSplit));
		String s=inputStringArrayList.get(2);
		
		StringBuilder stringBuilder=new StringBuilder(s);
		stringBuilder.reverse();
		System.out.println(stringBuilder);
		
		inputStringArrayList.remove(2);
		
		inputStringArrayList.add(2, stringBuilder.toString());
		
		
		for(String finalString:inputStringArrayList) {
			System.out.print(finalString+" ");
		}
		
	}

}
