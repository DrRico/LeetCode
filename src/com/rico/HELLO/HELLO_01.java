package com.rico.HELLO;

/**
 * @author Rico_dds
 * @date 2020/10/11 16:57
 */
import java.util.*;


public class HELLO_01 {

    public static String findMaxSubstr (String str) {
        int firstIndex = 0;
        int lastIndex = 0;
        int len = str.length();
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        String res = "";
        while (firstIndex < len && lastIndex < len){
            if (set.contains(str.charAt(lastIndex))){
                set.remove(str.charAt(firstIndex ++));
                sb.delete(0,1);
            } else {
                sb.append(str.charAt(lastIndex));
                set.add(str.charAt(lastIndex++));
                if (res.length() < sb.length()){
                    res = sb.toString();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMaxSubstr("abcdbcdcbabcdefggcwa"));
        System.out.println(findMaxSubstr("The Linux kernel is an open source software project of fairly large scope"));
    }
}