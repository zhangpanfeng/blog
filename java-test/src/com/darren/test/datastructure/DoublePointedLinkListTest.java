package com.darren.test.datastructure;

public class DoublePointedLinkListTest {

    public static void main(String[] args) {
        DoublePointedLinkList linkList = new DoublePointedLinkList();
        // linkList.insertFirst(1);
        // linkList.insertFirst(2);
        linkList.insertLast(1);
        linkList.insertLast(2);
        linkList.insertLast(3);
        linkList.insertLast(4);

        System.out.println("删除之前");
        linkList.display();

        Link deletedLink = linkList.deleteFirst();

        if (deletedLink != null) {
            System.out.println("被删掉的节点：" + deletedLink.getValue());
        }

        System.out.println("删除之后");
        linkList.display();

        linkList.deleteFirst();
        linkList.deleteFirst();
        linkList.deleteFirst();

        linkList.display();
    }

}
