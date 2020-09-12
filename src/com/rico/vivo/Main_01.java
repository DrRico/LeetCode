package com.rico.vivo;

import java.util.*;

/**
 * @author Rico_dds
 * @date 2020/9/12 18:51
 */
public class Main_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(compileSeq(s));
    }

    public static String compileSeq (String input) {
        // if (input.length() <= 1 || !input.equals("-1")) return input;
        String[] chars = input.split(",");
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (!chars[i].equals("-1")){
                stack.add(chars[i]);
            } else {
                while (!stack.isEmpty()){
                    String ss = stack.pop();
                    sb.append(ss);
                    list.add(ss);
                }
                break;
            }
        }
        ArrayList<String> notContain = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if(!list.contains(chars[i])){
                notContain.add(chars[i]);
            }
        }

        return sb.toString();
    }

}
