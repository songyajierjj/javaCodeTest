package com.consumerproducers;

public class LockTest {

    public static void main(String[] args) {
        LockStorage storage = new LockStorage();
        LockProduce producer1 = new LockProduce().setLockStorage(storage);
        LockProduce producer2 = new LockProduce().setLockStorage(storage);
        LockProduce producer3 = new LockProduce().setLockStorage(storage);
        LockProduce producer4 = new LockProduce().setLockStorage(storage);
        LockProduce producer5 = new LockProduce().setLockStorage(storage);

        LockConsumer consumer1 = new LockConsumer().setLockStorage(storage);
        LockConsumer consumer2 = new LockConsumer().setLockStorage(storage);
        LockConsumer consumer3 = new LockConsumer().setLockStorage(storage);

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
