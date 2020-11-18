package com.java.fx.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 饮品制作
 */
public class JuiceMaker {

    private Source source;

    public void makeJuice(String name){
        System.out.println(name + "用户点了一杯" + source.getFruit() + source.getSugar() + source.getSize());
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
