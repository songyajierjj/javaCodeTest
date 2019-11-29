package com.designpattern.build.factory;

public class SmsSender implements Sender {

    @Override
    public void send(){
        System.out.println("sms send");
    }
}
