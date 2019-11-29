package com.consumerproducers;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LockProduce extends Thread{

    private int num;
    private LockStorage lockStorage;

    public void run(){
        lockStorage.produce(num);
    }
}
