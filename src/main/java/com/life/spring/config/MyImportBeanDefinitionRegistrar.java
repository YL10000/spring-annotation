package com.life.spring.config;

import com.life.spring.bean.Yellow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Title: MyImportBeanDefinitionRegistrar
 * @Description: TODO
 * @Author: yanglin
 * @Date: 2022年03月02日 20:05
 * @Copyright: 2020 All Rights Reserved.北京西天取经科技有限公司
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //手动注册bean 到spring ioc容器
        if (registry.containsBeanDefinition("com.life.spring.bean.Color")){
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Yellow.class);
            registry.registerBeanDefinition("yellow",rootBeanDefinition);
        }
    }
}
