package com.darren.test.thread;

public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool(2);
        for (int i = 0; i < 20; i++) {
            Executor executor = pool.getExecutor();
            ResourceLoader task = new ResourceLoader(i);
            executor.setTask(task);
            executor.startTask();
        }

        // pool.destroy();
    }
}
