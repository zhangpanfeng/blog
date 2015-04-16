package com.darren.test.thread;

public interface Executor {

    void setTask(Task task);

    Task getTask();

    void startTask();
}
