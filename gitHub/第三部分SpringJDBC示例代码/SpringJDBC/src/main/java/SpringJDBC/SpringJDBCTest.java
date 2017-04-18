package SpringJDBC;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import SpringJDBC.dao.PersonDaoImpl;
import SpringJDBC.dao.PersonMapper;
import SpringJDBC.entity.Person;
import SpringJDBC.service.PersonService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:config/mybatis-Spring.xml"})
public class SpringJDBCTest {
	
	
	@Autowired
	private PersonMapper personMapper;
//	@Autowired
//	private PersonMapService personMapService;
	
	@Test
	public void testSpringJdbc() {
		// 测试采用SpringJDBC 操作数据库
		ApplicationContext act = new ClassPathXmlApplicationContext(
				"config/Spring-dbaccess.xml");
		PersonService personService = (PersonService) act
				.getBean("personService");
		Person person = new Person();
		person.setName("苏东坡");
		person.setAge(21);
		person.setSex("男");

		// 保存人员信息
		personService.save(person);
		List person1 = personService.getPersonAll();
		System.out.println("++++++++用户信息Person");
		System.out.println(person1);
//		for (Person person2 : person1) {
//			System.out.println(person2.getId() + "  " + person2.getName()
//					+ "   " + person2.getAge() + "  " + person2.getSex());
//		}

	}
	


	@Test
	public void testSqlSessionTemplate() {
		// 测试 采用接口org.apache.ibatis.session.SqlSession的实现类org.mybatis.spring.SqlSessionTemplate。
		//mybatis中, sessionFactory可由SqlSessionFactoryBuilder.来创建。MyBatis-Spring 中，使用了SqlSessionFactoryBean来替代。
		//SqlSessionFactoryBean有一个必须属性dataSource，另外其还有一个通用属性configLocation（用来指定mybatis的xml配置文件路径）。
		ApplicationContext act = new ClassPathXmlApplicationContext(
				"config/mybatis2.xml");
		PersonService personService = (PersonService) act.getBean("personService");
		Person person2 = personService.getuser(3);
		System.out.println("++++++++用户信息Person");
		System.out.println(person2.getId() + "  " + person2.getName()
		 + "   " + person2.getAge() + "  " + person2.getSex());
	}

	@Test
	public void testDaoSupport() {

		// 测试 采用抽象类org.mybatis.spring.support.SqlSessionDaoSupport提供SqlSession。
		ApplicationContext act = new ClassPathXmlApplicationContext(
				"config/mybatisDaoSupport.xml");
		PersonDaoImpl personDaoImpl = (PersonDaoImpl) act.getBean("personDao");
		Person person2 = personDaoImpl.getPersonSupport(2);
		System.out.println(person2.getId() + "  " + person2.getName() + "   "
				+ person2.getAge() + "  " + person2.getSex());
	}
	@Test
	public void testMapperScanner(){
		//采用MapperScannerConfigurer，它将会查找类路径下的映射器并自动将它们创建成MapperFactoryBean。
		ApplicationContext act = new ClassPathXmlApplicationContext("config/mybatis-Spring.xml");
//		PersonMapper personMapper = act.getBean();
		act.getAutowireCapableBeanFactory().autowireBean(this);
		Person person2 = personMapper.getPersonById(4);
		System.out.println("++++++++用户信息Person");
		System.out.println(person2.getId() + "  " + person2.getName()
		 + "   " + person2.getAge() + "  " + person2.getSex());
	}
}
