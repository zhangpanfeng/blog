package com.darren.test.sort;

public class ShellSortTest {

    public static void main(String[] args) {
        int[] source = new int[] { 10, 8, 5, 9, 7, 6, 3, 1, 4, 2 };
        ShellSort shellSort = new ShellSort(source);
        System.out.println("排序前！");
        shellSort.display();

        shellSort.sort();
        System.out.println("排序后！");
        shellSort.display();

    }

}
