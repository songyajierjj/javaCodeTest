package com.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;
import java.util.concurrent.*;

public class GeneratorDistributedID {

    public static Map<Long, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args){
        try {
            int maxThreadNums = 2;
            GenericObjectPoolConfig config = new GenericObjectPoolConfig();
            config.setMaxIdle(maxThreadNums);
            config.setMaxTotal(maxThreadNums);
            JedisPool jedisPoll = new JedisPool(config,"localhost");
            CountDownLatch latch = new CountDownLatch(maxThreadNums);
            ExecutorService es = Executors.newFixedThreadPool(maxThreadNums);
            for (int i = 1; i <= maxThreadNums; i++) {
                es.execute(new ThreadTest(latch,jedisPoll));
            }
            latch.await();
            System.out.println(map.size());
            jedisPoll.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    static class ThreadTest implements Runnable{
        private JedisPool jedisPoll;
        private CountDownLatch countDownLatch;
        public ThreadTest(CountDownLatch countDownLatch,JedisPool jedisPoll){
            this.countDownLatch = countDownLatch;
            this.jedisPoll = jedisPoll;
        }

        @Override
        public void run(){
            Jedis jedis = jedisPoll.getResource();
            for (int i = 0; i < 10; i++) {
                Long id = GeneratorDistributedID.getId(jedis);
                if (map.containsKey(id)) {
                    throw new RuntimeException("duplicate id="+id);
                } else {
                    map.put(id, i);
                }
            }
            countDownLatch.countDown();
            jedis.close();
        }
    }

    public static long getId(Jedis jedis){
        long currentTime = System.currentTimeMillis();
        String digit = "000000";
        String result;
        if(jedis.get(String.valueOf(currentTime)) != null){
            result = digit + jedis.incr(String.valueOf(currentTime));
            return Long.parseLong(currentTime+result.substring(result.length()-digit.length()));
        }else{
            if(jedis.setnx(String.valueOf(currentTime),"0") == 0){
                result = digit + jedis.incr(String.valueOf(currentTime));
                return Long.parseLong(currentTime+result.substring(result.length()-digit.length()));
            }
            jedis.expire(String.valueOf(currentTime),60);
            return Long.parseLong(currentTime+digit);
        }
    }
}
