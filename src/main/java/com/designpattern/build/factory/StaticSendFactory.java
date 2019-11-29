package com.designpattern.build.factory;

public class StaticSendFactory {

    public static Sender produceSms(){
        return new SmsSender();
    }

    public static Sender produceMail(){
        return new MailSender();
    }
}
