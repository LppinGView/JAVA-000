package com.java.fx;

import com.java.fx.config.StudentProperties;
import com.java.fx.model.ISchool;
import com.java.fx.model.domain.School;
import com.java.fx.model.domain.Student;
import com.java.fx.pojo.JuiceMaker;
import com.java.fx.pojo.Source;
import com.java.fx.pojo.StoreConfigScan;
import com.java.fx.pojo.StoreManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

@SpringBootTest
class FxApplicationTests {

//    @Autowired
//    Student student;

    @Test
    void contextLoads() {
    }

    @Test
    public void getBean(){
        //方式1：使用xml配置文件配置Bean
        System.out.println("方式1：使用xml配置文件配置Bean");
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Source source = (Source) xmlContext.getBean("source");
        System.out.println(source.toString());

        //使用xml配置文件进行依赖注入DI
        JuiceMaker juiceMaker = (JuiceMaker) xmlContext.getBean("juiceMaker");
        juiceMaker.makeJuice("leo");

        //@Component注解方式 配合包扫描 通过@Value注入属性，但是注入不了对象...
        System.out.println("------------分隔符-----------");
        System.out.println("@Component注解方式(@Service、@Controller等注解类似) 配合包扫描 通过@Value注入属性，但是注入不了对象...使用@Autowired注入对象");
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext(StoreConfigScan.class);
        StoreManager storeManager = annotationContext.getBean("storeManager", StoreManager.class);
        storeManager.doJob();

        //使用@Bean+@Configuration
        System.out.println("------------分隔符-----------");
        System.out.println("使用@Bean+@Configuration");
        System.out.println(annotationContext.getBean("publicVirtualWallet"));
    }

    @Test
    public void starter(){
//        System.out.println("------------分隔符-----------");
//        System.out.println("自定义starter,按需配置student");
////        School school= new School();
////        school.ding();
//
//        System.out.println(student.toString());
    }

}
