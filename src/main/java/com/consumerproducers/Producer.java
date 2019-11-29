package com.consumerproducers;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Producer extends Thread{

    private int num;
    private Storage storage;

    public void run(){
        storage.produce(num);
    }
}
