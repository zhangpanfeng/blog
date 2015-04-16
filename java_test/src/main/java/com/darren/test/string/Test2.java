package com.darren.test.string;

public class Test2 {
    private static final int SIZE = 100000;

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            public void run() {
                // Test String
                long start = System.currentTimeMillis();
                String string = new String();
                for (int i = 0; i < SIZE; i++) {
                    string = string + i;
                }
                long end = System.currentTimeMillis();
                System.out.println("String spend time == " + (end - start));
            }
        };

        Runnable r2 = new Runnable() {
            public void run() {
                // Test StringBuilder
                long start = System.currentTimeMillis();
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < SIZE; i++) {
                    stringBuilder.append(i);
                }
                long end = System.currentTimeMillis();
                System.out.println("StringBuilder spend time == " + (end - start));
            }
        };

        Runnable r3 = new Runnable() {

            public void run() {
                // Test StringBuffer
                long start = System.currentTimeMillis();
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < SIZE; i++) {
                    stringBuffer.append(i);
                }
                long end = System.currentTimeMillis();
                System.out.println("StringBuffer spend time == " + (end - start));

            }
        };

        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        Thread thread3 = new Thread(r3);
        thread1.start();
        thread2.start();
        thread3.start();

    }

}
