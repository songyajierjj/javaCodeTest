package com.designpattern.xingweimoshi.Memento;

public class Memento {

    private String value;
    public Memento(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public void setValue(String value){
        this.value = value;
    }
}
