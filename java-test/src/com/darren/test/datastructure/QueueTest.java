package com.darren.test.datastructure;

public class QueueTest {

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.addValue(5);
        queue.addValue(4);
        queue.addValue(3);
        queue.addValue(2);
        queue.addValue(1);

        // test1(queue);
        // test2(queue);
        test3(queue);
    }

    /**
     * 测试方式一
     * 
     * @param queue
     */
    private static void test1(Queue queue) {
        System.out.println("测试方式一");
        while (true) {
            Integer value = queue.getValue();
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
     * @param queue
     */
    private static void test2(Queue queue) {
        System.out.println("测试方式二");
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(queue.getValue());
        }
    }

    /**
     * 测试方式三
     * 
     * @param queue
     */
    private static void test3(Queue queue) {
        System.out.println("测试方式三");
        while (queue.peek() != null) {
            System.out.println(queue.getValue());
        }
    }
}
