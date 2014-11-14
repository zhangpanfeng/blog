package com.darren.test.datastructure;

public class DoubleDirectionLinkListTest {

    public static void main(String[] args) {
        DoubleDirectionLinkList linkList = new DoubleDirectionLinkList();
        linkList.insertFirst(5);
        linkList.insertFirst(3);
        linkList.insertFirst(1);
        linkList.insertAfter(1, 2);
        linkList.insertAfter(3, 4);

        System.out.println("删除之前");
        linkList.display();

        DoubleDirectionLink deletedLink = linkList.deleteFirst();
        if (deletedLink != null) {
            System.out.println("被删掉的节点：" + deletedLink.getValue());
        }

        System.out.println("第一次删除之后");
        linkList.display();

        DoubleDirectionLink deletedLink2 = linkList.delete(3);
        if (deletedLink2 != null) {
            System.out.println("被删掉的节点：" + deletedLink2.getValue());
        }

        System.out.println("第二次删除之后");
        linkList.display();
    }

}
