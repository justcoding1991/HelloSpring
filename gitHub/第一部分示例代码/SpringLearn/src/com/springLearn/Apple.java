package com.springLearn;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Apple implements Fruit {

	@Override
	public void eat(String type,Date time) {
		System.out.println("this fruit is an "+ type + ",the time is "+ time);
	}

}
