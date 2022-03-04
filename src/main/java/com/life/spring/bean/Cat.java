package com.life.spring.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Title: Cat
 * @Description: TODO
 * @Author: yanglin
 * @Date: 2022年03月02日 16:20
 * @Copyright: 2020 All Rights Reserved.北京西天取经科技有限公司
 */
@Slf4j
public class Cat implements InitializingBean, DisposableBean, ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * 初始化时的顺序
     *      Constructor(构造方法) -> @Autowired(依赖注入) -> @PostConstruct -> InitializingBean#afterPropertiesSet() -> init-method()
     * 销毁时顺序
     *      @PreDestroy -> DisposableBean#destroy() -> destroy-method()
     */
    public Cat(){
        log.info("====Cat created===========");
    }

    @Override
    public void destroy() throws Exception {
        log.info("--------DisposableBean destroy---------------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("----------InitializingBean afterPropertiesSet--------------");
    }

    @PostConstruct
    public void postConstruct(){
        log.info("-----------postConstruct------------");
    }

    @PreDestroy
    public void preDestroy(){
        log.info("------preDestroy----------");
    }

    public void init(){
        log.info("------init-method--------",this);
    }

    //定义一个销毁方法
    public void destroyMethod(){
        log.info("---------destroy-method---------");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
