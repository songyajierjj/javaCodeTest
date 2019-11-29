package com.designpattern.xingweimoshi.Memento;

public class Storage {

    private Memento memento;
    public Storage(Memento memento){
        this.memento = memento;
    }

    public Memento getMemento(){
        return this.memento;
    }

    public void setMemento(Memento memento){
        this.memento = memento;
    }

}
