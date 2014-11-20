package com.darren.test.thread;

public class StartThread extends Thread {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        String name = t.getName();
        System.out.println("Thread name is: " + name);
    }

    public static void main(String[] args) {
        StartThread thread = new StartThread();
        thread.start();
        System.out.println("===");
        thread.run();
        System.out.println("===");
    }
}
