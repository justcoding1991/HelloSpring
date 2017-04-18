package com.newspring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.newspring.entity.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DatasourceConfig.class)
public class SpringJdbcTest {

	@Autowired
	JdbcSpitterRepository jdbcSpitter;
	
	@Test
	public void testSpringJdbc(){
		Person person = new Person();
		person.setName("张三丰");
		person.setAge(137);
		person.setSex("男");
		jdbcSpitter.addPerson(person);
		
		Person personInfo = jdbcSpitter.selectPersonInfo(30);
		System.out.println("++++++++用户信息Person");
		
		System.out.println(personInfo.getId() + "  " + personInfo.getName()
		 + "   " + personInfo.getAge() + "  " + personInfo.getSex());
	}
}
