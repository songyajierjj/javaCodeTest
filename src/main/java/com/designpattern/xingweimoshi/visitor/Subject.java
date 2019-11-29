package com.designpattern.xingweimoshi.visitor;

public interface Subject {

    public void accept(Visitor visitor);

    public String getSubject();
}
