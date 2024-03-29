package com.springLearn.classicProxyAop;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SleepConfig.class)
public class Test {

	@Autowired
	Sleepable sleeper;
//	public static void main(String[] args) {
//		// 测试经典的基于代理的AOP
////		ApplicationContext appCtx = new ClassPathXmlApplicationContext("config/SpringConfig.xml");
////		Sleepable sleeper = (Sleepable)appCtx.getBean("humanProxy");
//		
////		sleeper.sleep();
//		sleeper.sleep();
//		
//	}
	
	@org.junit.Test
	public void test() {
//		fail("Not yet implemented");
		assertNotNull(sleeper);
		sleeper.sleep();
	}

}
