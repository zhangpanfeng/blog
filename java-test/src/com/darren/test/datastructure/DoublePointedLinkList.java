package com.darren.test.datastructure;

/**
 * 双端链表可以作为队列的数据结构，它比普通单链表的优势在于可以方便的插入数据到链表结尾，这样就方便实现对列对数据结构的要求（队尾插入对头删除）
 * 
 * @author Darren.Zhang
 */
public class DoublePointedLinkList {

    private Link head;
    private Link tail;

    public DoublePointedLinkList() {

    }

    public void insertFirst(int value) {
        Link link = new Link(value);
        if (head == null) {
            head = link;
            tail = link;
        } else {
            link.setNext(head);
            head = link;
        }
    }

    public void insertLast(int value) {
        Link link = new Link(value);
        if (head == null) {
            head = link;
            tail = link;
        } else {
            tail.setNext(link);
            tail = link;
        }
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public Link deleteFirst() {
        Link deletedLink = head;
        if (head == null) {
            System.out.println("链表已空！");
        } else {
            head = head.getNext();
        }

        return deletedLink;
    }

    public void display() {
        Link current = head;
        while (current != null) {
            System.out.println("value = " + current.getValue());
            current = current.getNext();
        }
    }
}
