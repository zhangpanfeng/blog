package com.darren.test.thread;

public class ResourceLoader implements Task {

    private int index;

    public ResourceLoader(int index) {
        this.index = index;
    }

    public void execute() {
        System.out.println("第" + index + "个Task被执行!");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
