package com.java.fx.config;

import com.java.fx.model.domain.VirtualWallet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

/**
 * 使用注解方式装配Bean
 * @Configuration 注解相当于 XML 文件的根元素，必须要，有了才能解析其中的 @Bean 注解
 */
@Configuration
public class BeanFactory {
    private static Log log = LogFactory.getLog(BeanFactory.class);
    @Bean("publicVirtualWallet")
    public VirtualWallet getPublicVirtualWallet(){
        VirtualWallet virtualWallet = new VirtualWallet(1L);
        log.info("pulbic VirtualWallet initial complete.");
        return virtualWallet;
    }
}
