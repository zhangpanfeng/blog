package com.darren.test.search;

public class SequentialSearchTest {

    public static void main(String[] args) {
        int[] array = new int[] { 3, 5, 9, 8, 6, 4, 3, 1, 8, 7 };

        int index = search(array, 3);
        System.out.println("index = " + index);
    }

    private static int search(int[] array, int value) {

        int size = array.length;
        int i = size - 1;
        for (; array[i] != value; i--) {
            if (i == 0) {
                break;
            }
        }

        return i;
    }
}
