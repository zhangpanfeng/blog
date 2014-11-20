package com.darren.test.datastructure;

public class Stack {
    private int[] data;
    private int top;
    private int maxSize;

    public Stack(int size) {
        this.maxSize = size;
        data = new int[size];
    }

    /**
     * 添加数据，并移动指针
     * 
     * @param value
     */
    public void push(int value) {
        if (top == maxSize) {
            System.out.println("栈已满！");
        } else {
            data[top] = value;
            top++;
        }
    }

    /**
     * 取出数据，并移动指针
     * 
     * @return
     */
    public Integer pop() {
        Integer value = null;
        if (top == 0) {
            System.out.println("栈已空！");
        } else {
            top--;
            value = data[top];
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
        if (top == 0) {
            System.out.println("栈已空！");
        } else {
            int key = top - 1;
            value = data[key];
        }

        return value;
    }

    public int size() {
        int size = data.length;

        return size;
    }
}
