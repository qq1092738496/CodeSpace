package com.proxy;

import com.proxy.util.Calculator;
import com.proxy.util.utilImpl.CalculatorImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @description:
 * @author: Andy
 * @time: 2020/10/5 15:27
 */


public class proxyCalculator {
    /**
     *   proxy代理类 java.lang.reflect包下
     *   oop面向对象编程思想: 继承,多态,封装,抽象;
     *   动态代理
     */
    public Calculator CalculatorLog(final Calculator calculator){
        ClassLoader CalculatorLoader = calculator.getClass().getClassLoader();
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        Object proxyObject = Proxy.newProxyInstance(CalculatorLoader, interfaces, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("参数" + Arrays.asList(args) + "执行" + method.getName() + "方法");
                Object invoke = method.invoke(calculator,args);
                System.out.println("结果:"+invoke);
                return invoke;
            }
        });
        return (Calculator) proxyObject;
    }
}
