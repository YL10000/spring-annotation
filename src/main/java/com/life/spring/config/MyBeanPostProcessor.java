package com.life.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Title: MyBeanPostProcessor
 * @Description: 自定义beanPostProcessor
 * @Author: yanglin
 * @Date: 2022年03月03日 14:44
 * @Copyright: 2020 All Rights Reserved.北京西天取经科技有限公司
 */
@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("-------postProcessBeforeInitialization ----------"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("-------postProcessAfterInitialization ----------"+beanName);
        return bean;
    }
}
