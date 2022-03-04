package com.life.spring.config;

import com.life.spring.bean.Cat;
import com.life.spring.bean.Person;
import com.life.spring.service.PersonService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

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
        value = "com.life.spring"
)
public class IocConfig02 {

    /**
     * scope值：
     *  prototype：多实例，每次获取对象时创建对象
     *  singleton：单实例，ioc容器启动时创建对象放入到容器中，以后每次获取都是从该容器中获取同一个对象
     *  request：同一个请求一个实例
     *  session：同一个session一个实例
     */
    //@Scope("prototype")
    @Scope(ThreadScope.THREAD_SCOPE)
    @Bean
    public Cat cat(){
        return new Cat();
    }
}
