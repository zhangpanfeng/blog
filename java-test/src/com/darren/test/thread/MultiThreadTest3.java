package com.darren.test.thread;

public class MultiThreadTest3 {
    private static Caculate caculate;

    public static void main(String[] args) {
        caculate = new Caculate();

        Runnable addRunnable = new Runnable() {

            @Override
            public void run() {
                for (int j = 0; j < 20; j++) {
                    caculate.add();
                    // try {
                    // Thread.sleep(1000);
                    // } catch (InterruptedException e) {
                    // e.printStackTrace();
                    // }
                }

            }
        };

        Runnable subtractRunnable = new Runnable() {

            @Override
            public void run() {
                for (int j = 0; j < 20; j++) {
                    caculate.subtract();
                    // try {
                    // Thread.sleep(1000);
                    // } catch (InterruptedException e) {
                    // e.printStackTrace();
                    // }
                }

            }
        };

        Thread addThread = new Thread(addRunnable);
        addThread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread subtractThread = new Thread(subtractRunnable);
        subtractThread.start();
    }
}
