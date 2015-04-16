package com.darren.test.recursion;

import java.text.NumberFormat;
import java.util.Stack;

public class HanoiTower {

    private Stack<Integer> toStack;
    private int num;
    private int steps;

    public HanoiTower(int num) {
        this.num = num;
        toStack = new Stack<Integer>();
    }

    public void showSteps() {
        long start = System.currentTimeMillis();
        doTowers(num, 'A', 'B', 'C');
        long end = System.currentTimeMillis();
        System.out.println();
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
        System.out.println();
        System.out.println("Total steps: " + steps);
    }

    public void displayNewTower() {
        int size = toStack.size();
        System.out.println();
        System.out.print("New Tower: ");
        for (int i = 0; i < size; i++) {
            System.out.print(toStack.pop() + " ");
        }
    }

    private void doTowers(int topNum, char from, char middle, char to) {
        if (topNum == 1) {
            System.out.println("Disk 1 from " + from + " to " + to);
            steps++;
            if (to == 'C') {
                toStack.push(1);
            }
            if (from == 'C') {
                toStack.pop();
            }
        } else {
            // 从第一个柱子移动到中间的柱子
            doTowers(topNum - 1, from, to, middle);
            System.out.println("Disk " + topNum + " from " + from + " to " + to);
            steps++;
            if (to == 'C') {
                toStack.push(topNum);
            }
            if (from == 'C') {
                toStack.pop();
            }
            // 从中间的柱子移动到最后的柱子
            doTowers(topNum - 1, middle, from, to);
        }
    }

    private String format(double source) {
        NumberFormat formater = NumberFormat.getNumberInstance();
        formater.setMinimumFractionDigits(3);
        String result = formater.format(source);

        return result;

    }
}
