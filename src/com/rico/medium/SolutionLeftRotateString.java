package com.rico.medium;

import java.util.HashMap;

/**
 * @author Rico_dds
 * @date 2020/7/25 15:38
 */
public class SolutionLeftRotateString {
    public static String LeftRotateString_01(String str, int n) {
        if(str == null || str.equals("")){
            return str;
        }
        String s1 = str.substring(0,n);
        String s2 = str.substring(n,str.length());
        return s2+s1;
    }
    public static String LeftRotateString_02(String str, int n) {
        if(str == null || str.equals("")){
            return str;
        }
        int i =  str.length();
        str += str;
        return str.substring(n,n+i);
    }


    public static void main(String[] args) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        System.out.println(LeftRotateString_02("abcdefg",2));
    }
}
