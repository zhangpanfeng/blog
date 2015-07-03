package com.darren.test.thread;

public class Consumerr extends Thread {
    private Resource resource;

    public Consumerr(Resource resource) {
        this.resource = resource;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.consume();
            System.out.println("consume result = " + resource.getSpace());
        }
    }
}
