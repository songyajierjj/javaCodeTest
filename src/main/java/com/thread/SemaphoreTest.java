package com.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    private Semaphore semaphore = new Semaphore(5);
    public static void main(String[] args){
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        for(int i =0;i<100;i++){
            new Thread(() -> semaphoreTest.test()).start();
        }
    }

    private void test(){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 进来了");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 出去了");
        semaphore.release();
    }

}
