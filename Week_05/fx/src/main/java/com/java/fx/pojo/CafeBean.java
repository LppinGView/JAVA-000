package com.java.fx.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 咖啡豆
 */
@Component(value = "cafeBean")
public class CafeBean {
    @Value("猫屎")
    private String beanName;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
