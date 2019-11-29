package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class TestPostProcessor {

    public static void main(String[] args) throws Exception{
//        System.out.println("容器开始启动");
//        AnnotationConfigApplicationContext applicationContext =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for(String beanDefinitionName : beanDefinitionNames){
//            System.out.println(beanDefinitionName);
//        }
//        System.out.println("===============");
//        Calculator calculator = (Calculator)applicationContext.getBean(Calculator.class);
//        calculator.add(1,2);

//        TestPostProcessor testPostProcessor = new TestPostProcessor();
//        testPostProcessor.test(1);
//        testPostProcessor.test(3);
//        testPostProcessor.test(2);
//        testPostProcessor.test(5);
        Map<String,String> map = new HashMap<>();
        for(int i=0;i<100000;i++){
            map.put(i+"sadfsdaffafafsffsdfaaaffaf","afsdfadsfadsfasfdsafsdfasd");
        }
        System.out.println("放入完成");
        System.out.println("");
        Thread.sleep(60000);
    }

    private void test(int i){
        switch (i){
            case 1:
            case 3:
                System.out.println("1,3");
                break;
            case 4:
            case 5:
            case 2:
                System.out.println("2,4,5");
                break;
            default :System.out.println("cc");
        }
    }
}
