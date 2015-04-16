package com.darren.test.collection;

public class Parent<T> implements Comparable<T> {
    private int age;

    public Parent(int age) {
        this.age = age;
    }

    public int compareTo(T o) {
        System.out.println("method of parent");
        @SuppressWarnings("unchecked")
        Parent<T> o1 = (Parent<T>) o;

        return age > o1.age ? 1 : age < o1.age ? -1 : 0;
    }

}
