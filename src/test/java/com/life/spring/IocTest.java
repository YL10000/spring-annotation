package com.life.spring;

import com.life.spring.bean.*;
import com.life.spring.config.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Title: IocTest
 * @Description: spring ioc测试类
 * @Author: yanglin
 * @Date: 2022年02月07日 20:44
 * @Copyright: 2020 All Rights Reserved.北京西天取经科技有限公司
 */
@Slf4j
public class IocTest {

    @Test
    public void test01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocConfig01.class);
        /*Person p = applicationContext.getBean(Person.class);
        Person p2 = applicationContext.getBean(Person.class);
        System.out.println(p==p2);*/
        log.info("ioc容器启动完成");
        applicationContext.getBean(Cat.class);

       //printBeans(applicationContext);
    }

    @Test
    @SneakyThrows
    public void test02(){
        //自定义Scope,并进行注册
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(IocConfig02.class);
        /**
         * 1 ConfigurableBeanFactory中注册自定义的scope到容器中
         *      org.springframework.beans.factory.config.ConfigurableBeanFactory#registerScope(java.lang.String, org.springframework.beans.factory.config.Scope)
         * 2 ConfigurableListableBeanFactory extends ConfigurableBeanFactory
         *      beanFactory继承了ConfigurableBeanFactory，所以可以注册scope
         */
        annotationConfigApplicationContext.getBeanFactory().registerScope(ThreadScope.THREAD_SCOPE,new ThreadScope());

        //其实spring已经提供了线程域的实现，只需要注册就可以使用
        //annotationConfigApplicationContext.getBeanFactory().registerScope(ThreadScope.THREAD_SCOPE,new SimpleThreadScope());
        for (int i = 0; i < 2; i++) {
            //同一个线程返回的bean是一样的，不同线程返回不同的bean
            new Thread(()->{
                log.info(Thread.currentThread().getName()+":"+annotationConfigApplicationContext.getBean("cat"));
                log.info(Thread.currentThread().getName()+":"+annotationConfigApplicationContext.getBean("cat"));
            }).start();
        }
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void test03(){
        //System.setProperty("os.name","linux centos 6");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocConfig03.class);
        printBeans(applicationContext);
        //Environment environment = applicationContext.getEnvironment();
        //log.info(environment.getProperty("os.name"));//Windows 10
        //获取指定类型的所用bean
        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);
        System.out.println(applicationContext.getBeansOfType(MyFactoryBean.class));

        /*
         * 在容器中注册的factoryBean为
         * myFactoryBean=Person(name=factory bean person, age=23)
         * 获取的时候可以根据id myFactoryBean获取
         *      也可以根据类型Person进行获取
         *      applicationContext.getBeansOfType(Person.class)
         * */
        applicationContext.getBean("myFactoryBean");

        /*
         * 在容器中注册的factoryBean本身为
         * {&myFactoryBean=com.life.spring.bean.MyFactoryBean@2a3b5b47}
         * 获取的时候可以根据id &myFactoryBean获取
         *      也可以根据类型MyFactoryBean进行获取
         *      applicationContext.getBeansOfType(MyFactoryBean.class)
         *
         * 使用&前缀是由于在BeanFactory中配置写死了：
         *      String FACTORY_BEAN_PREFIX = "&";
         * */
        applicationContext.getBean("&myFactoryBean");
    }


    @Test
    public void test04(){
        // 容器创建完成后会调用bean的初始化方法
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocConfig04.class);
        printBeans(applicationContext);

        System.out.println(applicationContext.getBeansOfType(BeanPostProcessor.class));

        //容器关闭后会调用bean的销毁方法
        //applicationContext.close();
    }

    @Test
    public void test05(){
        System.setProperty("spring.profiles.active","dev");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocConfig05.class);
        //printBeans(applicationContext);
        System.out.println(applicationContext.getBeansOfType(Person.class));
        //System.out.println(applicationContext.getBean(User.class));
       /* User1 user1 = applicationContext.getBean(User1.class);
        System.out.println(user1);
        System.out.println(user1.getHobbies().length);
        System.out.println(user1.getHobbies2().size());
        //@PropertySource获取配置文件后，并保存到运行的环境变量中，所以可以使用Environment获取配置文件的信息
        String userName = applicationContext.getEnvironment().getProperty("user1.name");
        System.out.println(userName);*/

    }

    private void printBeans(ApplicationContext applicationContext){

        /**
         * applicationContext.getBeanDefinitionNames()
         *  获取容器中所有beanDefinition的名字
         */
        //log.info("");
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(log::info);
    }
}
