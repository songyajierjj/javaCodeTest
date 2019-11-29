package com.designpattern.jiegoumoshi.adapter;

public class AdapterTest {

    public static void main(String[] args) {
        //类的适配器模式
        Targetable classAdapter = new ClassAdapter();
        classAdapter.method1();

        //对象的适配器模式
        Source source = new Source();
        Targetable objectAdapter = new ObjectAdapter(source);
        objectAdapter.method1();

        //接口适配器模式
        SourceSub1 sourceSub1 = new SourceSub1();
        SourceSub2 sourceSub2 = new SourceSub2();
        sourceSub1.method1();
        sourceSub2.method2();
    }

}

