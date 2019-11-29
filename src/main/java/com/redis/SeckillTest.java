package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SeckillTest {
    public static Jedis commonJedis = new Jedis("localhost", 6379);

    public static void main(String[] args) {
        String key = "apple";
        int num = 100;
        commonJedis.set(key,num+"");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(20,20,1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1000));

        for(int i=0;i<1000;i++){
            executor.execute(new RunSeckillGoods(key,"user"+i,num));
        }
    }
}
