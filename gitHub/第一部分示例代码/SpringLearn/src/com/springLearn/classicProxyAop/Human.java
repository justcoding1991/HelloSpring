package com.springLearn.classicProxyAop;

import org.springframework.stereotype.Component;

@Component
public class Human implements Sleepable {

	@Override
	public void sleep() {
		// ʵ�ֽӿ��з���
		System.out.println("˯���ˣ���������������");
	}

}
