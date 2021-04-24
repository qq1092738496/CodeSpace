package com.meditation.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

import java.util.Arrays;

/**
 * @description:
 * @author: Andy
 * @time: 2020/7/8 14:55
 */


public class validateApsect {


    public int begin(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        System.out.println("(validateApsect)普通通知" + signature.getName() + "程序开始了" + Arrays.asList(args));
        return 100;
    }

    public void retur(JoinPoint joinPoint, Object result) {
        System.out.println("(validateApsect)普通通知" + joinPoint.getSignature().getName() + "程序返回了" + "参数为:" + result);
    }

    public void finish(JoinPoint joinPoint) {

        System.out.println("(validateApsect)普通通知" + joinPoint.getSignature().getName() + "程序结束了");
    }


    public void abnomality(JoinPoint joinPoint, Exception e) {
        System.out.println("(validateApsect)普通通知" + joinPoint.getSignature().getName() + "程序异常了" + "异常是:" + e);
    }
}
