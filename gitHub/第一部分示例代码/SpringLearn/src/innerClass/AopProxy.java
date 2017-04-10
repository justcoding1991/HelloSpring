package innerClass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;

/**
 * jdk动态代理实现aop拦截
 * @author jacksonshi
 * @version $Id: DynamicProxy.java, v 0.1 16/9/11, 11:02 jacksonshi Exp $
 * 动态代理技术
 */
public class AopProxy {

    public static Object createProxyByJdkDynamicProxy(final Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass()
            .getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                before(proxy, method, args);
                Object ret = method.invoke(target, args);
                after(proxy, method, args);
                return ret;
            }
        });
    }

    public static <T> T createProxyByCglib(final T target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(AopProxy.class.getClassLoader());
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new org.springframework.cglib.proxy.InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                before(proxy, method, args);
                Object ret = method.invoke(target, args);
                after(proxy, method, args);
                return ret;
            }
        });
        return (T)enhancer.create();
    }

    private static void before(Object proxy, Method method, Object[] args) {
        System.out.println("do something before: " + method.getName());
    }

    private static void after(Object proxy, Method method, Object[] args) {
        System.out.println("do something after: " + method.getName());
    }

    public static void main(String[] args) {
        ITarget t = new TargetImpl();
        ITarget proxy = (ITarget) createProxyByJdkDynamicProxy(t);
        proxy.sayHello();
//        proxy.sayHello2();

//        TargetImpl cglibProxy = (TargetImpl) createProxyByCglib(t);
//        cglibProxy.sayHello();
//        cglibProxy.sayHello2();
    }

}

interface ITarget {
    void sayHello();
}

class TargetImpl implements ITarget {
    @Override
    public void sayHello() {
        System.out.println("hello");
    }

    public void sayHello2() {
        System.out.println("hello 2!");
    }
}