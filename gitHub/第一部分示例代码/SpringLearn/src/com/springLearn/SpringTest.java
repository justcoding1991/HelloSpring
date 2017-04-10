package com.springLearn;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=FruitConfig.class)
public class SpringTest {

	@Autowired
	Fruit fruit;
	
	@Test
	public void test() {
//		fail("Not yet implemented");
		assertNotNull(fruit);
		fruit.eat("apple",new Date());
	}

}
