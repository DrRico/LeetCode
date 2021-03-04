package com.springjobhunting.newcoder;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2021/2/28 10:05
 */
public class addBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int len1 = s1.length() - 1;
        int len2 = s2.length() - 1;
        int sum, num1,num2,carry = 0;
        StringBuilder sb = new StringBuilder();
        while (len1 >=0 || len2 >= 0 || carry != 0){
            num1 = (len1 < 0) ? 0 : s1.charAt(len1) - '0';
            num2 = (len2 < 0) ? 0 : s2.charAt(len2) - '0';
            sum = num1 + num2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            len1 --;
            len2 --;
        }
        System.out.println(sb.reverse().toString());
    }
}
