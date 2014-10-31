package com.darren.test.datastructure;

import java.util.List;

public class CalculateExpression {
    private static final String REGEX = "\\d*";
    private java.util.Stack<String> numberStack;

    public CalculateExpression() {
        this.numberStack = new java.util.Stack<String>();
    }

    public double calculate(List<String> expressions) {
        double result = 0;
        for (String member : expressions) {
            if (member.matches(REGEX)) {
                // 如果是数字，放到栈中
                numberStack.push(member);
            } else {
                // 如果是运算符，从栈中取出两个数字，进行运算
                // 根据栈的特点，先取出来的数据是后（后-指的是在运算符之后）放进去的
                double num2 = Double.valueOf(numberStack.pop());
                // 根据栈的特点，后取出来的数据是先（先-指的是在运算符之前）放进去的
                double num1 = Double.valueOf(numberStack.pop());
                if ("+".equals(member)) {
                    result = num1 + num2;
                } else if ("-".equals(member)) {
                    result = num1 - num2;
                } else if ("*".equals(member)) {
                    result = num1 * num2;
                } else if ("/".equals(member)) {
                    result = num1 / num2;
                } else {
                    System.out.println("ERROR");
                }

                // 把运算结果放回栈中
                numberStack.push(String.valueOf(result));
            }
        }

        // 从栈中取出运算结果
        result = Double.valueOf(numberStack.pop());

        return result;
    }
}
