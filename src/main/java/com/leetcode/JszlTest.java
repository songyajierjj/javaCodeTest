package com.leetcode;

public class JszlTest {

    public static void main(String[] args) {
        long a = -2;
        JszlTest test = new JszlTest();
        System.out.println(test.getResult(a,-3));
    }

    public float getResult(long a,long n){
        long y = 1;
        boolean isPositive = true;
        if(n < 0){
            isPositive = false;
            n = Math.abs(n);
        }
        for(int i=0;i<n;i++){
            y = y * a;
        }
        float result = y;
        return isPositive?result:1/result;
    }
}
