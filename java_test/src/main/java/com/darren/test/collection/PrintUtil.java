package com.darren.test.collection;

import java.text.NumberFormat;

public class PrintUtil {

    public static void printRunTime(long start, long end) {
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.out.println("| Total Time:");
        long millisecond = end - start;
        System.out.println("| 毫秒 ：" + millisecond);
        double second = millisecond / 1000;
        System.out.println("| 秒     ：" + format(second));
        double minutes = second / 60;
        System.out.println("| 分钟 ：" + format(minutes));
        double hour = minutes / 60;
        System.out.println("| 小时 ：" + format(hour));
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
    }

    private static String format(double source) {
        NumberFormat formater = NumberFormat.getNumberInstance();
        formater.setMinimumFractionDigits(3);
        String result = formater.format(source);

        return result;

    }
}
