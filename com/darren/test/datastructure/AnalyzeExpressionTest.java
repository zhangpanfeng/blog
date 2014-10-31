package com.darren.test.datastructure;

import java.util.List;

public class AnalyzeExpressionTest {

    public static void main(String[] args) {
        String expression = "((1+2)*3+1)*4";
        AnalyzeExpression analyzeExpression = new AnalyzeExpression(expression);
        List<String> expressions = analyzeExpression.getResult();
        System.out.print("后缀表达式：");
        for (String member : expressions) {
            System.out.print(member + " ");
        }
        System.out.println();

        CalculateExpression calculateExpression = new CalculateExpression();
        double result = calculateExpression.calculate(expressions);
        System.out.println("结果为：" + result);
    }

}
