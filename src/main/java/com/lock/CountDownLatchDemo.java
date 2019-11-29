package com.lock;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    static class TaskThread extends Thread {

        CountDownLatch countDownLatch;

        public TaskThread(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println(getName() + " 出发");
                Thread.sleep(1000);
                System.out.println(getName() + " 结束");
                countDownLatch.countDown();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int threadNum = 4;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        for(int i = 0; i < threadNum; i++) {
            new TaskThread(countDownLatch).start();
        }
        countDownLatch.await();
        System.out.println("4个线程已经执行完毕");
    }
}
