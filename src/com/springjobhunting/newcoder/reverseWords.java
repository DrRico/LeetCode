package com.springjobhunting.newcoder;

/**
 * @author Rico_dds
 * @date 2021/3/17 15:27
 */
public class reverseWords {
    public static void main(String[] args) {
        String s1 = "the sky is blue";
        String s2 = "  hello world!  ";
        String s3 = "a good   example";
        System.out.println(handle(s1));
        System.out.println(handle(s2));
        System.out.println(handle(s3));
        System.out.println(handle(""));
        System.out.println(handle(" "));
        System.out.println(handle("  "));

    }
    public static String handle(String s) {
        String[] string = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = string.length - 1; i > 0; i --){
            if (!string[i].equals(" ") && !string[i].equals("")){
                sb.append(string[i]);
                sb.append(" ");
            }
        }
        sb.append(string[0]);
        return sb.toString();
    }
}
