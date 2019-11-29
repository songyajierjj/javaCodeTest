package com.designpattern.jiegoumoshi.bridge;

public abstract class Bridge {

    private Sourceable sourceable;

    public Sourceable getSource() {
        return sourceable;
    }

    public void setSource(Sourceable sourceable) {
        this.sourceable = sourceable;
    }


    public void method(){
        sourceable.method();
    }
}
