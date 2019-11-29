package com.designpattern.jiegoumoshi.adapter;

public class ClassAdapter extends Source implements Targetable{

    @Override
    public void method2(){
        System.out.println("this is the targetable method!");
    }

}
