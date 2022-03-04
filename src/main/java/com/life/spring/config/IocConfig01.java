package com.life.spring.config;

import com.life.spring.bean.Cat;
import com.life.spring.bean.Person;
import com.life.spring.service.PersonService;
import org.springframework.context.annotation.*;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

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
        value = "com.life.spring",



        //排查哪些注解的类不进行加载
        excludeFilters = {
            //@ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class}),
            @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
        },

        //仅扫描哪些注解，必须将useDefaultFilters = false才会有作用
        includeFilters = {
            //只有包含有@Controller注解的类的回加载进ioc容器
            @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
            //加入PersonService及其子类和实现类
            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = PersonService.class)
        },

        //禁用默认过滤器
        useDefaultFilters = false
)
public class IocConfig01 {

    /**
     * scope值：
     *  prototype：多实例，每次获取对象时创建对象
     *  singleton：单实例，ioc容器启动时创建对象放入到容器中，以后每次获取都是从该容器中获取同一个对象
     *  request：同一个请求一个实例
     *  session：同一个session一个实例
     */
    @Scope("prototype")
    //@Scope(ThreadScope.THREAD_SCOPE)
    @Bean
    public Person person(){
        return new Person("lisi",23);
    }


    @Lazy //懒加载，在第一次getBean时进行初始化
    @Bean //正常加载，是在ioc容器初始化时就会进行创建
    public Cat cat(){
        return  new Cat();
    }
}
