package com.meditation.util;

import com.meditation.service.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @ProjectName: Springdemo
 * @Package: com.meditation.util
 * @ClassName: CalculatorProxy
 * @Author: yf
 * @Description: ${description}
 * @Date: 2020/7/4 21:52
 */

public class CalculatorProxy {
    public static Calculator getgetProxy(final Calculator calculator) {
        ClassLoader classLoader = calculator.getClass().getClassLoader();
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            /**
             * 方法执行器InvocationHandler中有三个对象:
             * Object proxy:代理对象,给jdk使用,任何时候都不要动这个对象;
             * Method method:当前将要执行的目标对象方法;
             * Object[] args:调用方法时,传入参数传值;
             *
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /**
                 * invoke 反射:利用反射执行目标方法
                 * result 目标方法执行后的返回值, 必须return出去,外界才能拿到真正执行后的返回值;
                 */
                System.out.println("这是动态代理执行的方法");
                System.out.println(method.getName() + "方法开始执行,用到" + Arrays.asList(args));
                Object result = method.invoke(calculator, args);
                System.out.println(result);
                return result;
            }
        };
        /**
         * 被代理对象必须提供 ,类加载器Loader,实现的接口interfaces,方法执行器InvocationHandler就是这个对象执行目标方法;
         * 获取类加载器: calculator.getClass().getClassLoader();
         * 获取所实现的接口calculator.getClass().getInterfaces(),动态代理必须要实现接口,拿到接口;
         */
        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, h);
        return (Calculator) proxy;
    }
}
