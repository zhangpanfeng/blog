package com.darren.test.string;

public class Test {
    private static final int SIZE = 100000;

    public static void main(String[] args) {
        // Test String
        long start = System.currentTimeMillis();
        String string = new String();
        for (int i = 0; i < SIZE; i++) {
            string = string + i;
        }
        long end = System.currentTimeMillis();
        System.out.println("String spend time == " + (end - start));

        // Test StringBuilder
        start = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            stringBuilder.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder spend time == " + (end - start));

        // Test StringBuffer
        start = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < SIZE; i++) {
            stringBuffer.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer spend time == " + (end - start));
    }

}
