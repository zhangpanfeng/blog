package com.darren.test.datastructure;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        String text = "(10+20)*30";
        String regex = "([(|)|+|-|*|/])(\\d*)";
        // 在这里发现了一个问题，不知道为什么，如果用+替换*得不到正确的结果
        // 如果有人知道为什么，希望留言赐教
        Matcher m = Pattern.compile(regex).matcher(text);
        while (m.find()) {
            if (m.group(1).length() > 0) {
                System.out.println(m.group(1));
            }
            if (m.group(2).length() > 0) {
                System.out.println(m.group(2));
            }
            System.out.println("test");
        }
    }

}
