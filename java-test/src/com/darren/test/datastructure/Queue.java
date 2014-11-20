package com.darren.test.datastructure;

/**
 * 此队列为循环队列。 不设标志位，少使用一个存储空间，约定队头指针在队尾指针的下一位时作为满状态。此时如果队头指针和队尾指针相等，作为空状态。
 * 
 * @author Darren.Zhang
 */
public class Queue {

    private int maxSize;
    private int[] data;
    private int front;
    private int end;

    public Queue(int size) {
        this.maxSize = size;
        data = new int[size];
    }

    /**
     * 添加数据，并移动指针
     * 
     * @param value
     */
    public void addValue(int value) {
        if ((end + 1) % maxSize == front) {
            System.out.println("队列已满！");
        } else {
            data[end] = value;
            // 指针后移一位
            end = (end + 1) % maxSize;
        }
    }

    /**
     * 取出数据，并移动指针
     * 
     * @return
     */
    public Integer getValue() {
        Integer value = null;
        if (front == end) {
            System.out.println("队列已空！");
        } else {
            value = data[front];
            // 指针后移一位
            front = (front + 1) % maxSize;
        }

        return value;
    }

    /**
     * 查看数据，不移动指针
     * 
     * @return
     */
    public Integer peek() {
        Integer value = null;
        if (front == end) {
            System.out.println("队列已空！");
        } else {
            value = data[front];
        }

        return value;
    }

    /**
     * 计算队列大小
     * 
     * @return
     */

    public int size() {
        int size = (end - front + maxSize) % maxSize;

        return size;
    }
}
