package com.rico.lcmedium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Rico_dds
 * @date 2020/8/30 19:59
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class longestPalindrome05 {
    public static String longestPalindrome(String s) {
        if (s.length() == 0) return s;
        int res = 1;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i ++){
            int l = i - 1;
            int r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                int len = r - l;
                if(res < len){
                    res = len;
                    left = l;
                    right = r;
                }
                l --;
                r ++;
            }
            l = i;
            r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                int len = r - l;
                if(res < len){
                    res = len;
                    left = l;
                    right = r;
                }
                l --;
                r ++;
            }
        }
        return s.substring(left, right + 1);
    }

    public static String longestPalindrome_dp(String s) {
        int len = s.length();
        if (len < 2) return s;

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i ++){
            dp[i][i] = true;
        }

        int maxLen = 1;
        int begin = 0;
        char[] arr = s.toCharArray();

        for (int j = 1; j < len; j ++){
            for (int i = 0; i < j; i ++){
                if(arr[i] != arr[j]){
                    dp[i][j] = false;
                } else {
                    if(j - i < 3){
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }





    public static void main(String[] args) {
        System.out.println(longestPalindrome_dp("dddddddd"));
        System.out.println(longestPalindrome("dddddddd"));
    }
}
