package com.life.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.lang.Nullable;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @Title: User
 * @Description: 不通过配置文件注入
 * @Author: yanglin
 * @Date: 2022年03月03日 20:15
 * @Copyright: 2020 All Rights Reserved.北京西天取经科技有限公司
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    //注入普通字符串
    @Value("zhangsan")
    private String name;

    /*//注入Spel表达式
    @Value("#{20-2}")
    private int age;

    //注入Spel表达式
    @Value("#{T(Math).random()*100}")
    private int random;

    //注入系统属性
    @Value("#{systemProperties['os.name']}")
    private String os;

    //注入URL资源
    @Value("https://www.baidu.com/")
    private Resource resource;

    //注入文件资源
    @Value("classpath:/config.properties")
    private Resource config;*/

    //@Autowired
    //@Qualifier("person1")
    //@Autowired
    //@javax.annotation.Resource
    @Inject
    @Named(value = "person2")
    @Nullable
    private Person person4;

}
