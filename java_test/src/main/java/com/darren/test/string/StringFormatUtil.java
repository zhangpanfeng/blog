package com.darren.test.string;

import java.text.DecimalFormat;

public class StringFormatUtil {
    /**
     * 格式化数字返回字符串
     * 
     * @param number
     * @return 字符串
     */
    public static String stringFormat(int number) {
        // 返回以0开头的长度为三的字符串，如果数据源的长度超过三，则按元数据显示
        String stringNumber = String.format("%03d", number);
        System.out.println(stringNumber);

        return stringNumber;

    }

    /**
     * 格式化数字返回字符串
     * 
     * @param number
     * @return 字符串
     */
    public static String numberFormat(int number) {
        // 三个0表示生成的字符串的位数是三，如果不满三位前补零，如果大于三位，按原格式显示
        DecimalFormat decimalFormat = new DecimalFormat("000");
        String numString = decimalFormat.format(number);
        System.out.println(numString);
        return numString;
    }
}
