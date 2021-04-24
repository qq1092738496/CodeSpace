package com.meditation.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @description:
 * @author: Andy
 * @time: 2020/7/8 14:55
 */

@Aspect
@Component
@Order(2)
public class validateApsect {


    @Before("com.meditation.util.slitting.myexecution()")
    public int begin(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        System.out.println("(validateApsect)普通通知" + signature.getName() + "程序开始了" + Arrays.asList(args));
        return 100;
    }

    @AfterReturning(value = "com.meditation.util.slitting.myexecution()", returning =
            "result")
    public void retur(JoinPoint joinPoint, Object result) {
        System.out.println("(validateApsect)普通通知" + joinPoint.getSignature().getName() + "程序返回了" + "参数为:" + result);
    }

    @After(value = "com.meditation.util.slitting.myexecution()")
    public void finish(JoinPoint joinPoint) {

        System.out.println("(validateApsect)普通通知" + joinPoint.getSignature().getName() + "程序结束了");
    }


    @AfterThrowing(value = "com.meditation.util.slitting.myexecution()", throwing = "e")
    public void abnomality(JoinPoint joinPoint, Exception e) {
        System.out.println("(validateApsect)普通通知" + joinPoint.getSignature().getName() + "程序异常了" + "异常是:" + e);
    }
}
