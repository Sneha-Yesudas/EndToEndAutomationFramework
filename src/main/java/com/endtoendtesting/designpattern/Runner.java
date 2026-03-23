package com.endtoendtesting.designpattern;

import java.lang.module.Configuration;

public class Runner {

	public static void main(String[] args) {

		
		Configurations c1=Configurations.getInstance("Sneha");
		c1.writeName();
		
		Configurations c2=Configurations.getInstance("Yesudas");
		c2.writeName();
		
		if(c1==c2) {
			System.out.println("Both referencing same address");
		}
		System.out.println("This is traditional way");
		Student s1=new Student("Sneha","99");
		Student s2=new Student("Charles", "99.5");
		
		s1.print();
		s2.print();
		if(s1==s2) {
			System.out.println("Both referencing same address");
		}
		else
		{
			System.out.println("not referencing same address");
		}

	}

}
