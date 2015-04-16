package com.darren.test.getclass;

public class Son extends Parent {

    public String testGetClass() {
        return super.getClass().getName();
    }
}
