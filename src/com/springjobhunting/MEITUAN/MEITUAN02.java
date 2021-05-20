package com.springjobhunting.MEITUAN;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2021/3/13 16:26
 */
public class MEITUAN02 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //String s = sc.nextLine();
        String s = "a0125b1c0d00 ";
        char[] ch = s.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] >= '0' && ch[i] <= '9'){
                sb.append(ch[i]);
            } else if(sb.length() != 0){
                list.add(Integer.valueOf(sb.toString()));
                sb.delete(0,sb.length());
            }
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
