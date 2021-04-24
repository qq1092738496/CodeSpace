package com.meditation.util;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: Springdemo
 * @Package: com.meditation.util
 * @ClassName: slitting
 * @Author: yf
 * @Description: ${description}
 * @Date: 2020/7/5 3:22
 */
@Aspect
@Component
public class slitting {

    /**
     * 告诉spring每个方法什么时候运行:
     * try{
     *      @Before("") 目标方法开始之前执行
     *      method.invoke(obj,args);
     *      @AfterReturning 目标方法返回之后执行
     *      return null;
     * }catch(e){
     *      @AfterThrowing 目标方法异常之后执行
     * }finaliy{
     *      @After("") 目标方法结束之后执行
     * }
     * */

    /**
     * 切入点表达式, 表明需要通知方法,需要切入到那些连接点;
     * execution(访问标识符 返回类型 类路径.方法(参数,参数))
     */

    @Before("execution(public int com.meditation.service.Calculator.*(int,int))")
    public void begin() {
        System.out.println("程序开始了");
    }

    @After("execution(public int com.meditation.service.Calculator.*(int,int))")
    public void finish() {
        System.out.println("程序结束了");
    }

    @AfterReturning("execution(public int com.meditation.service.Calculator.*(int,int))")
    public void retur() {
        System.out.println("程序返回了");
    }

    @AfterThrowing("execution(public int com.meditation.service.Calculator.*(int,int))")
    public void abnomality() {
        System.out.println("程序异常了");
    }
}
