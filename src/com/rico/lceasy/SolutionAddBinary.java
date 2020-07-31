package com.rico.lceasy;

/**
 * @author Rico_dds
 * @date 2020/7/30 14:38
 */
public class SolutionAddBinary {

    public static String addBinary(String a, String b) {
        int aa = Integer.parseInt(a,2);
        int bb = Integer.parseInt(b,2);
        int result,carry;
        do{
            result = aa ^ bb;
            carry = (aa & bb)<<1;
            aa = result;
            bb = carry;
        }while (carry != 0);
        return Integer.toBinaryString(result);
    }

    public static String addBinary_1(String a, String b) {
        int n = Math.max(a.length(),b.length());
        StringBuilder s = new StringBuilder();
        int carry = 0;
        for (int i = 0; i<n; i++){
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            s.append(carry % 2) ;
            carry = carry/2;
        }
        if (carry > 0){
            s.append('1') ;
        }
        s.reverse();
        return s.toString();
    }


    public static String addBinary_2(String a, String b) {
        int len1 = a.length(),len2 = b.length();
        StringBuilder s = new StringBuilder();
        int carry = 0;
        for (int i= len1 - 1,j =len2 - 1; i>=0||j>=0; j--,i--){
            carry += i>=0 ? a.charAt(i)-'0' : 0;
            carry += j>=0 ? b.charAt(j)-'0' : 0;
            s.append(carry % 2);
            carry = carry >>1;
        }
        s.append(carry==1?carry:"");
        return s.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary_2("111","101"));
    }
}
