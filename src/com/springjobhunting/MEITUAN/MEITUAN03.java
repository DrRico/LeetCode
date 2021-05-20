package com.springjobhunting.MEITUAN;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Rico_dds
 * @date 2021/3/13 16:26
 */
public class MEITUAN03 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
        String s = "e15l154lo87wor7l87d\n";
        Pattern p = Pattern.compile("[^0-9]");
        Matcher m = p.matcher(s);
        String[] string = m.replaceAll(" ").split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < string.length; i++) {
            if(string[i].length() != 0)
            list.add(Integer.valueOf(string[i]));
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
