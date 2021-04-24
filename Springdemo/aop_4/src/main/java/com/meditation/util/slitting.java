package com.meditation.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import java.util.Arrays;

/**
 * @ProjectName: Springdemo
 * @Package: com.meditation.util
 * @ClassName: slitting
 * @Author: yf
 * @Description: ${description}
 * @Date: 2020/7/5 3:22
 */
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
     *
     */
    /**
     * 抽取可重复的切入点表达式
     */

    ;

    public int begin(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        System.out.println("(slitting)普通通知" + signature.getName() + "程序开始了" + Arrays.asList(args));
        return 100;
    }

    public void retur(JoinPoint joinPoint, Object result) {
        System.out.println("(slitting)普通通知" + joinPoint.getSignature().getName() + "程序返回了" + "参数为:" + result);
    }


    public void abnomality(JoinPoint joinPoint, Exception e) {
        System.out.println("(slitting)普通通知" + joinPoint.getSignature().getName() + "程序异常了" + "异常是:" + e);
    }

    public void finish(JoinPoint joinPoint) {
        System.out.println("(slitting)普通通知" + joinPoint.getSignature().getName() + "程序结束了");
    }

    /**
     * 环绕通知: 前置 , 返回 , 异常 ,结束,四和一通知;
     * 好处就是更加方便, 坏处就是没有单个通知的灵活性高;
     * ProceedingJoinpoint 继承了 joinpoint 调用proceed()方法,传入目标目标方法的参数
     * 对应 jdk.proxy代理的的method.invok, 他返回的 就是目标,返回值;
     * 也就是说,被注解 @Around的通知方法, return值代表的 结果的值,即使方法内部为空;
     * 环绕通知:是优于普通通知执行,执行顺序;
     * 正常执行:
     * {前置通知}
     * try{
     * 环绕前置
     * 环绕执行,目标方法执行
     * 环绕返回
     * }catch(){
     * 环绕出现异常
     * }finally{
     * 环绕后置
     * }
     * {普通后置}
     * {普通方法返回/方法异常}
     * <p>
     * 单切面:
     * 普通通知顺序: 前置通知 --> 后置通知 --> 返回通知 或 异常通知
     * 环绕通知顺序: 环绕前置 --> 环绕返回 或 异常通知 --> 环绕后置
     * 环绕和普通执行顺序: 环绕通知前置 --> 普通通知前置 --> 环绕通知返回 或 异常通知  --> 环绕通知结束 -->  普通后置通知 --> 普通通知返回 或 异常通知;
     * <p>
     * 多切面:
     *
     * @Order() 越小优先级越高 , 多个切面类按照优先级启动 前置通知 --> 直至最后一个切面类单个执行完成 后置通知 返回通知或异常通知 往上执行 ,
     * 如果单个切面类中有环绕通知 和 普通通知,  在执行这切面类时, 会优先 环绕通知前置 --> 普通通知前置 --> 环绕通知返回 或 异常通知  --> 环绕通知结束 -->  普通后置通知 -->
     * 普通通知返回 或 异常通知;
     */
    public Object myAround(ProceedingJoinPoint Proceeding) {
        //就是利用反射调用目标方法即可,就是method.invoke(obj,args);
        Signature signature = Proceeding.getSignature();
        Object[] args = Proceeding.getArgs();
        Object proceed = null;
        try {
            //前置通知 @before
            System.out.println("(slitting)" + "环绕通知" + signature.getName() + "已经启动!" + "传入参数为" + Arrays.asList(args));
            proceed = Proceeding.proceed(args);
            //返回 @AfterReturning
            System.out.println("slitting)" + "环绕通知" + "计算结果为:" + proceed);
        } catch (Throwable throwable) {
            //异常 @AfterThfowing
            System.out.println("slitting)" + "环绕通知" + signature.getName() + "方法出现异常:" + throwable);
            //出现异常通知, 环绕就会优先捕捉异常, 为了 让其他通知捕捉到异常 一定要抛出去
            throw new RuntimeException();
        } finally {
            //结束  @After
            System.out.println("slitting)" + "环绕通知" + "计算结束");
        }
        return proceed;
    }

}
