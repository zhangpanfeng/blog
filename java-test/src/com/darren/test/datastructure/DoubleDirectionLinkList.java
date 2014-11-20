package com.darren.test.datastructure;

/**
 * 此链表为双向链表，并非双端链表，因此没有insertLast()方法
 * 
 * @author Darren.Zhang
 */
public class DoubleDirectionLinkList {
    private DoubleDirectionLink head;

    public DoubleDirectionLinkList() {

    }

    public void insertFirst(int value) {
        DoubleDirectionLink link = new DoubleDirectionLink(value);
        if (head == null) {
            head = link;
        } else {
            link.setNext(head);
            head.setPrevious(link);
            head = link;
        }
    }

    public void insertAfter(int keyValue, int value) {
        DoubleDirectionLink link = new DoubleDirectionLink(value);
        if (head == null) {
            System.out.println("双向链表为空，你要查找的结点不存在！");
        } else {
            DoubleDirectionLink current = head;
            while (current != null) {
                if (current.getValue() == keyValue) {
                    if (current.getNext() != null) {
                        // 还没到最后一个结点
                        link.setNext(current.getNext());
                        current.getNext().setPrevious(link);
                        current.setNext(link);
                        link.setPrevious(current);
                    } else {
                        // 到最后一个结点
                        current.setNext(link);
                        link.setPrevious(current);
                    }
                    break;
                } else {
                    current = current.getNext();
                }
            }

            if (current == null) {
                System.out.println("你要查找的结点不存在！");
            }
        }
    }

    public DoubleDirectionLink deleteFirst() {
        DoubleDirectionLink deletedLink = head;
        if (head == null) {
            System.out.println("双向链表已空！");
        } else {
            head = head.getNext();
        }

        return deletedLink;
    }

    public DoubleDirectionLink delete(int keyValue) {
        DoubleDirectionLink deletedLink = head;
        if (head == null) {
            System.out.println("双向链表已空！");
        } else {
            DoubleDirectionLink current = head;
            while (current != null) {
                if (current.getValue() == keyValue) {
                    if (current.getNext() != null) {
                        // 还没到最后一个结点
                        current.getPrevious().setNext(current.getNext());
                        current.getNext().setPrevious(current.getPrevious());
                    } else {
                        // 到最后一个结点
                        current.getPrevious().setNext(null);
                        current.setPrevious(null);
                    }
                    deletedLink = current;
                    break;
                } else {
                    current = current.getNext();
                }
            }

            if (current == null) {
                System.out.println("你要查找的结点不存在！");
            }
        }

        return deletedLink;
    }

    public void display() {
        DoubleDirectionLink current = head;
        while (current != null) {
            System.out.println("value = " + current.getValue());
            current = current.getNext();
        }
    }
}
