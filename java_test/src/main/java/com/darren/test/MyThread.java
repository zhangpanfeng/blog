package com.darren.test;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.getName() + "正在执行。。。");
    }
}
