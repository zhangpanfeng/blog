package com.darren.test.collection;

public class Child<T> extends Parent<T> {

    public Child() {
        super(3);
    }

    public int compareTo(T o) {

        // TODO Auto-generated method stub
        System.out.println("method of child");
        // Child o1 = (Child)o;
        return 1;

    }
}
