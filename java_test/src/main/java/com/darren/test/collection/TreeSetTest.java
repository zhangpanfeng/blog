package com.darren.test.collection;

import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeSet<Parent<Integer>> set = new TreeSet<Parent<Integer>>();
        set.add(new Parent<Integer>(3));
        set.add(new Child<Integer>());
        set.add(new Parent<Integer>(4));
        System.out.println(set.size());
    }

}
