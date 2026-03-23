package com.endtoendtesting.designpattern;

public class Student {
	
	String name;
	String marks;
	public Student(String name, String marks) {
		super();
		this.name = name;
		this.marks = marks;
	}
	
	
	public void print() {
		System.out.println("name=" +name);
		System.out.println("marks=" +marks);
	}
	

}
