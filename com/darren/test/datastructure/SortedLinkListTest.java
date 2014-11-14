package com.darren.test.datastructure;

public class SortedLinkListTest {

    public static void main(String[] args) {
        SortedLinkList linkList = new SortedLinkList();
        linkList.insert(5);
        linkList.insert(1);
        linkList.insert(4);
        linkList.insert(2);
        linkList.insert(3);
        linkList.insert(6);

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

        System.out.println("删除之后");
        linkList.display();
    }

}
