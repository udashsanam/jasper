package com.learn.jasper.repository;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    String test;

    JRBeanCollectionDataSource subReport;



    public List<Test> getTests(){
        List<Hello> inside = new ArrayList<>();
        Hello insideOne = new Hello();
        insideOne.setHello("insideOne");
        Level2 level2 = new Level2();
        level2.setLevel2("level2first");
        insideOne.setLevel(new JRBeanCollectionDataSource(Arrays.asList(level2)));
        Hello insideTwo = new Hello();
        insideTwo.setHello("insidetwo");
        insideTwo.setLevel(new JRBeanCollectionDataSource(Arrays.asList(level2)));
        inside.add(insideOne);
        inside.add(insideTwo);
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(inside);

        List<Test> mail = new ArrayList<>();
        Test test1 = new Test();
        test1.setTest("Zero");
        test1.setSubReport(beanCollectionDataSource);
        Test test2 = new Test();
         test2.setTest("test2");

        List<Hello> inside2 = new ArrayList<>();
        Hello insideOne2 = new Hello();
        insideOne2.setHello("insideOne2");
        Hello insideTwo2 = new Hello();
        insideTwo2.setHello("insidetwo2");

        inside2.add(insideOne2);
        inside2.add(insideTwo2);
        JRBeanCollectionDataSource beanCollectionDataSource2 = new JRBeanCollectionDataSource(inside2);
        test2.setSubReport(beanCollectionDataSource2);

        mail.add(test1);
        mail.add(test2);
        return mail;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public JRBeanCollectionDataSource getSubReport() {
        return subReport;
    }

    public void setSubReport(JRBeanCollectionDataSource subReport) {
        this.subReport = subReport;
    }
}
