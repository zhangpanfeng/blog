package com.darren.test.datastructure;

public class LinkListTest {

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.insert(1);
        linkList.insert(2);
        linkList.insert(3);

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
