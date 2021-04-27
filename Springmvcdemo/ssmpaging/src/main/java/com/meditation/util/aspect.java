package com.meditation.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @description:
 * @author: Andy
 * @time: 2021/4/27 12:33
 */

@Aspect()
@Component
public class aspect {
    //@Around("execution(* com.meditation.controller.*(..)))")
    public Object haha (ProceedingJoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();//获取当前连接点执行的方法
        Object[] args = joinPoint.getArgs();//获取当前连接点的参数


        Object proceed = null;



        try {
            /*前置通知*/
            System.out.println("（前置通知）方法："+signature.getName()+"已执行，参数："+ Arrays.toString(args));
            proceed = joinPoint.proceed();
            /*返回通知*/
            System.out.println("（返回通知）结果:"+proceed);
        }catch (Throwable  throwable){
            /*异常通知*/
            System.out.println("（异常通知）异常：" + signature.getName() + "方法出现异常:" + throwable);
            //出现异常通知, 环绕就会优先捕捉异常, 为了 让其他通知捕捉到异常 一定要抛出去
            throw new RuntimeException();
        }finally {
            /*结束通知*/
            System.out.println("---当前请求结束---");
        }

        return proceed;
    }
}
