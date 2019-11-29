package com.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CountDownLatchTest {

    public static void main(String[] args) throws Exception{
        CountDownLatch latch = new CountDownLatch(10);
        ExecutorService es = Executors.newFixedThreadPool(10);
        List<Future<Integer>> list = new ArrayList<>();
        for(int i=1;i<=10;i++){
            list.add(es.submit(new ThreadTest(latch,i)));
        }
        latch.await();
        int sum = 0;
        for(Future<Integer> future : list){
            sum += future.get();
        }
        System.out.println(sum);
    }

    static class ThreadTest implements Callable<Integer>{
        private CountDownLatch countDownLatch;
        private int i;
        public ThreadTest(CountDownLatch countDownLatch,int i){
            this.countDownLatch = countDownLatch;
            this.i = i;
        }

        @Override
        public Integer call(){
            int sum = 0;
            for(int j=1+(i-1)*10;j<=i*10;j++){
                sum += j;
            }
            System.out.println("计算完毕counDown减1");
            countDownLatch.countDown();
            System.out.println("i="+i+",sum="+sum);
            return sum;
        }
    }
}
