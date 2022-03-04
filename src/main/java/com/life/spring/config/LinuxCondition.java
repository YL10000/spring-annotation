package com.life.spring.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Title: LinuxCondition
 * @Description: linux操作系统的条件
 * @Author: yanglin
 * @Date: 2022年03月02日 17:24
 * @Copyright: 2020 All Rights Reserved.北京西天取经科技有限公司
 */
public class LinuxCondition implements Condition {

    /**
     * @Description: 判断该条件是否成立
     * @param context    判断条件使用的上下文环境
	 * @param metadata   当前标注了@Conditional注解的注释信息
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //可以通过context获取beanFactory和beanDefinitionRegistry来判断其他信息
        Environment environment = context.getEnvironment();
        String os = environment.getProperty("os.name");
        return os.toUpperCase().contains("LINUX");
    }
}
