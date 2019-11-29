package com.designpattern.jiegoumoshi.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Object target;

    @Override
    public Object intercept(Object obj, Method method, Object[] arr, MethodProxy proxy) throws Throwable{
        System.out.println("cglib动态代理，监听开始");
        Object invoke = method.invoke(target,arr);//方法执行，参数：target 目标对象 arr参数数组
        System.out.println("cglib动态代理，监听结束");
        return invoke;
    }

    public Object getCglibProxy(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        //设置父类,因为Cglib是针对指定的类生成一个子类，所以需要指定父类
        enhancer.setSuperclass(target.getClass());
        // 设置回调
        enhancer.setCallback(this);
        //创建并返回代理对象
        Object result = enhancer.create();
        return result;
    }

    public static void main(String[] args) {
        CglibProxy cglib = new CglibProxy();//实例化CglibProxy对象
        Sourceable source =  (Source) cglib.getCglibProxy(new Source());//获取代理对象
        source.method();
    }
}
