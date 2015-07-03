package com.darren.test.thread;

public class ProducerConsumer {
    public static void main(String[] args) {
        SyncStack ss = new SyncStack();
        Producer p1 = new Producer(ss, 1);
        Producer p2 = new Producer(ss, 2);
        Producer p3 = new Producer(ss, 3);
        Consumer c = new Consumer(ss);
        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(p3).start();
        new Thread(c).start();
        new Thread(c).start();
    }
}

/**
 * 定义一个WoTou类 ，在类中有id以标记是哪个窝头，重写了toString方法
 */
class WoTou {
    /**
     * 窝头ID
     */
    private int id;
    /**
     * 生产者ID
     */
    private int producerId;

    WoTou(int id, int producerId) {
        this.id = id;
        this.producerId = producerId;
    }

    @Override
    public String toString() {
        return "WoTou [窝头ID=" + id + ", 生产者ID=" + producerId + "]";
    }
}

/**
 * 定义一个篮子的对象，用于装WoTou
 * 
 * push方法，用于装WoTou
 * 
 * pop方法，用于吃WoTou
 */
class SyncStack {
    private int index = 0;
    private WoTou[] arrWT = new WoTou[6];

    /**
     * wait()只有在锁定（synchronized）的时候才能使用
     */

    // push用于装WoTou，当WoTou数达到6时wait()休息
    public synchronized void push(WoTou wt) {
        while (index == arrWT.length) {
            try {
                System.out.println("等待消费！");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 唤醒wait()
        this.notifyAll();
        arrWT[index] = wt;
        index++;
    }

    // pop用于吃WoTou，当WoTou数为0时wait（）
    public synchronized WoTou pop() {
        while (index == 0) {
            try {
                System.out.println("等待生产！");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        index--;
        return arrWT[index];
    }
}

/**
 * 实现Runnable接口，实现run方法的Producer类，一个对象只生产20个WoTou
 */
class Producer implements Runnable {
    /**
     * 生产者ID
     */
    private int id;
    private SyncStack ss = null;

    Producer(SyncStack ss, int id) {
        this.ss = ss;
        this.id = id;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            WoTou wt = new WoTou(i, id);
            ss.push(wt);
            System.out.println("生产了：" + wt);
            try {
                Thread.sleep((int) (Math.random() * 200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 实现Runnable接口，实现run方法的Consumer类，一个对象只消费20个WoTou
 */
class Consumer implements Runnable {
    private SyncStack ss = null;

    Consumer(SyncStack ss) {
        this.ss = ss;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            WoTou wt = ss.pop();
            System.out.println("消费了: " + wt);
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
