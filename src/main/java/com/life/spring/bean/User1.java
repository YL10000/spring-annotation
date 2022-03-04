package com.life.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * @Title: User1
 * @Description: 通过配置文件注入
 * @Author: yanglin
 * @Date: 2022年03月04日 11:13
 * @Copyright: 2020 All Rights Reserved.北京西天取经科技有限公司
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User1 {

    @Value("${user1.name}-view")
    private String name;

    @Value("${user1.age}")
    private int age;

    @Value("${user1.hobbies}")
    private String[] hobbies;

    //@Value("${user1.hobbies}")//size=1
    //#和$进行混用，$优先级高于#先执行
    @Value("#{'${user1.hobbies}'.split(',')}")//size=2
    private List<String> hobbies2;
}
