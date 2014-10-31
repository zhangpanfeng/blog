package com.darren.test.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalyzeExpression {
    private static final String REGEX = "([(|)|+|-|*|/])(\\d*)";
    private String expression;
    private List<String> result;
    private java.util.Stack<String> notationStack;

    public AnalyzeExpression(String expression) {
        this.expression = expression.replaceAll(" ", "");
        this.result = new ArrayList<String>();
        this.notationStack = new java.util.Stack<String>();
    }

    /**
     * 把表达式转换成后缀表达式，然后按序号存入集合中
     * 
     * @return
     */
    public List<String> getResult() {
        Matcher matcher = Pattern.compile(REGEX).matcher(expression);
        // 使用正则表达式的分组功能可以直接将符号如数字分离
        while (matcher.find()) {
            if (matcher.group(1).length() > 0) {
                String operator = matcher.group(1);
                // 如果是符号，需要查看满足调教的符号才能加入到集合中
                this.addOperator(operator);
            }
            if (matcher.group(2).length() > 0) {
                String number = matcher.group(2);
                // 如果是数字，直接加入到集合中
                this.result.add(number);
            }
        }

        // 把栈中所有的运算符全部取出，放到结果集中
        while (!notationStack.empty()) {
            String topOperator = notationStack.pop();
            result.add(topOperator);
        }

        return this.result;
    }

    private void addOperator(String operator) {
        if ("+".equals(operator) || "-".equals(operator)) {
            // 若是加减号，和栈中的符号比较运算优先级， 自身优先级设为1
            this.comparePriority(operator, 1);

        } else if ("*".equals(operator) || "/".equals(operator)) {
            // 若是乘除号，和栈中的符号比较运算优先级， 自身优先级设为2
            this.comparePriority(operator, 2);

        } else if ("(".equals(operator)) {
            // 若是左括号，直接放入栈中
            this.notationStack.push(operator);

        } else if (")".equals(operator)) {
            // 若是有括号，则需要找到匹配的左括号
            this.matchLeftParen();

        } else {
            System.out.println("ERROR!");
        }
    }

    /**
     * 比较优先级
     * 
     * @param operator
     *            符号
     * @param priority
     *            优先级
     */
    private void comparePriority(String operator, int priority) {
        while (!notationStack.empty()) {
            String topOperator = notationStack.pop();
            if ("(".equals(topOperator)) {
                // 如果取出来的符号是左括号，那么重新放入栈中，因为只有有括号出现时，才能移除左括号
                notationStack.push(topOperator);
                break;
            } else {
                int newPriority = getPriority(topOperator);
                if (newPriority < priority) {
                    // 如果栈中的运算符的优先级低，那么就把低优先级的运算符重新放回栈中
                    notationStack.push(topOperator);
                    break;
                } else {
                    // 如果栈中的运算符的优先级高，那么就把高优先级的运算符放到结果集中
                    result.add(topOperator);
                }
            }
        }

        notationStack.push(operator);
    }

    private void matchLeftParen() {
        while (!notationStack.empty()) {
            String operator = notationStack.pop();
            if ("(".equals(operator)) {
                // 如果栈顶是左括号，则匹配成功，退出
                break;
            } else {
                // 如果栈顶不是左括号，重新放回栈中
                result.add(operator);
            }
        }
    }

    /**
     * 设定低优先级为1，高优先级为2
     * 
     * @param operator
     *            运算符
     * @return
     */
    private int getPriority(String operator) {
        int priority;
        if ("+".equals(operator) || "-".equals(operator)) {
            priority = 1;
        } else {
            priority = 2;
        }

        return priority;
    }
}
