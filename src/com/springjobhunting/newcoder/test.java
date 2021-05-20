package com.springjobhunting.newcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

    public static boolean isPalindromic(String string) {
        return string.equalsIgnoreCase(new StringBuffer(string).reverse().toString());
    }
    public static Map<String, Object> getLongestPalindromic(String string) {
        Map<String, Object> map = new HashMap<>();
        List<String> strings = new ArrayList<>();
        if (string == null || string.equals("") || string.length() == 0) {
            return null;
        }
        for (int i = 0; i < string.length(); i++) {
            for (int j = i + 1; j <= string.length(); j++) {
                String sub = string.substring(i, j);
                if (isPalindromic(sub)) {
                    strings.add(sub);
                }
            }
        }
        map.put("strings", strings);
        return map;
    }
    public static void main(String[] args) {
        String string = "aabbaa";
        Map<String, Object> map = getLongestPalindromic(string);
        System.out.println("所有回文串：" + map.get("strings"));
    }
}
