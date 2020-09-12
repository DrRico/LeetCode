package com.rico.vivo;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/9/12 18:51
 */
public class Main_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(!isHuiwen(str)){
            System.out.println(false);
            return;
        } else {
            StringBuilder sb = new StringBuilder(str);
            for (int i = 0; i < sb.length(); i++) {
                char ss = sb.charAt(i);
                if (isPalindrome(sb.deleteCharAt(i).toString())){
                    System.out.println(sb.toString());
                    return;
                }
                sb.insert(i,ss);
            }

        }
    }
    static int del = 0;
    private static boolean isHuiwen(String s){
        int low = 0, hi = s.length() - 1;
        while (low < hi){
            if (s.charAt(low) == s.charAt(hi)){
                low ++;
                hi --;
            } else {
                if (del == 0){
                    del ++;
                    return isHuiwen(s.substring(low,hi)) || isHuiwen(s.substring(low + 1, hi + 1));
                }
                return false;
            }

        }
        return true;
    }
    public static boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

}
