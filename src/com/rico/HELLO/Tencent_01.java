package com.rico.HELLO;

/**
 * @author Rico_dds
 * @date 2020/11/1 16:43
 */
public class Tencent_01 {
    public static void main(String[] args) {
        String a = "9999";
        String b = "9999";
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        int lenA = a.length();
        int lenB = b.length();
        int num1 = 0, num2 = 0;
        int i = lenA - 1, j = lenB - 1;
        int n = 0, m = 0;
        StringBuilder s = new StringBuilder();
        while (i >= 0 || j >= 0){
            if (i >= 0){
                num1 = a1[i] - '0';
            } else {
                num1 = 0;
            }
            if (j >= 0){
                num2 = b1[j] - '0';
            } else {
                num2 = 0;
            }
            int sum = num1 + num2 + n;
            m = sum % 10;
            n = sum / 10;
            char c =(char) (m + '0');
            s.append(c);
            i -- ;
            j -- ;
        }
        if (n != 0) s.append('1');
        System.out.println(s.reverse().toString());
    }
}