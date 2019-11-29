package com.designpattern.jiegoumoshi.adapter;

public class ObjectAdapter implements Targetable{

    private Source source;

    public ObjectAdapter(Source source){
        super();
        this.source = source;
    }

    @Override
    public void method2(){
        System.out.println("this is the targetable method!");
    }

    @Override
    public void method1(){
        source.method1();
    }
}
