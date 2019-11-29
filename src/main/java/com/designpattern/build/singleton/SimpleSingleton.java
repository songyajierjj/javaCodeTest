package com.designpattern.build.singleton;

public class SimpleSingleton {

    private static SimpleSingleton instance = null;

    /* 私有构造方法，防止被实例化 */
    private SimpleSingleton(){

    }

//    public static SimpleSingleton getInstance(){
//        if(instance == null){
//            instance = new SimpleSingleton();
//        }
//        return instance;
//    }

//    public static synchronized SimpleSingleton getInstance(){
//        if(instance == null){
//            instance = new SimpleSingleton();
//        }
//        return instance;
//    }

    public static SimpleSingleton getInstance(){
        if(instance == null){
            synchronized(instance){
                if (instance == null){
                    instance = new SimpleSingleton();
                }
            }
        }
        return instance;
    }
    private static class SingletonFactory{
        private static SimpleSingleton instance = new SimpleSingleton();
    }

    public static SimpleSingleton getSafeInstance(){
        return SingletonFactory.instance;
    }
}
