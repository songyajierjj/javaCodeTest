package com.consumerproducers;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockStorage {

    private final int MAX_SIZE = 100;//最大容量
    private List list = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition produceCondition = lock.newCondition();
    private final Condition consumeCondition = lock.newCondition();

    public void produce(int num){
        try{
            lock.lock();
            System.out.println("当前线程NAME是"+Thread.currentThread().getName());
            System.out.println("生产获取锁");
            while (list.size()+num > MAX_SIZE) {
                System.out.println("暂时不能生产" + num + "任务");
                produceCondition.await();
            }
            for(int i=0;i<num;i++){
                list.add(new Object());
            }
            System.out.println("已经生产"+num+"个，总数量为："+list.size());
            consumeCondition.signalAll();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println("生产释放锁");
        }
    }

    public void consume(int num){
        try{
            lock.lock();
            System.out.println("当前线程NAME是"+Thread.currentThread().getName());
            System.out.println("消费获取锁");
            while (list.size() < num) {
                System.out.println("暂时不能消费" + num + "任务");
                consumeCondition.await();
            }
            for(int i=0;i<num;i++){
                list.remove(0);
            }
            System.out.println("已经消费"+num+"个，总数量为："+list.size());
            produceCondition.signalAll();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println("消费释放锁");
        }
    }

}
