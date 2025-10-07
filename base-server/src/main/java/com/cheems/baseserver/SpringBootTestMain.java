package com.cheems.baseserver;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.cheems.baseserver.config.AppConfig;
import com.cheems.baseserver.service.UserService;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBootTestMain {


    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ctx =
//                new AnnotationConfigApplicationContext(AppConfig.class);

        ClassPathXmlApplicationContext cxc = new ClassPathXmlApplicationContext("spring.xml");
//        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
//        Stream.of(beanDefinitionNames).forEach(System.out::println);
//        UserService userServiceBean = cxc.getBean(UserService.class);
        System.out.println(cxc.getBean("userService"));
//        UserService userServiceBean1 = cxc.getBean(UserService.class);
//        userServiceBean.test();

//        userServiceBean.test();
    }
}
