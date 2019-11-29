package com.designpattern.xingweimoshi.chainofresponseibility;

public abstract class AbstractHandler {

    private Handler handler;
    public Handler getHandler(){
        return this.handler;
    }

    public void setHandler(Handler handler){
        this.handler = handler;
    }
}
