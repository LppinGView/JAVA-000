package com.java.fx.model.domain;

import com.java.fx.model.ISchool;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class School implements ISchool {

    @Autowired(required = true) //primary
    Klass class1;

    @Autowired
    Student student;

    @Override
    public void ding() {
        System.out.println(" students and one is " + this.student);
    }
}
