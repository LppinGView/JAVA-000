package com.java.fx.config;

import com.java.fx.model.domain.Student;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 自动装配类
 */
@Configuration
@ConditionalOnClass(Student.class)
@EnableConfigurationProperties(StudentProperties.class)
public class StudentConfiguration {

    /**
     * 注入属性配置类
     */
    @Resource
    private StudentProperties studentProperties;

    /**
     * 自动装配
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(Student.class)
    @ConditionalOnProperty(prefix = "student", value = "enabled", havingValue = "true")
    public Student student(){
        Student student = new Student(Integer.parseInt(studentProperties.getId()),studentProperties.getName());
        return student;
    }

}
