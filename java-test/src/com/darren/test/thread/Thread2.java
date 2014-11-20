package com.darren.test.thread;

public class Thread2 implements Runnable {

    @Override
    public void run() {
        synchronized (MultiThreadTest.class) {

            System.out.println("enter thread2...");

            System.out.println("thread2 notify other thread can release wait status..");
            // 由于notify方法并不释放锁， 即使thread2调用下面的sleep方法休息了10毫秒，但thread1仍然不会执行，因为thread2没有释放锁，所以Thread1无法得不到锁。

            MultiThreadTest.class.notify();

            System.out.println("thread2 is sleeping ten millisecond...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("thread2 is going on...");
            System.out.println("thread2 is being over!");

        }

    }

}
