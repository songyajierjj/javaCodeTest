package com.designpattern.jiegoumoshi.proxy;

public class Source implements Sourceable {

    @Override
    public void method(){
        System.out.println("the original method!");
    }

    @Override
    public void method1(){
        System.out.println("the original method1!");
    }
}
