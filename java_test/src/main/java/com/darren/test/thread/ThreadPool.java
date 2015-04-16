package com.darren.test.thread;

import java.util.LinkedList;

public class ThreadPool implements Pool {
    // 线程池的默认大小
    private static final int DEFAULT_SIZE = 10;
    // 标识线程池可用不可用，默认可用
    private boolean isShut = false;
    // 存储线程，即执行器
    private LinkedList<Executor> pool;

    public ThreadPool() {
        this(DEFAULT_SIZE);
    }

    /**
     * 初始化线程池并启动线程
     * 
     * @param size
     */
    public ThreadPool(int size) {
        // 初始化线程池
        pool = new LinkedList<Executor>();

        for (int i = 0; i < size; i++) {
            Executor executor = new ExecutorImpl(i);
            pool.add(executor);
            // 启动线程
            Thread thread = (Thread) executor;
            thread.start();
        }
    }

    /**
     * 获取执行器
     */
    public Executor getExecutor() {
        Executor executor = null;
        // 为什么要对pool加锁，因为pool有时被删，有时被添加
        synchronized (pool) {
            if (pool.size() > 0) {
                executor = pool.removeFirst();

            } else {
                try {
                    // 线程池中的执行器用完了，就开始等待
                    pool.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 等到被唤醒时继续执行wait之后的逻辑
                executor = pool.removeFirst();

            }
        }
        // System.out.println("获取执行器成功！");
        return executor;
    }

    /**
     * 摧毁线程池
     */
    public void destroy() {
        // 获取到锁之后，再摧毁线程池
        synchronized (pool) {
            // 标识为不可用
            isShut = true;
            // 通知正在等待的线程执行完，因为此时，可能有线程还在等待
            pool.notifyAll();
            // 清空线程池
            pool.clear();
        }
    }

    private class ExecutorImpl extends Thread implements Executor {

        private Task task;
        private Object lock = new Object();
        private int index;

        public ExecutorImpl(int index) {
            this.index = index;
        }

        public void setTask(Task task) {
            this.task = task;
        }

        public Task getTask() {
            return task;
        }

        public void startTask() {
            synchronized (lock) {
                // System.out.println("唤醒第" + index + "个执行器！");
                lock.notify();
            }
        }

        @Override
        public void run() {
            while (!isShut) {
                synchronized (lock) {
                    try {
                        // 等待资源，也就是等待task，因为线程池初始化的时候就把所有的线程都启动了，而此时好没有task
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 等到被唤醒时也就是被人为的调用了startTask()方法，此时继续执行wait之后的逻辑
                    // 即，开始执行task
                    // System.out.println("第" + index + "个执行器开始执行");
                    Task task = getTask();
                    if (task != null) {
                        task.execute();
                    } else {
                        System.err.println("Task is null");
                    }

                    // task执行完毕后，线程空闲下来，此时再加入线程池中，然后通知所有等待线程线程池的地方，线程池可用
                    synchronized (pool) {
                        pool.addFirst(ExecutorImpl.this);
                        pool.notifyAll();
                    }
                }
            }
        }
    }
}
