package com.darren.test.thread;

public class Provider extends Thread {
    private Resource resource;

    public Provider(Resource resource) {
        this.resource = resource;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.produce();
            System.out.println("produce result = " + resource.getSpace());
        }
    }
}
