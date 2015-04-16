package com.darren.test.sort;

public class ShellSort {

    private int[] source;

    public ShellSort(int[] source) {
        this.source = source;
    }

    public void sort() {
        int arrayLength = source.length;
        int inner;
        int outer;
        int h = 1;
        while (h <= arrayLength / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (outer = h; outer < arrayLength; outer++) {
                int temp = source[outer];
                inner = outer;
                // 注:第二个while有点不好理解，有人也许困惑，用if不久满足了吗，其实不然
                // 理解这个while的办法就是自己在草纸上画一个倒序数组，然后分一分看一看，
                // 当outer逐渐变大时，while条件满足了，会把最后的小值一直替换到这个组的最前端
                while (inner > h - 1 && source[inner - h] >= temp) {
                    source[inner] = source[inner - h];
                    inner = inner - h;
                }

                source[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }

    public void display() {
        for (int item : source) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
