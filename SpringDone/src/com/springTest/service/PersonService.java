package com.springTest.service;

public class PersonService {
	private String name;

	private String sex;
	public void setSex(String sex) {
		this.sex = "女";
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void info(){
		System.out.println("this person's name is " + name);
	}
	
	public void query(){
		System.out.println("this person's sex is " + sex);
	}
	
	
}
