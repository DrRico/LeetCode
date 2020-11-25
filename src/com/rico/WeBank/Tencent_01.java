package com.rico.WeBank;

/**
 * @author Rico_dds
 * @date 2020/10/23 20:23
 */
public class Tencent_01 {
    // 腾讯面试手撕代码
    public static void main(String[] args) {
        String a = "12";
        String b = "12";
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0, numA, numB, sum;
        while (lenA >= 0 || lenB >= 0 || carry != 0){
            numA = lenA >= 0 ? a.charAt(lenA) - '0' : 0;
            numB = lenB >= 0 ? b.charAt(lenB) - '0' : 0;
            sum = numA + numB+ carry;
            sb.append(sum % 10);
            carry = sum / 10;
            lenA --;
            lenB --;
        }
        System.out.println(sb.reverse().toString());
    }

}
