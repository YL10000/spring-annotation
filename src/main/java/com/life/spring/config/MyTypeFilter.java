package com.life.spring.config;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @Title: MyTypeFilter
 * @Description: TODO
 * @Author: yanglin
 * @Date: 2022年02月07日 21:33
 * @Copyright: 2020 All Rights Reserved.北京西天取经科技有限公司
 */
public class MyTypeFilter implements TypeFilter {

    /**
     * metadataReader 可以获取当前类信息
     * metadataReaderFactory 可以获取其他任何类信息
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //System.out.println("annotationMetadata:"+annotationMetadata.getAnnotationTypes());
        //获取当前类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //System.out.println("classMetadata:"+classMetadata.getClassName());
        //类名中有er的都符合规则
        return classMetadata.getClassName().contains("er");
    }
}
