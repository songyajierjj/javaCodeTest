package com.thread;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class QueueTest {

    public static void main(String[] args) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread thread = new Thread();
    }
}
