package com.mysql.demo;

import com.mysql.demo.aop.Customer;
import com.mysql.demo.entity.Custom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private Customer customer;

    @Test
    void contextLoads() {
    }

    @Test
    void testMyXmlLoa(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Custom custom = (Custom) applicationContext.getBean(Custom.class.getName());
        System.out.println("name: " + custom.getName() + " id: " + custom.getId());
    }

    @Test
    void testAop(){
        customer.save();
    }
}
