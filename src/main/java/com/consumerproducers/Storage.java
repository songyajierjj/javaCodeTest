package com.consumerproducers;

import java.util.LinkedList;
import java.util.List;

public class Storage {

    private final int MAX_SIZE = 100;//最大容量
    private List list = new LinkedList<>();

    public void produce(int num){
        synchronized (list){
            while (list.size()+num > MAX_SIZE){
                System.out.println("暂时不能生产"+num+"任务");
                try{
                    list.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            for(int i=0;i<num;i++){
                list.add(new Object());
            }
            System.out.println("已经生产"+num+"个，总数量为："+list.size());
            list.notifyAll();
        }
    }

    public void consume(int num){
        synchronized (list){
            while (list.size() < num){
                System.out.println("暂时不能消费"+num+"任务");
                try {
                    list.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            for(int i=0;i<num;i++){
                list.remove(0);
            }
            System.out.println("已消费产品数"+num+" 仓库容量"+list.size());
            list.notifyAll();
        }
    }
}
