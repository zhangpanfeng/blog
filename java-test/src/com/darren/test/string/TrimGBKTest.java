package com.darren.test.string;

import java.io.UnsupportedEncodingException;

public class TrimGBKTest {

    public static void main(String[] args) {
        String text = "I Love 丰峰锋";
        // test(text);
        try {
            int len8 = trimGBK(text.getBytes("GBK"), 8);
            int len9 = trimGBK(text.getBytes("GBK"), 9);
            System.out.println("len8 = " + text.substring(0, len8));
            System.out.println("len9 = " + text.substring(0, len9));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    private static int trimGBK(byte[] bytes, int length) {
        boolean isChineseFirstPart = false;
        int n = 0;

        for (int i = 0; i < length; i++) {
            // 注：这里有点不明白，为什么中文转换成byte数组之后的值为负值，而英文字符为正值
            if (bytes[i] < 0 && !isChineseFirstPart) {
                isChineseFirstPart = true;
            } else {
                isChineseFirstPart = false;
                n++;
            }
        }

        return n;
    }

    /**
     * 写这个测试方法只为测试上面不懂的那行代码
     * 
     * @param source
     */
    private static void test(String source) {
        try {
            byte[] byteTest = source.getBytes("GBK");
            int size = byteTest.length;
            for (int i = 0; i < size; i++) {
                System.out.println(byteTest[i]);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

// 运行结果如下：
// len8 = I Love
// len9 = I Love 丰
