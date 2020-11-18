package com.java.fx.pojo;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 店长 配合@ComponentScan使用 但是通过@Value注入不了对象
 */
@Component(value = "storeManager")
public class StoreManager {
    @Value("不想死")
    private String storeName;
//    private JuiceMaker juiceMaker;
    @Autowired
    private CafeMaker cafeMaker;

    public void doJob(){
        System.out.println(Objects.isNull(cafeMaker) ? storeName + "店长在忙，咖啡制作请稍等... " : storeName + "店长"+cafeMaker.makeCafe());
//        juiceMaker.makeJuice("leo");
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

//    public JuiceMaker getJuiceMaker() {
//        return juiceMaker;
//    }
//
//    public void setJuiceMaker(JuiceMaker juiceMaker) {
//        this.juiceMaker = juiceMaker;
//    }

    public CafeMaker getCafeMaker() {
        return cafeMaker;
    }

    public void setCafeMaker(CafeMaker cafeMaker) {
        this.cafeMaker = cafeMaker;
    }
}


