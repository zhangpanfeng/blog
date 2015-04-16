package com.darren.test.thread;

public interface Pool {

    Executor getExecutor();

    void destroy();
}
