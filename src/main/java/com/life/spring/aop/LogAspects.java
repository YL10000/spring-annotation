package com.life.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Title: LogAspects
 * @Description: 日志切面类
 * @Author: yanglin
 * @Date: 2022年03月04日 16:40
 * @Copyright: 2020 All Rights Reserved.北京西天取经科技有限公司
 */
@Aspect //声明为切面类
@Slf4j
@Component //将该类添加到ioc容器中
public class LogAspects {

    //执行顺序为around before -> start -> 目标方法 -> return -> end -> around after

    /**
     * 定义一个切面,拦截MathCalculator类中的所有public 返回值为int的方法
     */
    @Pointcut("execution(public int com.life.spring.bean.MathCalculator.*(..))")
    public void pointCut(){}

    /**
     * 前置通知：在目标方法运行之前运行
     * @param joinPoint
     */
    @Before("pointCut()")//指定切入点
    public void logStart(JoinPoint joinPoint){
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        log.info("----logStart----方法名："+methodName+",参数："+ Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 后置通知：在目标方法运行结束之后运行，无论目标方法是正常结束还是异常结束都会执行
     * @param joinPoint
     */
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        log.info("----logEnd----方法名："+methodName);
    }

    /**
     * 返回通知：在目标方法正常返回之后运行
     * @param joinPoint
     * @param result   返回值
     */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        log.info("----logReturn----方法名："+methodName+",返回值："+result);
    }

    /**
     * 异常通知：在目标方法运行出现异常之后运行
     * @param joinPoint
     * @param error 异常信息
     */
    @AfterThrowing(value = "pointCut()",throwing = "error")
    public void logException(JoinPoint joinPoint,Exception error){
        String methodName = joinPoint.getSignature().getName();
        log.info("----logException----方法名："+methodName+",异常："+error);
    }

    /**
     * 环绕通知：动态代理，我们可以直接手动推进目标方法运行（joinPoint.procced()）
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("pointCut()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        log.info("----logAround before----方法名："+methodName+",参数为："+ Arrays.toString(proceedingJoinPoint.getArgs()));
        //执行目标方法，并获取返回值
        Object result = proceedingJoinPoint.proceed();
        log.info("----logAround after----方法名："+methodName+",result:"+result);
        return result;
    }


}
