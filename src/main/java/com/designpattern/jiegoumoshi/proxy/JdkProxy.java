package com.designpattern.jiegoumoshi.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method,Object[] args) throws Throwable{
        System.out.println("jdk动态代理，监听开始");
        Object result = method.invoke(target,args);//方法执行，参数：target 目标对象 arr参数数组
        System.out.println("jdk动态代理，监听结束");
        return result;
    }

    private Object getJdkProxy(Object targetObject){
        //为目标对象target赋值
        this.target = targetObject;
        //JDK动态代理只能针对实现了接口的类进行代理，newProxyInstance 函数所需参数就可看出
        System.out.println(targetObject.getClass().getClassLoader());
        System.out.println(targetObject.getClass().getInterfaces().length);
        System.out.println(targetObject.getClass().getInterfaces()[0]);
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),this);
    }

    public static void main(String[] args) throws Exception{
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        JdkProxy jdkProxy = new JdkProxy();//实例化JDKProxy对象
//        Sourceable user = (Sourceable) jdkProxy.getJdkProxy(new Source());//获取代理对象
//        user.method();
        byte[] proxyClass = ProxyGenerator.generateProxyClass("proxyTest",new Class[]{Sourceable.class});
        FileOutputStream fileOutputStream = new FileOutputStream("d:/ProxyTest.class");
        fileOutputStream.write(proxyClass);
        fileOutputStream.close();
    }
}
