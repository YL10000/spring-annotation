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
@ComponentScan(value = "com.life.spring.bean")
@Slf4j
@Import(MyBeanPostProcessor.class)
public class IocConfig04 {

    // 配置bean的初始化方法为init(),在bean初始化完成后调用，如果是prototype，每次初始化都进行调用
    // 销毁方法为destroy(),在容器关闭后调用，但如果是prototype,不会调用销毁方法
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Person person(){
        return new Person("zhangsan",25);
    }

    @Bean(initMethod = "init",destroyMethod = "destroyMethod")
    public Cat cat(){
        return new Cat();
    }
}
