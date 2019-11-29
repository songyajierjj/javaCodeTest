package com.designpattern.build.factory;

public class NormalSendFactory {

    public Sender produce(String type){
        if("mail".equals(type)){
            return new MailSender();
        }
        if("sms".equals(type)){
            return new SmsSender();
        }
        return null;
    }
}
