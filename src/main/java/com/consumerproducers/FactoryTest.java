package com.consumerproducers;

public class FactoryTest {

    public static void main(String[] args) {
        Storage storage = new Storage();
        Producer producer1 = new Producer().setStorage(storage);
        Producer producer2 = new Producer().setStorage(storage);
        Producer producer3 = new Producer().setStorage(storage);
        Producer producer4 = new Producer().setStorage(storage);
        Producer producer5 = new Producer().setStorage(storage);

        Consumer consumer1 = new Consumer().setStorage(storage);
        Consumer consumer2 = new Consumer().setStorage(storage);
        Consumer consumer3 = new Consumer().setStorage(storage);

        producer1.setNum(10);
        producer2.setNum(20);
        producer3.setNum(10);
        producer4.setNum(80);
        producer5.setNum(10);
        consumer1.setNum(50);
        consumer2.setNum(20);
        consumer3.setNum(20);
        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}
