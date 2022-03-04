package com.life.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
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
@Aspect
@Slf4j
@Component
public class LogAspects {

    /**
     * 定义一个切入点,拦截MathCalculator类中的所有public 返回值为int的方法
     */
    @Pointcut("execution(public int com.life.spring.bean.MathCalculator.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        log.info("----logStart----方法名："+methodName+",参数："+ Arrays.toString(joinPoint.getArgs()));
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        log.info("----logEnd----方法名："+methodName);
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        log.info("----logReturn----方法名："+methodName+",返回值："+result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "error")
    public void logException(JoinPoint joinPoint,Exception error){
        String methodName = joinPoint.getSignature().getName();
        log.info("----logException----方法名："+methodName+",异常："+error);
    }


}
