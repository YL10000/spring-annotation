package com.life.spring.config;

import com.life.spring.bean.Cat;
import com.life.spring.bean.Person;
import com.life.spring.bean.User;
import com.life.spring.bean.User1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * @Title: MainConfig
 * @Description: TODO
 * @Author: yanglin
 * @Date: 2022年02月07日 20:43
 * @Copyright: 2020 All Rights Reserved.北京西天取经科技有限公司
 */
@Configuration
@ComponentScan(value = "com.life.spring.bean")
@Slf4j
//@Import({User.class})
@PropertySource(value = {"classpath:/config.properties"})
public class IocConfig05 {


    @Bean
    public Person person(){
        return new Person("person",222);
    }

    @Profile("test")
    @Primary
    @Bean
    public Person person1(){
        return new Person("person1",111);
    }

    @Profile("dev")
    @Bean
    public Person person2(){
        return new Person("person2",111);
    }

   /* @Bean
    public User user(){
        return new User();
    }*/

    /*@Bean
    public User1 user1(){
        return new User1();
    }*/

    /*@Bean
    public Person person(){
        return new Person("aaa",111);
    }*/




}
