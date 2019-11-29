package com.designpattern.build.factory;

public class FactoryTest {
    public static void main(String[] args) {
        //普通工厂模式
        NormalSendFactory normalSendFactory = new NormalSendFactory();
        Sender sender = normalSendFactory.produce("sms");
        sender.send();

        //多个工厂模式
        MultipleSendFactory multipleSendFactory = new MultipleSendFactory();
        sender = multipleSendFactory.produceMail();
        sender.send();

        //静态工厂模式
        sender = StaticSendFactory.produceSms();
        sender.send();

        //抽象工厂模式
        Provider provider = new SendMailFactory();
        sender = provider.produce();
        sender.send();

    }
}
