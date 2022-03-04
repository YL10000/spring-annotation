package com.life.spring.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

/**
 * @Title: MyImportSelector
 * @Description: TODO
 * @Author: yanglin
 * @Date: 2022年03月02日 19:49
 * @Copyright: 2020 All Rights Reserved.北京西天取经科技有限公司
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //将返回值中的类的全类目导入到spring ioc容器中
        return new String[]{"com.life.spring.bean.Color","com.life.spring.bean.Red"};
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        //排除掉selectImports返回值中含有Red的
        return (className)->className.contains("Red");
    }
}
