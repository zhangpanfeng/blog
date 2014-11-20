package com.darren.test.sort;

import com.darren.test.collection.PrintUtil;

public class MergeSort {
    private int[] source;

    public MergeSort(int[] source) {
        this.source = source;
    }

    public void sort() {
        long start = System.currentTimeMillis();
        int[] workspace = new int[source.length];
        recurisonMergeSort(workspace, 0, source.length - 1);
        long end = System.currentTimeMillis();
        PrintUtil.printRunTime(start, end);
    }

    public void display() {
        for (int value : source) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private void recurisonMergeSort(int[] workspace, int start, int end) {
        if (start == end) {
            // 如果数组中只有一个元素，不用排序直接退出
            // 或者数组只剩一个元素。递归开始返回
            return;
        } else {
            // 找到数组的中间位置
            int mid = (start + end) / 2;
            // 对左半部分进行排序
            recurisonMergeSort(workspace, start, mid);
            // 对右半部分进行排序
            recurisonMergeSort(workspace, mid + 1, end);
            // 合并左右两部分
            merge(workspace, start, mid + 1, end);

        }
    }

    private void merge(int[] workspace, int leftStart, int rightStart, int end) {
        int i = 0;
        int start = leftStart;
        int mid = rightStart - 1;
        int n = end - start + 1;

        while (leftStart <= mid && rightStart <= end) {
            if (source[leftStart] < source[rightStart]) {
                workspace[i++] = source[leftStart++];
            } else {
                workspace[i++] = source[rightStart++];
            }
        }

        while (leftStart <= mid) {
            workspace[i++] = source[leftStart++];
        }

        while (rightStart <= end) {
            workspace[i++] = source[rightStart++];
        }

        for (i = 0; i < n; i++) {
            source[start + i] = workspace[i];
        }
    }
}
