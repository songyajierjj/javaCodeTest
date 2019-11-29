package com.thread;

public class WaitNotifyTest {

    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程a等待获取lock锁");
                synchronized (lock){
                    try{
                        System.out.println("线程a获取了lock锁");
                        Thread.sleep(1000);
                        System.out.println("线程a将要运行lock.wait()方法进行等待");
                        lock.wait();
                        System.out.println("线程a等待结束");
                    }catch (Exception e){

                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程B等待获取lock锁");
                synchronized (lock) {
                    System.out.println("线程B获取了lock锁");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程B将要运行lock.notify()方法进行通知");
                    lock.notify();
                }
            }
        }).start();

    }
}
