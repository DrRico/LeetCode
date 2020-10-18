package com.rico.HELLO;

import java.util.*;

/**
 * @author Rico_dds
 * @date 2020/10/12 18:51
 */
public class BAIDU_04 {

    public static void cw(String str){
        str = str.toLowerCase();
        String reg = "[\\W]+";
        str = str.replaceAll(reg," ");
        String[] strs = str.split(" ");
        HashMap<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(String s : strs){
            if (map.containsKey(s)){
                map.put(s,map.get(s) + 1);
            } else {
                map.put(s,1);
                list.add(s);
            }
        }

        Set<Map.Entry<String,Integer>> set = map.entrySet();
        String maxString = null;
        int maxVal = 0;
        for (Map.Entry<String,Integer> e : set){
            String key = e.getKey();
            Integer value = e.getValue();
            if (value >= maxVal){
                maxVal = value;
                maxString = key;
            }
        }
        System.out.print(maxString+" ");
        //System.out.print(maxString.substring(0,1).toUpperCase() + maxString.substring(1,maxString.length())+" ");
        System.out.println(maxVal);
    }



    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //String s = sc.nextLine();
        String s = "Five Little Monkeys Jumping on the Bed. It was bedtime. So five little monkeys took a bath. Five little Monkeys put on their pajamas.";

        cw(s);
    }
}
