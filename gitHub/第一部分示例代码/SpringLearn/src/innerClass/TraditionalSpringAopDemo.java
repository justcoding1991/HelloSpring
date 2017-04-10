package innerClass;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring-config.xml")
public class TraditionalSpringAopDemo {
    @Autowired
    private Service proxy;

    @Test
    public void test() {
        proxy.execute("hello world!");
    }
}

interface Service {
    void execute(String str);
}

class ServiceImpl implements Service {
    @Override
    public void execute(String str) {
        System.out.println("execute invoke: " + str);
    }
}

class Interceptor1 implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("interceptor1,before invoke");
        Object ret = methodInvocation.proceed();
        System.out.println("interceptor1,after invoke");
        return ret;
    }
}

class Interceptor2 implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("interceptor2,before invoke");
        Object ret = methodInvocation.proceed();
        System.out.println("interceptor2,after invoke");
        return ret;
    }
}