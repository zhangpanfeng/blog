package com.darren.test.datastructure;

/**
 * 链表节点
 * 
 * @author Darren.Zhang
 */
public class Link {
    private int value;
    private Link next;

    public Link(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

}
