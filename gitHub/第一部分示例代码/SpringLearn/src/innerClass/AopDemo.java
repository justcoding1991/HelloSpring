package innerClass;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring-aop.xml")
public class AopDemo {
    @Autowired
    private Target target;

    @Test
    public void testSayHello() {
        target.doSomething("hello world");
    }
}

class Target {
    public void doSomething(String params) {
        System.out.println(params);
    }
}

class Interceptor3 {

    public void invoke(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("interceptor3, before invoke");
        proceedingJoinPoint.proceed();
        System.out.println("interceptor3, after invoke");
    }
}

class Interceptor4 {

    public void invoke(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("interceptor4, before invoke");
        proceedingJoinPoint.proceed();
        System.out.println("interceptor4, after invoke");
    }
}
