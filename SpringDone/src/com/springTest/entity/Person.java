package com.springTest.entity;

import java.sql.Date;

public class Person {

	public int id;
	public String name;
	public String sex;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBith() {
		return bith;
	}
	public void setBith(Date bith) {
		this.bith = bith;
	}
	public Date bith;
}
