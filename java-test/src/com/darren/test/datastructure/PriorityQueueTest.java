package com.darren.test.datastructure;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.addValue(4);
        priorityQueue.addValue(5);
        priorityQueue.addValue(3);
        priorityQueue.addValue(1);
        priorityQueue.addValue(2);
        priorityQueue.addValue(0);

        // test1(priorityQueue);
        // test2(priorityQueue);
        test3(priorityQueue);

    }

    /**
     * 测试方式一
     * 
     * @param priorityQueue
     */
    private static void test1(PriorityQueue priorityQueue) {
        System.out.println("测试方式一");
        while (true) {
            Integer value = priorityQueue.getValue();
            if (value != null) {
                System.out.println(value);
            } else {
                break;
            }
        }
    }

    /**
     * 测试方式二
     * 
     * @param priorityQueue
     */
    private static void test2(PriorityQueue priorityQueue) {
        System.out.println("测试方式二");
        int size = priorityQueue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(priorityQueue.getValue());
        }
    }

    /**
     * 测试方式三
     * 
     * @param priorityQueue
     */
    private static void test3(PriorityQueue priorityQueue) {
        System.out.println("测试方式三");
        while (priorityQueue.peek() != null) {
            System.out.println(priorityQueue.getValue());
        }
    }
}
