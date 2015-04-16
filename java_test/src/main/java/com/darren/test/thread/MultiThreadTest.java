package com.darren.test.thread;

public class MultiThreadTest {

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        new Thread(new Thread2()).start();

    }

}
