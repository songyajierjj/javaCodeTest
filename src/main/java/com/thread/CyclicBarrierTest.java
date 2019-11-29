package com.thread;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程"+Thread.currentThread().getName());
            }
        });
        for(int i=0;i<8;i++){
            new Writer(barrier).start();
        }

    }

    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run(){
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据");
            try{
                Thread.sleep(1000);
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕");
                cyclicBarrier.await();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
