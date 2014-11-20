package com.darren.test.datastructure;

public class StackTest {

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(0);

        // test1(stack);
        // test2(stack);
        test3(stack);

    }

    /**
     * 测试方式一
     * 
     * @param stack
     */
    private static void test1(Stack stack) {
        System.out.println("测试方式一");
        while (true) {
            Integer value = stack.pop();
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
     * @param stack
     */
    private static void test2(Stack stack) {
        System.out.println("测试方式二");
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 测试方式三
     * 
     * @param stack
     */
    private static void test3(Stack stack) {
        System.out.println("测试方式三");
        while (stack.peek() != null) {
            System.out.println(stack.pop());
        }
    }
}
