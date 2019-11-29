package com.suanfa;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

public class TestRateLimiter {

    public static void main(String[] args) {
        //1秒产生1个令牌
        final RateLimiter rateLimiter = RateLimiter.create(4);
        for (int i = 0; i < 100; i++) {
            long timeOut = (long) 0.5;
            boolean isValid = rateLimiter.tryAcquire(timeOut, TimeUnit.SECONDS);
            System.out.println("任务" + i + "执行是否有效:" + isValid);
            if (!isValid) {
                System.out.println("任务" + i + "抛弃");
                continue;
            }
            System.out.println("任务" + i + "在执行");

        }
        System.out.println("执行结束");
    }

}
