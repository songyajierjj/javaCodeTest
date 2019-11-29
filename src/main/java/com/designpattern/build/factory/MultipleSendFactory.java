package com.designpattern.build.factory;

public class MultipleSendFactory {

    public Sender produceSms(){
        return new SmsSender();
    }

    public Sender produceMail(){
        return new MailSender();
    }
}
