package com.darren.test.overide;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

    public static void main(String[] args) {
        String a = new String("A");
        String b = new String("A");

        CustomString c = new CustomString("B");
        CustomString d = new CustomString("B");

        System.out.println("a.equals(b) == " + a.equals(b));
        System.out.println("c.equals(d) == " + c.equals(d));

        Set<Object> set = new HashSet<Object>();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);

        System.out.println("set.size() == " + set.size());

        for (Object object : set) {
            System.out.println(object);
        }
    }

}
