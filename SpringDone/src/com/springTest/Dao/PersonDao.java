package com.springTest.Dao;

import java.util.List;

import com.springTest.entity.Person;


public interface PersonDao {
	public List<Person> queryAllPersonInfo();
	public int deletePersonInfoById(int id);
}
