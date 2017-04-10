package com.springLearn.classicProxyAop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SleepHelper {
//
//	@Override
//	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
//			Object arg3) throws Throwable {
//		System.out.println("起床后要先穿衣服！");
//	}
//
//	@Override
//	public void before(Method arg0, Object[] arg1, Object arg2)
//			throws Throwable {
//		System.out.println("通常情况下睡觉之前要脱衣服！");
//	}
	@Pointcut("execution(* com.springLearn.classicProxyAop.Sleepable.sleep(..))")
	public void sleepHelp(){}
	
	@Before("sleepHelp()")
	public void beforSleep(){
		System.out.println("通常情况下睡觉之前要脱衣服！");
	}
	
	@AfterReturning("execution(* com.springLearn.classicProxyAop.Sleepable.sleep(..))")
	public void afterSleep(){
		System.out.println("满血复活");
	}
	

}
