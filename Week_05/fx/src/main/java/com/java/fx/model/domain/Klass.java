package com.java.fx.model.domain;

import java.util.List;

public class Klass {
    List<Student> students;

    public void dong(){
        System.out.println(this.getStudents());
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
