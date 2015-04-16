package com.darren.test.sort;

public class SelectSortTest {

    public static void main(String[] args) {
        int[] source = new int[] { 3, 5, 9, 8, 6, 4, 3, 1, 8, 7 };

        System.out.print("before sort:");
        print(source);
        System.out.println();
        int size = source.length;
        for (int outer = 0; outer < size - 1; outer++) {
            // 设置参照物为最左边元素
            int min = outer;
            for (int inner = outer + 1; inner < size; inner++) {
                if (source[inner] < source[min]) {
                    // 更新参照物
                    min = inner;
                }
            }
            // 交换最小值和最左边值
            int temp = source[outer];
            source[outer] = source[min];
            source[min] = temp;
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
