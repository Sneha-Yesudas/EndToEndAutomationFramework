package com.endtoendtesting.designpattern;

public class Configurations {
	
	private static Configurations instance=null;
	
	private String name;
	
	
	
	private Configurations(String name) {
		this.name=name;
		System.out.println("Instance created");
	}
	
	public  void writeName() {
		System.out.println("Name="+name);
	}
	
	public static Configurations getInstance(String name) {
		if(instance==null) {
			instance=new Configurations(name);
		}
		return instance;
	}
	

}
