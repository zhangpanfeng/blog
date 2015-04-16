package com.darren.test.sort;

public class QuickSort {
    private int[] source;

    public QuickSort(int[] source) {
        this.source = source;
    }

    public void sort() {
        quickSort(0, source.length - 1);
    }

    public int partition(int left, int right, int pivot) {
        int leftIndex = left - 1;
        int rightIndex = right;
        while (true) {
            // 问题：为什么这个while循环不需要加一个条件(leftIndex < right)
            // 因为pivot在最右边，要想满足(source[++left] < pivot)这个条件，那么(leftIndex < right)一定成立
            while (source[++leftIndex] < pivot) {

            }

            while (rightIndex > 0 && source[--rightIndex] > pivot) {

            }

            if (leftIndex >= rightIndex) {
                break;
            } else {
                swap(leftIndex, rightIndex);
            }
        }
        // 枢纽位置的值和中间点位置交换
        swap(leftIndex, right);

        return leftIndex;
    }

    public void display() {
        for (int item : source) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private void quickSort(int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            // 把最右边的点作为枢纽点
            int pivot = source[right];
            int partition = partition(left, right, pivot);
            quickSort(left, partition - 1);
            quickSort(partition + 1, right);
            // 疑问：为什么不包含partition点，因为这个点在方法partition（）中被用作交换点，和最后一个点交换
            // 可变相的认为这个点也在右边的数组中
        }
    }

    private void swap(int left, int right) {
        int temp = source[left];
        source[left] = source[right];
        source[right] = temp;
    }
}
