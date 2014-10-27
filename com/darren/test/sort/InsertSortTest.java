package com.darren.test.sort;

public class InsertSortTest {

    public static void main(String[] args) {
        int[] array = new int[] { 3, 5, 9, 8, 6, 4, 3, 1, 8, 7 };

        System.out.print("before sort:");
        print(array);
        System.out.println();
        int size = array.length;
        for (int i = 1; i < size; i++) {
            int sentinel = array[i];
            for (int j = i - 1; sentinel < array[j]; j--) {
                array[j + 1] = array[j];
                array[j] = sentinel;
                if (j == 0) {
                    break;
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
