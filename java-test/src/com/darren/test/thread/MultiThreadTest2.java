package com.darren.test.thread;

public class MultiThreadTest2 {
    private static int i = 0;

    public static void main(String[] args) {
        Runnable addRunnable = new Runnable() {

            @Override
            public void run() {
                for (int j = 0; j < 20; j++) {
                    i++;
                    System.out.println("i + 1==" + i);
                }

            }
        };

        Runnable subtractRunnable = new Runnable() {

            @Override
            public void run() {
                for (int j = 0; j < 20; j++) {
                    i--;
                    System.out.println("i - 1==" + i);
                }

            }
        };

        Thread thread1 = new Thread(addRunnable);
        thread1.start();
        Thread thread2 = new Thread(addRunnable);
        // thread2.start();

        Thread thread3 = new Thread(subtractRunnable);
        thread3.start();
        Thread thread4 = new Thread(subtractRunnable);
        // thread4.start();
    }

}
