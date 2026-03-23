package com.Interviewquestions.programs.revision;

public class ReverseBasic {
	
	
	    public static void main(String[] args) {
	        String str = "Hello Deloitte";
	        
	        // Approach 1: Using char array (Most preferred without built-ins)
	        char[] chars = str.toCharArray();
	        String reversed = "";
	        for (int i = chars.length - 1; i >= 0; i--) {
	            reversed += chars[i];
	        }
	        System.out.println("Reversed: " + reversed);
	    }
	


}
