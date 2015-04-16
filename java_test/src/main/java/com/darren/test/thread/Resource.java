package com.darren.test.thread;

public class Resource {
    private static final int MAX_SPACE = 10;
    private static final int MIN_SPACE = 0;
    private int space = 0;

    public synchronized void produce() {
        if (space < MAX_SPACE) {
            space++;
            // 生产过后，立即通知消费线程可以消费
            notify();
        } else {
            // 如果存储空间已满，那么停止生产，让出锁，等待消费线程消费
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void consume() {
        if (space > MIN_SPACE) {
            space--;
            // 消费过后，立即通知生产线程可以生产
            notify();
        } else {
            // 如果全部消费完，那么停止消费，让出锁，等待生产线程生产
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getSpace() {
        return space;
    }

}
