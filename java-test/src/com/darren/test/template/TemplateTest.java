package com.darren.test.template;

public class TemplateTest {

    public static void main(String[] args) {
        SubTemplate1 t1 = new SubTemplate1();
        SubTemplate2 t2 = new SubTemplate2();
        System.out.println("t1 == " + t1.getMoney());
        System.out.println("t2 == " + t2.getMoney());
    }

}
