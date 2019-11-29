package com.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableTest {

    static class MyCallable implements Callable<Integer> {

        private int i;

        MyCallable(Integer i){
            this.i = i;
        }
        @Override
        public Integer call() throws Exception{
            int sum = 0;
            for(int j=0+(i-1)*1000;j<=i*1000;j++){
                sum += j;
            }
            return sum;
        }
    }

    public static void main(String[] args) throws Exception{

        ThreadPoolExecutor pool = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
        long current = System.currentTimeMillis();
        List<Future<Integer>> list = new ArrayList<>();
        for(int i=1;i<=10;i++){
            list.add(pool.submit(new MyCallable(i)));
        }
        int count = 0;
        while(pool.getCompletedTaskCount() < list.size()){
            Thread.sleep(1);
        }
        for(Future<Integer> future : list){
            count += future.get();
        }
        System.out.println(count);
        System.out.println(System.currentTimeMillis()-current);
    }
}
