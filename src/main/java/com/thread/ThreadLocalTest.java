package com.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadLocalTest {

    public static ThreadLocal<Integer> tl = new ThreadLocal<>();
    public static int Thread_Nums = 4;
    public static CyclicBarrier cb = new CyclicBarrier(Thread_Nums);
    public static void main(String[] args)  {
        for(int i=0;i<Thread_Nums;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Double d = Math.random()*10;
                    tl.set(d.intValue());
                    try {
                        System.out.println(Thread.currentThread().getName()+"到达lanshan");
                        cb.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(tl.get());
                }
            }).start();
        }
    }
}
