package com.redis;

import redis.clients.jedis.Jedis;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class RedisTest {
    public static Jedis jedis = new Jedis("localhost", 6379);

    public static void main(String[] args) throws Exception {
//        Long m1 = Long.valueOf(getMemory());
//        insertData();
//        Long m2 = Long.valueOf(getMemory());
//        System.out.println(m2 - m1);
//        Set set = new HashSet<>();
//        set.add(123);
    }


    public static void insertData() {
        for (int i = 10000; i < 100000; i++) {
            jedis.set("aaa" + i, "aaa" + i); //key和value长度都是7字节，且不是整数　　　　
        }
    }

    public static String getMemory() {
        String memoryAllLine = jedis.info("memory");
        String usedMemoryLine = memoryAllLine.split("\r\n")[1];
        String memory = usedMemoryLine.substring(usedMemoryLine.indexOf(':') + 1);
        return memory;
    }
}
