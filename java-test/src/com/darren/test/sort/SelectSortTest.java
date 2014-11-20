package com.darren.test.sort;

public class SelectSortTest {

    public static void main(String[] args) {
        int[] array = new int[] { 3, 5, 9, 8, 6, 4, 3, 1, 8, 7 };

        System.out.print("before sort:");
        print(array);
        System.out.println();
        int size = array.length;
        for (int outer = 0; outer < size - 1; outer++) {
            int min = outer;
            for (int inner = outer + 1; inner < size; inner++) {
                if (array[inner] < array[min]) {
                    min = inner;
                }
            }
            int temp = array[outer];
            array[outer] = array[min];
            array[min] = temp;
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
