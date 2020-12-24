package com.mysql.demo.config;

import com.mysql.demo.entity.Custom;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MyXMLHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("custom", new MyXMLBeanDefintionParser(Custom.class));
//        registerBeanDefinitionParser("school", new MyXMLBeanDefintionParser(School.class));
    }
}
