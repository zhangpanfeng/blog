package com.darren.test.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Vector;

public class VectorTest {

    public static void main(String[] args) {
        Vector<String> vector = new Vector<String>();
        vector.add("aaa");
        vector.add("bbb");
        vector.add("aaa");
        vector.add("ccc");
        System.out.println("原始的数据内容");
        print(vector);
        // 如何去除重复的值，请看下面的两个方法

        System.out.println("遍历去重结果：");
        print(removeDuplicateValue(vector));
        System.out.println("HashSet去重结果：");
        print(removeDuplicateValue2(vector));
    }

    // 方法1，使用遍历的方式去除重复值
    private static Vector<String> removeDuplicateValue(Vector<String> source) {
        Vector<String> newVector = new Vector<String>();
        int size = source.size();
        for (int i = 0; i < size; i++) {
            String value = source.get(i);
            if (!newVector.contains(value)) {
                newVector.add(value);
            }
        }

        return newVector;
    }

    // 方法2，使用HashSet去重的特性来完成要求
    private static Vector<String> removeDuplicateValue1(Vector<String> source) {
        Set<String> set = new HashSet<String>(source);
        Vector<String> newVector = new Vector<String>(set);

        return newVector;
    }

    private static Vector<String> removeDuplicateValue2(Vector<String> source) {
        Set<String> set = new LinkedHashSet<String>(source);
        Vector<String> newVector = new Vector<String>(set);

        return newVector;
    }

    private static void print(Vector<String> source) {
        int size = source.size();
        for (int i = 0; i < size; i++) {
            System.out.println(source.get(i));
        }
    }
}
