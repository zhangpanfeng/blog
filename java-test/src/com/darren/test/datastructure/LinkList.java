package com.darren.test.datastructure;

public class LinkList {

    private Link head;

    public LinkList() {

    }

    public void insert(int value) {
        Link link = new Link(value);
        if (head == null) {
            head = link;
        } else {
            link.setNext(head);
            head = link;
        }
    }

    public Link find(int key) {
        Link current = head;
        while (current != null) {
            if (current.getValue() == key) {
                break;
            } else {
                current = current.getNext();
            }
        }

        return current;
    }

    public Link delete(int key) {
        Link current = head;
        Link previoud = head;
        while (current != null) {
            if (current.getValue() == key) {
                if (current == head) {
                    head = current.getNext();
                } else {
                    previoud.setNext(current.getNext());
                }

                break;
            } else {
                previoud = current;
                current = current.getNext();
            }
        }

        return current;
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
}
