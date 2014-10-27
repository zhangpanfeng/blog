package com.darren.test.sort;

public class BubbleSortTest {

    public static void main(String[] args) {
        int[] array = new int[] { 3, 5, 9, 8, 6, 4, 3, 1, 8, 7 };

        System.out.print("before sort:");
        print(array);
        System.out.println();

        int size = array.length;
        for (int outer = size - 1; outer >= 0; outer--) {
            for (int inner = 0; inner < outer; inner++) {
                if (array[inner] > array[inner + 1]) {
                    int temp = array[inner + 1];
                    array[inner + 1] = array[inner];
                    array[inner] = temp;
                }
            }
        }

        System.out.print("after sort:");
        print(array);
    }

    private static void print(int[] source) {
        for (Integer data : source) {
            System.out.print(data);
            System.out.print(", ");
        }
    }
}
