package com.darren.test.thread;

public class Thread1 implements Runnable {

    @Override
    public void run() {
        synchronized (MultiThreadTest.class) {

            System.out.println("enter thread1...");

            System.out.println("thread1 is waiting");
            try {
                // 释放锁有两种方式，第一种方式是程序自然离开监视器的范围，也就是离开了synchronized关键字管辖的代码范围，另一种方式就是在synchronized关键字管辖的代码内部调用监视器对象的wait方法。这里，使用wait方法释放锁。
                MultiThreadTest.class.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("thread1 is going on...");
            System.out.println("thread1 is being over!");
        }

    }

}
