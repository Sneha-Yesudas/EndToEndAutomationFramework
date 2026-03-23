package com.Interviewquestions.programs.revision;

import java.util.HashMap;
import java.util.Map;

public class CharacterCount {
	
	public static void characterCount() {
		String inputString="Sneha is working in Deloitte";
		char inputCharArray[]=inputString.trim().toCharArray();
		HashMap<Character, Integer> countChar=new HashMap<Character, Integer>();
		for(char c:inputCharArray) {
		
			if(countChar.containsKey(c)) {
				countChar.put(c, countChar.get(c)+1);
			}
			else {
				countChar.put(c, 1);
			}
		}
		
		for(Map.Entry<Character, Integer> entry:countChar.entrySet()) {
			if(entry.getValue()>1) {
				System.out.println(entry.getKey()+" "+entry.getValue());
			}
			else {
				System.out.println(entry.getKey()+" "+ entry.getValue());
			}
			
		}
		
		
	}

	public static void main(String[] args) {
		characterCount();

	}

}
