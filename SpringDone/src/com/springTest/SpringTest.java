package com.springTest;


import com.springTest.Dao.impl.PersonDaoImpl;
//import java.io.*;

public class SpringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PersonDaoImpl personDaoImpl = new PersonDaoImpl();
//	     List<Person> list=personDaoImpl.queryAllPersonInfo();
//	      for(Person person:list){  
//	    	  System.out.println(person.getName());
//}
      int result = personDaoImpl.deletePersonInfoById(1);
      System.out.print(result);
		
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/bean.xml");
//		System.out.println(ctx);
//		PersonService p = ctx.getBean("personService", PersonService.class);
////		p.info();
//		p.query();


	}

}
