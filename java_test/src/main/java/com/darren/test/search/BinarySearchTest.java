package com.darren.test.search;

public class BinarySearchTest {

    public static void main(String[] args) {
        int[] array = new int[] { 1, 3, 5, 7, 8, 10, 12 };
        int result = search(array, 7);
        System.out.println("result : " + result);

        int result2 = search(array, 9, 0, array.length - 1);
        System.out.println("result2 : " + result2);

    }

    /**
     * 循环查找
     * 
     * @param source
     * @param key
     * @return
     */
    private static int search(int[] source, int key) {
        int result = -1;
        int low = 0;
        int high = source.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (key == source[mid]) {
                result = mid;
                break;
            } else if (key < source[mid]) {
                high = mid - 1;
                mid = (low + high) / 2;
            } else {
                low = mid + 1;
                mid = (low + high) / 2;
            }
        }

        return result;
    }

    private static int search(int[] source, int key, int start, int end) {
        int mid = (start + end) / 2;
        if (start > end) {
            return -1;
        } else {
            if (key == source[mid]) {
                return mid;
            } else if (key < source[mid]) {
                return search(source, key, start, mid - 1);
            } else {
                return search(source, key, mid + 1, end);
            }
        }

    }
}
