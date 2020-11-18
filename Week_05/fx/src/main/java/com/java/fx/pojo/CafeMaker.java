package com.java.fx.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 咖啡制作
 */
@Component
public class CafeMaker {
    @Autowired
    private CafeBean cafeBean;

    public String  makeCafe(){return "正在制作"+cafeBean.getBeanName()+"咖啡";}

    public CafeBean getCafeBean() {
        return cafeBean;
    }

    public void setCafeBean(CafeBean cafeBean) {
        this.cafeBean = cafeBean;
    }
}
