package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

public class RunSeckillGoods implements Runnable{

    private String key;
    private String name;
    private int num;

    public RunSeckillGoods(String key,String name,int num){
        this.key = key;
        this.name = name;
        this.num = num;
    }

    Jedis jedis = new Jedis("localhost");

    @Override
    public void run() {
        //redis 监视一个key，当这个key的值发生改变时候，事务提交失败
        jedis.watch(key);
        String string = jedis.get(key);
        //得到商品的数量
        int currentnum = Integer.parseInt(string);
        if (currentnum <= num && currentnum >= 1) {
            //进行秒杀环节
            //开启事务
            Transaction multi = jedis.multi();
            //让商品减少一个
            multi.incrBy(key,-1);
            //提交事务.如果事务提交失败，返回值为空
            List<Object> exec = multi.exec();
            if (exec == null || exec.size()==0) {
                System.out.println(name+"----抢购失败！");
            }else {
                for (Object object : exec) {
                    System.out.println(name+"("+object.toString()+")"+"抢购商品成功，当前抢购成功人数为："+(1-(currentnum-this.num)));
                }
            }
        }else {
            System.out.println("商品一已经被抢购完");
        }

    }
}
