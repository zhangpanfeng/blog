package com.darren.test.datastructure;

/**
 * 单链表-有序链表
 * 
 * @author Darren.Zhang
 */
public class SortedLinkList {
    private Link head;

    public SortedLinkList() {

    }

    public void insert(int value) {
        Link link = new Link(value);
        if (head == null) {
            head = link;
        } else {
            // insertMethod1(link, value);
            insertMethod2(link, value);
        }
    }

    public Link deleteFirst() {
        Link deletedLink = head;
        if (head == null) {
            System.out.println("有序链表已空！");
        } else {
            head = head.getNext();
        }

        return deletedLink;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void display() {
        Link current = head;
        while (current != null) {
            System.out.println("value = " + current.getValue());
            current = current.getNext();
        }
    }

    /**
     * 方法一比方法二多最后一个判断，是因为方法二关于current == null的情况不需要判断，因为如果到了链表的最后一个结点link.setNext(current);便是link.setNext(null);成立
     * 
     * @param link
     * @param value
     */

    private void insertMethod1(Link link, int value) {
        Link current = head;
        Link previous = null;
        while (current != null) {
            if (current.getValue() >= value) {
                if (previous == null) {
                    head = link;
                } else {
                    previous.setNext(link);
                }
                link.setNext(current);

                break;
            } else {
                previous = current;
                current = current.getNext();
            }
        }

        if (current == null) {
            previous.setNext(link);
        }
    }

    /**
     * 个人觉得方法二的难度要高于方法一，方法一属于正常思维， 一步一步来，能写出方法一，而方法二需要再抽象， 它里边的临界条件刚好处于某种情况下成立，所以不好把握
     * 
     * @param link
     * @param value
     */
    private void insertMethod2(Link link, int value) {
        Link current = head;
        Link previous = null;
        while (current != null && value > current.getValue()) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            head = link;
        } else {
            previous.setNext(link);
        }
        link.setNext(current);
    }
}
