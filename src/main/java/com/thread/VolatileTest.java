package com.thread;

import org.springframework.aop.ThrowsAdvice;

public class VolatileTest {

    public volatile int inc = 0;
    public void increase(){
        inc ++;
    }

    public static void main(String[] args) throws Exception{
        final VolatileTest test = new VolatileTest();
        for(int i=0;i<10;i++){
            Thread thread = new Thread(){
                public void run(){
                    for(int j=0;j<10;j++){
                        test.increase();
                    }
                }
            };
            thread.join();
            thread.start();
        }
        System.out.println(test.inc);
    }
}
