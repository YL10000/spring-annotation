package com.life.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Title: Person
 * @Description: TODO
 * @Author: yanglin
 * @Date: 2022年02月07日 20:43
 * @Copyright: 2020 All Rights Reserved.北京西天取经科技有限公司
 */
@Data
@AllArgsConstructor
@Slf4j
@NoArgsConstructor
public class Person {

    //@Value("zhangsan person")
    private String name;

   //@Value("#{20-2}")
    private int age;

    //定义一个初始化方法
    public void init(){
        log.info("------person init--------",this);
    }

    //定义一个销毁方法
    public void destroy(){
        log.info("---------person destroy---------");
    }

}
