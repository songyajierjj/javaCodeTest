package com.designpattern.jiegoumoshi.decorator;

public class DecoratorTest {

    public static void main(String[] args) {
        //装饰模式
        Sourceable sourceable = new Source();
        Sourceable obj = new Decorator(sourceable);
        obj.method();
    }
}
