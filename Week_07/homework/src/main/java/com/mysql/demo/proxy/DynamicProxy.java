package com.mysql.demo.proxy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK 动态代理
 * 通过反射代理方法，比较消耗系统性能
 */
public class DynamicProxy {
    private Object target;
    public DynamicProxy(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (Object proxy, Method method, Object[] args) -> {
                    System.out.println("开启事务");
                    method.invoke(target, args);
                    System.out.println("提交事务");
                    return null;
                }
        );
    }

    public static void main(String[] args) {
        IUserDao userDao = new UserDao();
        DynamicProxy proxy = new DynamicProxy(userDao);
        IUserDao dao = (IUserDao) proxy.getProxyInstance();
        dao.save();
    }
}

/**
 * Cglib 动态代理
 * 无性能问题 但是需要继承目标对象 重写方法 故目标对象不能为final类
 */
class CglibProxy implements MethodInterceptor {
    private Object target;//维护一个目标对象
    public CglibProxy(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        //工具类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调
        enhancer.setCallback(this);
        //创建子类对象代理
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
        method.invoke(target, args);
        System.out.println("提交事务");
        return null;
    }

    public static void main(String[] args) {
        IUserDao userDao = new UserDao();
        CglibProxy proxy = new CglibProxy(userDao);
        IUserDao dao = (IUserDao) proxy.getProxyInstance();
        dao.save();
    }
}
