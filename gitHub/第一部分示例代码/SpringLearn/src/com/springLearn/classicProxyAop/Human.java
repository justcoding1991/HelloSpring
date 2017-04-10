package com.springLearn.classicProxyAop;

import org.springframework.stereotype.Component;

@Component
public class Human implements Sleepable {

	@Override
	public void sleep() {
		// 实现接口中方法
		System.out.println("睡觉了！梦中自有颜如玉！");
	}

}
