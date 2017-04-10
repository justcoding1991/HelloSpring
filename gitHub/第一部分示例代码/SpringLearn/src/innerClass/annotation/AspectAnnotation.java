package innerClass.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring-annotation.xml")
public class AspectAnnotation {
    @Autowired
    private Target target;

    @Test
    public void testSayHello() {
        target.doSomething("hello world");
    }
}

@ComponentScan
class TargetHelp{
	
}

@Component
class Target {

    public void doSomething(String params) {
        System.out.println(params);
    }
}

@Aspect
@Component
class Interceptor3 {

    @Pointcut("execution(* innerClass.annotation.Target.doSomething(String))")
    public void doSomething() {}

    @Around("doSomething()")
    public void invoke(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("interceptor3, before invoke");
        proceedingJoinPoint.proceed();
        System.out.println("interceptor3, after invoke");
    }
}

@Aspect
@Component
class Interceptor4 {

    @Pointcut("execution(* innerClass.annotation.Target.doSomething(String))")
    public void doSomething() {}

    @Around("doSomething()")
    public void invoke(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("interceptor4, before invoke");
        proceedingJoinPoint.proceed();
        System.out.println("interceptor4, after invoke");
    }
}