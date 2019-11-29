package com.thread;

import java.util.concurrent.CountDownLatch;

public class ThreadPrintOne {

    public static CountDownLatch count = new CountDownLatch(2);
    public static Object object = new Object();

    private static volatile Integer i = 0;
    private static final int total = 100000;

    public static void main(String[] args) throws  Exception{
        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(){
            @Override
            public void run(){
                while(i <= total){
                    synchronized (object){
                        if(i % 2 == 1){
                            if(i <= total){
                                System.out.println(Thread.currentThread().getName()+"打印："+i++);
                            }
                        }else{
                            object.notifyAll();
                            if(i < total){
                                try {
                                    object.wait();
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
                count.countDown();
            }
        };
        thread1.setName("奇数");
        Thread thread2 = new Thread(){
            @Override
            public void run(){
                while(i <= total){
                    synchronized (object){
                        if(i % 2 == 0){
                            if(i <= total){
                                System.out.println(Thread.currentThread().getName()+"打印："+i++);
                            }
                        }else{
                            object.notifyAll();
                            if(i < total){
                                try {
                                    object.wait();
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
                count.countDown();
            }
        };
        thread2.setName("偶数");
        thread1.start();
        thread2.start();
        count.await();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
