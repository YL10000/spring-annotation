package com.life.spring.config;

import com.life.spring.bean.Cat;
import com.life.spring.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.*;

/**
 * @Title: MainConfig
 * @Description: TODO
 * @Author: yanglin
 * @Date: 2022年02月07日 20:43
 * @Copyright: 2020 All Rights Reserved.北京西天取经科技有限公司
 */
@Configuration
@ComponentScan(
        //扫描路径
        value = "com.life.spring.bean"
)
@Import({Cat.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})//导入的bean的id为类的全路径com.life.spring.bean.Cat
@Slf4j
public class IocConfig03 {

    @Bean
    public Person person(){
        return new Person("zhangsan",25);
    }

    @Bean
    @Conditional(WindowCondition.class)
    public Person person1(){
        return new Person("李四",25);
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public Person person2(){
        return new Person("王五",25);
    }




}
