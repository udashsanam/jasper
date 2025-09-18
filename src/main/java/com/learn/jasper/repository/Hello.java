package com.learn.jasper.repository;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Hello {
    private String hello;

    private JRBeanCollectionDataSource level;


    public JRBeanCollectionDataSource getLevel() {
        return level;
    }

    public void setLevel(JRBeanCollectionDataSource level) {
        this.level = level;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
