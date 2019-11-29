package com.leetcode;

public class Five {

    public static void main(String[] args) {
        Five five = new Five();
        String s = "aacdefcaa";

    }
    public String longestPalindrome(String s) {
        if(s == null || "".equals(s)){
            return s;
        }
        String newStr = new StringBuffer(s).reverse().toString();
        String hisStr = "";
        char[] array = s.toCharArray();
        char[] newArray = newStr.toCharArray();
        String maxStr = String.valueOf(array[0]);
        for(int j=0;j<array.length-1;j++) {
            for (int i = 0; i < array.length-j; i++) {
                if (array[i] == newArray[i+j]) {
                    hisStr += String.valueOf(array[i]);
                } else {
                    if (hisStr.length() > maxStr.length()) {
                        maxStr = hisStr;
                    }
                    hisStr = "";
                }
            }
            if (hisStr.length() > maxStr.length()) {
                maxStr = hisStr;
            }
            hisStr = "";
        }
        hisStr = "";
        for(int j=0;j<array.length-1;j++) {
            for (int i = 0; i < array.length-j; i++) {
                if (array[i+j] == newArray[i]) {
                    hisStr += String.valueOf(newArray[i]);
                } else {
                    if (hisStr.length() > maxStr.length()) {
                        maxStr = hisStr;
                    }
                    hisStr = "";
                }
            }
            if (hisStr.length() > maxStr.length()) {
                maxStr = hisStr;
            }
            hisStr = "";
        }
        return maxStr;
    }
}
