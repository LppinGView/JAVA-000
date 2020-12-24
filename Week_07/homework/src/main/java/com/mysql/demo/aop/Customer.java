package com.mysql.demo.aop;

import com.mysql.demo.annotation.Action;
import org.springframework.stereotype.Component;

@Component
public class Customer{

    @Action(name = "here")
    public void save(){
        System.out.println("保存数据");
    }
}
