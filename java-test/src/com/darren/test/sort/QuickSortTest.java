package com.darren.test.sort;

public class QuickSortTest {

    public static void main(String[] args) {
        int[] source = new int[] { 7, 7, 7, 8, 9, 9, 7 };
        QuickSort quickSort = new QuickSort(source);

        System.out.println("排序前！");
        quickSort.display();

        quickSort.sort();
        System.out.println("排序后！");
        quickSort.display();
    }

}
