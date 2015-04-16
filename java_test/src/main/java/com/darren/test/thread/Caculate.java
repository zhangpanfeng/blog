package com.darren.test.thread;

public class Caculate {
    private int i = 0;

    public synchronized void subtract() {
        i--;
        System.out.println("i - 1==" + i);
    }

    public synchronized void add() {
        i++;
        System.out.println("i + 1==" + i);
    }
}
