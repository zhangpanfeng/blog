package com.darren.test.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrimRegexTest {

    public static void main(String[] args) {
        String text = "Hello丰峰锋I喜欢Your第10篇Blog";
        // 看到这道题首先要想到使用正则表达式来做，如果用for循环就太麻烦了

        // 英文组合
        Pattern enp = Pattern.compile("[a-zA-Z]+");
        Matcher enm = enp.matcher(text);
        System.out.println("英文分段：");
        while (enm.find()) {
            System.out.println(enm.group());
        }

        System.out.println("===============");
        System.out.println();
        // 中文组合
        Pattern cnp = Pattern.compile("[\u4E00-\u9FA5]+");
        Matcher cnm = cnp.matcher(text);
        System.out.println("中文分段：");
        while (cnm.find()) {
            System.out.println(cnm.group());
        }

        System.out.println("===============");
        System.out.println();
        // 数字组合
        Pattern nup = Pattern.compile("[\\d]+");
        Matcher num = nup.matcher(text);
        System.out.println("数字分段：");
        while (num.find()) {
            System.out.println(num.group());
        }
        System.out.println("===============");
        System.out.println();
        // 总结之后使用正则表达式强大的分组模式
        // String regex = "(\\p{Alpha}*)([\\u4e00-\\u9fa5]*)(\\d*)";

        // 我们用以的简单的正则表达式
        String regex = "([a-zA-Z]*)([\u4e00-\u9fa5]*)(\\d*)";
        // 在这里发现了一个问题，不知道为什么，如果用+替换*得不到正确的结果
        // 如果有人知道为什么，希望留言赐教
        Matcher m = Pattern.compile(regex).matcher(text);
        while (m.find()) {
            if (m.group(1).length() > 0)
                System.out.println(m.group(1));
            if (m.group(2).length() > 0)
                System.out.println(m.group(2));
            if (m.group(3).length() > 0)
                System.out.println(m.group(3));
        }

        // 当然如果要你统计中文，英文，和数字字符的个数，就会简单很多
        System.out.println("===============");
        System.out.println();
        statistics(text);
    }

    private static void statistics(String source) {
        int nuNum = 0;
        int enNum = 0;
        int cnNum = 0;
        int size = source.length();
        for (int i = 0; i < size; i++) {
            char c = source.charAt(i);
            // 注：第一个if的逻辑不要写错了，很容易写成if (c >= 0 && c <= 9)
            if (c >= '0' && c <= '9') {
                nuNum++;
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                enNum++;
            } else {
                cnNum++;
            }
        }

        System.out.println("数字个数：= " + nuNum);
        System.out.println("英文个数：= " + enNum);
        System.out.println("中文个数：= " + cnNum);
    }
}
// 注：其实这道题并不难，难点在于好多人最正则表达式很陌生，学习了之后如果长时间没有使用到，就会忘记规则

