package com.annotation.repeatable;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@ComponentScan(value = {"1"})
@ComponentScan(value = {"2"})
@ComponentScan(value = {"3"})
public class Man {
    //@Repeatable注解表明标记的注解可以多次应用于相同的声明或类型，此注解由Java SE 8版本引入
    public static void main(String[] args) {
        ComponentScans componentScans = (ComponentScans) Man.class.getAnnotation(ComponentScans.class);
        for(ComponentScan componentScan : componentScans.value()){
            System.out.println(componentScan.value()[0]);
        }
//        Annotation[] annotations = Man.class.getAnnotations();
//        System.out.println(annotations.length);
//        ComponentScans componentScans = (ComponentScans)annotations[0];
//        for(ComponentScan componentScan : componentScans.value()){
//            System.out.println(componentScan.value());
//        }
    }
}
