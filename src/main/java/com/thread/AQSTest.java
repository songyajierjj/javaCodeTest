package com.thread;

import com.AppConfig;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class AQSTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch ;
        Semaphore semaphore;
        CyclicBarrier cyclicBarrier;
        ReentrantLock reentrantLock;
        AppConfig appConfig = new AppConfig();
        AppConfig t = appConfig;
        AppConfig p = t;
        System.out.println(appConfig);
        System.out.println(t);
        System.out.println(p);
    }
}
