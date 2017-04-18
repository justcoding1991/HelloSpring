package com.newspring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.newspring.entity.Person;

@Repository
public class JdbcSpitterRepository {

	private JdbcOperations jdbcOperations;
	
	@Autowired
	public JdbcSpitterRepository(JdbcOperations jdbcOperations){
		this.jdbcOperations = jdbcOperations;
	}
	
	private String INSERTSQL="insert into person(name,age,sex)values(?,?,?)";
	private String QUERYPERSONSQL = "select * from person where id = ?";
	
	public void addPerson(Person person){
		jdbcOperations.update(INSERTSQL, 
				person.getName(),
				person.getAge(),
				person.getSex());
	}
	
	public Person selectPersonInfo(int id){
		Person person = (Person) jdbcOperations.queryForObject(QUERYPERSONSQL, new Object[] { id }, new personRowMapper());
		return person;
	}
	
	class personRowMapper implements RowMapper<Person>{

		public Person mapRow(ResultSet set, int arg1) throws SQLException {
			  Person person = new Person(set.getInt("id"), set.getString("name"), set
		                .getInt("age"), set.getString("sex"));
		        return person;
		}
		
	}
	
	
}
