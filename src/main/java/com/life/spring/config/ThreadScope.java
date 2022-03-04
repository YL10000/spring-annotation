package com.life.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Title: ThreadScope
 * @Description: 自定义线程级别作用域,同一个线程使用相同的bean
 * @Author: yanglin
 * @Date: 2022年03月02日 15:08
 * @Copyright: 2020 All Rights Reserved.北京西天取经科技有限公司
 */
@Slf4j
public class ThreadScope implements Scope {

    public static final String  THREAD_SCOPE = "thread";

    /**
     * 同一个线程使用相同的bean,需要使用ThreadLocal进行缓存该线程中的bean
     */
    private ThreadLocal<Map<String,Object>> beanMap = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return new HashMap<>();
        }
    };

    /**
     * @Description: 返回指定name的bean,不存在使用objectFactory创建
     * @param name
	 * @param objectFactory
     */
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object bean = beanMap.get().get(name);
        if (Objects.isNull(bean)){
            bean = objectFactory.getObject();
            beanMap.get().put(name,bean);
        }
        return bean;
    }

    /**
     * @Description: 移除指定的bean
     * @param name
     */
    @Override
    public Object remove(String name) {
        return this.beanMap.get().remove(name);
    }

    /**
     * @Description: 指定bean销毁时的回调
     * @param name
	 * @param callback
     */
    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    /**
     * @Description: 解析响应的上下文数据
     * @param key
     */
    @Override
    public Object resolveContextualObject(String key) {
        log.info("====resolveContextualObject key:=======",key);
        return null;
    }

    /**
     * @Description:返回该作用域的会话标识，如：线程名称
     */
    @Override
    public String getConversationId() {
        return Thread.currentThread().getName();
    }
}
