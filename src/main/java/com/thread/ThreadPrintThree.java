package com.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPrintThree {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile Integer i = 0;
    private static final int total = 10;
    public static CountDownLatch count = new CountDownLatch(2);

    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i <= total){
                    lock.lock();
                    if(i % 2 == 1){
                        if(i <= total){
                            System.out.println(Thread.currentThread().getName()+"打印："+i++);
                        }
                    }else{
                        condition.signalAll();
                        if(i < total){
                            try {
                                condition.await();
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }
                    lock.unlock();
                }
                count.countDown();
            }
        });
        thread1.setName("奇数");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i <= total){
                    lock.lock();
                    if(i % 2 == 0){
                        if(i <= total){
                            System.out.println(Thread.currentThread().getName()+"打印："+i++);
                        }
                    }else{
                        condition.signalAll();
                        if(i < total){
                            try {
                                condition.await();
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }
                    lock.unlock();
                }
                count.countDown();
            }
        });
        thread2.setName("偶数");
        thread1.start();
        thread2.start();
        count.await();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
