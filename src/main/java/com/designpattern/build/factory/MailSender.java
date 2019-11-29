package com.designpattern.build.factory;

public class MailSender implements Sender {

    @Override
    public void send(){
        System.out.println("email send");
    }
}
