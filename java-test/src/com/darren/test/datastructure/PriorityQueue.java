package com.darren.test.datastructure;

/**
 * 队头小队尾大
 * 
 * @author Darren.Zhang
 */
public class PriorityQueue {
    private int maxSize;
    private int[] data;
    private int length;

    public PriorityQueue(int size) {
        this.maxSize = size;
        data = new int[size];
    }

    public void addValue(int value) {
        if (length == maxSize) {
            System.out.println("优先队列已满！");
        } else if (length == 0) {
            data[length++] = value;
        } else {
            int i = length - 1;
            for (; i >= 0; i--) {
                if (value > data[i]) {
                    data[i + 1] = data[i];
                } else {
                    break;
                }
            }
            data[i + 1] = value;
            length++;
        }
    }

    public Integer getValue() {
        Integer value = null;
        if (length == 0) {
            System.out.println("优先队列已空！");
        } else {
            value = data[--length];
        }

        return value;
    }

    public Integer peek() {
        Integer value = null;
        if (length == 0) {
            System.out.println("优先队列已空！");
        } else {
            value = data[length - 1];
        }

        return value;
    }

    public int size() {
        return length;
    }
}
