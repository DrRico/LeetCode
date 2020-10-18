package com.rico.HELLO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Rico_dds
 * @date 2020/10/12 18:50
 */
// Five Little Monkeys Jumping on the Bed. It was bedtime. So five little monkeys took a bath. Five little Monkeys put on their pajamas.
public class BAIDU_01 {

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //String s = sc.nextLine();
        String s = "Five Little Monkeys Jumping on the Bed. It was bedtime. So five little monkeys took a bath. Five little Monkeys put on their pajamas.";
        String[] ss = s.split(" ");
        HashMap<String,Integer> map = new HashMap<>();
        //Map<String,Integer> map = new TreeMap<>();
        for (int i = 0; i < ss.length; i++) {
            String temp = ss[i];
            if (ss[i].endsWith(".")){
                temp = ss[i].substring(0,ss[i].length() - 1);
            }
            temp = temp.toLowerCase();
            if(map.containsKey(temp)){
                map.put(temp, map.get(temp) + 1);
            }
            else {
                map.put(temp,i);
            }
        }
        System.out.println(map);
    }
}
