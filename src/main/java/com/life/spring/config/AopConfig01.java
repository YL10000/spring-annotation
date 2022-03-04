package com.life.spring.config;

import com.life.spring.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.*;

/**
 * @Title: MainConfig
 * @Description: aop配置类
 * @Author: yanglin
 * @Date: 2022年02月07日 20:43
 * @Copyright: 2020 All Rights Reserved.北京西天取经科技有限公司
 */
@Configuration
@ComponentScan({"com.life.spring.bean","com.life.spring.aop"})
@Slf4j
@EnableAspectJAutoProxy
public class AopConfig01 {

}
