package com.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPrintTwo {
    private static volatile Boolean flag = true;

    private static AtomicInteger num = new AtomicInteger();

    private static final Integer TOTAL = 100000;

    public static CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) throws Exception{
        System.out.println(num.get());
        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (num.get() <= TOTAL){
                    if(!flag){
                        System.out.println(Thread.currentThread().getName()+"打印："+num.getAndIncrement());
                        flag = true;
                    }
                }
                latch.countDown();
            }
        });
        thread1.setName("奇数");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (num.get() <= TOTAL){
                    if(flag){
                        System.out.println(Thread.currentThread().getName()+"打印："+num.getAndIncrement());
                        flag = false;
                    }
                }
                latch.countDown();
            }
        });
        thread2.setName("偶数");
        thread1.start();
        thread2.start();

        latch.await();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
