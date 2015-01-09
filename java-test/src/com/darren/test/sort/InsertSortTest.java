package com.darren.test.sort;

public class InsertSortTest {

    public static void main(String[] args) {
        int[] source = new int[] { 3, 5, 9, 8, 6, 4, 3, 1, 8, 7 };

        System.out.print("before sort:");
        print(source);
        System.out.println();
        int size = source.length;
        for (int outer = 1; outer < size; outer++) {
            int sentinel = source[outer];
            // for (int inner = outer - 1; sentinel < array[inner]; inner--) {
            // array[inner + 1] = array[inner];
            // array[inner] = sentinel;
            // if (inner == 0) {
            // break;
            // }
            // }
            for (int inner = outer - 1; inner >= 0; inner--) {
                if (source[inner] > source[inner + 1]) {
                    source[inner + 1] = source[inner];
                    source[inner] = sentinel;
                }
            }
        }
        System.out.print("after sort:");
        print(source);
    }

    private static void print(int[] source) {
        for (Integer data : source) {
            System.out.print(data);
            System.out.print(", ");
        }
    }

}
