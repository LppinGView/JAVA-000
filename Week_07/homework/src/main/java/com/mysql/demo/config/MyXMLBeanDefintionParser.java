package com.mysql.demo.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import java.util.stream.Stream;


public class MyXMLBeanDefintionParser implements BeanDefinitionParser {

    private final Class<?> beanClass;

    public MyXMLBeanDefintionParser(Class<?> beanClass){
        this.beanClass = beanClass;
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition root = new RootBeanDefinition();
        root.setBeanClass(beanClass);
        Stream.of(element.getAttributes()).forEach(node -> {
            for (int j = 0; j< node.getLength(); j++){
                root.getPropertyValues()
                        .addPropertyValue(node.item(j).getLocalName(), node.item(j).getNodeValue());
            }
        });
        BeanDefinitionRegistry registry = parserContext.getRegistry();
        registry.registerBeanDefinition(beanClass.getName(), root);//注册bean到BeanDefinitionRegistry中
        return root;
    }
}
