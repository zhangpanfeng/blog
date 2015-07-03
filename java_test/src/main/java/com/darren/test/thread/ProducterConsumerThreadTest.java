package com.darren.test.thread;

public class ProducterConsumerThreadTest {

    public static void main(String[] args) {
        Resource resource = new Resource();
        Provider provider = new Provider(resource);
        Consumerr consumer = new Consumerr(resource);

        provider.start();
        consumer.start();

    }

}
