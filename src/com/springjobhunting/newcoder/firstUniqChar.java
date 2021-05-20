package com.springjobhunting.newcoder;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Rico_dds
 * @date 2021/3/7 14:47
 */
public class firstUniqChar {
    public static void main(String[] args) {
        String s1 = "";
        String s2 = "helloh";
        String s3 = "leetcode";
        String s4 = "qqqqqqqqerr";
        String s5 = "abaccdeff";
        System.out.println(find(s1));
        System.out.println(find(s2));
        System.out.println(find(s3));
        System.out.println(find(s4));
        System.out.println(find(s5));
    }
    private static char find(String s){
        if (s.length() == 0) return ' ';
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, 2);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            if (entry.getValue() == 1) return entry.getKey();
        }

        return ' ';
    }
}
