package com.Interviewquestions.programs.revision;

import java.util.Arrays;

public class Anagram {

	public static void Anagram(String input1,String input2) {

		String s1 = input1;
		String s2 = input2;

		char[] original = s1.toLowerCase().toCharArray();
		char[] original2 = s2.toLowerCase().toCharArray();
		Arrays.sort(original);
		Arrays.sort(original2);
		
		boolean isAnagram=Arrays.equals(original, original2);
		if(isAnagram) {
			System.out.println("String is anagram");
		}
		else {
			System.out.println("String are not Anagram");
		}

	}

	public static void main(String[] args) {
		Anagram("Listens","Silent");
	}

}
