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
        int lena = a.length() - 1;
        int lenb = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0, n1, n2, sum;
        while (lena >= 0 || lenb >= 0 || carry != 0){
            n1 = lena >= 0 ? a.charAt(lena) - '0' : 0;
            n2 = lenb >= 0 ? b.charAt(lenb) - '0' : 0;
            sum = n1 + n2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            lena --;
            lenb --;
        }
        System.out.println(sb.reverse().toString());
    }

}
