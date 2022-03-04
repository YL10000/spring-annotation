package com.life.spring;

import com.life.spring.bean.MathCalculator;
import com.life.spring.config.AopConfig01;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @Title: AopTest
 * @Description: aop
 * @Author: yanglin
 * @Date: 2022年03月04日 16:51
 * @Copyright: 2020 All Rights Reserved.北京西天取经科技有限公司
 */
@Slf4j
public class AopTest {

    @Test
    public void test01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig01.class);
        printBeans(applicationContext);
        applicationContext.getBean(MathCalculator.class).div(1,0);
    }

    private void printBeans(ApplicationContext applicationContext){

        /**
         * applicationContext.getBeanDefinitionNames()
         *  获取容器中所有beanDefinition的名字
         */
        //log.info("");
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(log::info);
    }
}
