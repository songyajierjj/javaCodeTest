package com.designpattern.jiegoumoshi.proxy;

public class Proxy implements Sourceable {

    private Source source;
    public Proxy(){
        super();
        this.source = new Source();
    }

    @Override
    public void method(){
        before();
        source.method();
        atfer();
    }

    @Override
    public void method1(){
        before();
        source.method1();
        atfer();
    }

    private void atfer() {
        System.out.println("after proxy!");
    }

    private void before() {
        System.out.println("before proxy!");
    }

}
