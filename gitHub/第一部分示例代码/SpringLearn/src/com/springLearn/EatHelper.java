package com.springLearn;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EatHelper {
	@Pointcut("execution(* com.springLearn.Fruit.eat(..))")
	public void health(){}
	
	@Before("health() && args(type)")
	public void selectFruit(String type){
		System.out.println("select a kind of fruit :" + type);
	}
	
	@Before("health()")
	public void wash(JoinPoint joinPoint){
		System.out.println("wash the fruit" );
		System.out.println("joinPoint.getSignature().getName()£º" + joinPoint.getSignature().getName());
	}
	
	@AfterReturning("health()")
	public void evaluateFruit(){
		System.out.println("this fruit tastes good");
	}
	
	@AfterThrowing("health()")
	public void throwAway(){
		System.out.println("this fruit is bad");
	}
	
}
