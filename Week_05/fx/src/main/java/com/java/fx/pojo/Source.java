package com.java.fx.pojo;

/**
 * 饮品制作原料
 */
public class Source {
    /**
     * 类型
     */
    private String fruit;
    /**
     * 糖分描述
     */
    private String sugar;
    /**
     * 大小杯
     */
    private String size;

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Source{" +
                "fruit='" + fruit + '\'' +
                ", sugar='" + sugar + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
