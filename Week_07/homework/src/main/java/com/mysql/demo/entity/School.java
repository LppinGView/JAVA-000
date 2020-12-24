package com.mysql.demo.entity;

public class School {
    private Integer num;
    private String addr;
    private String name;

    public School(Integer num, String addr, String name) {
        this.num = num;
        this.addr = addr;
        this.name = name;
    }

    public School(){}

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
