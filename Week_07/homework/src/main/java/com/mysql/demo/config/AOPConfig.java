package com.mysql.demo.config;

import com.mysql.demo.aop.TxAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.mysql.demo")
public class AOPConfig {
    @Bean
    public TxAspect getTxAspect(){
        return new TxAspect();
    }
}
