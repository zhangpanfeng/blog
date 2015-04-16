package com.darren.test.sort;

public class MergeSortTest {

    public static void main(String[] args) {
        int[] source = new int[] { 5, 8, 1, 3, 7, 9, 5, 8, 1, 3, 7, 9, 5, 8, 1, 3, 7, 9, 5, 8, 1, 3, 7, 9, 5, 8, 1, 3,
                7, 9 };
        MergeSort mergeSort = new MergeSort(source);
        System.out.println("排序之前！");
        mergeSort.display();
        mergeSort.sort();
        System.out.println("排序之后！");
        mergeSort.display();
    }
}
