package com.life.spring.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Title: MyFactoryBean
 * @Description: 使用factoryBean注册bean
 * @Author: yanglin
 * @Date: 2022年03月03日 11:18
 * @Copyright: 2020 All Rights Reserved.北京西天取经科技有限公司
 */
//@Component//id 为 myFactoryBean,bean为getObject()返回值
public class MyFactoryBean implements FactoryBean<Person> {

    @Override
    public Person getObject() throws Exception {
        return new Person("factory bean person",23);
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }
}
