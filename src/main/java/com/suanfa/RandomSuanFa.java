package com.suanfa;


import java.util.ArrayList;
import java.util.List;

public class RandomSuanFa {

    public static void main(String[] args) {
        RandomSuanFa sf = new RandomSuanFa();
        String s = "LEETCODEISHIRING";
        int numRows = 4;
        System.out.println(sf.convert(s,numRows));
    }


    public String convert(String s, int numRows) {
        int group = numRows * 2 - 2;
        char[] str = s.toCharArray();
        List<String[]> list = new ArrayList<>();
        for(int i=0;i<=str.length/group;i++){
            String[] strGroup = new String[numRows];
            for(int j=0;j<numRows;j++){
                strGroup[j] = "";
                if(j == 0 || j == numRows-1){
                    if(j+i*group < str.length) {
                        strGroup[j] = String.valueOf(str[j + i * group]);
                    }
                }else{
                    if(j+i*group < str.length) {
                        strGroup[j] += str[j+i*group];
                    }
                    if((group-j)+i*group < str.length){
                        strGroup[j] += String.valueOf(str[(group-j)+i*group]);
                    }
                }
                System.out.println(strGroup[j]);
            }
            list.add(strGroup);
        }
        String result = "";
        for(int i=0;i<numRows;i++) {
            for (String[] ever : list) {
                result += ever[i];
            }
        }
        return result;
    }
}
