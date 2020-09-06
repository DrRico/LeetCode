package com.rico.lcmedium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Rico_dds
 * @date 2020/9/4 14:45
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 *示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 */
public class numDecodings91 {

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("12120"));
    }

    public static int numDecodings(String s) {
        // 特殊情况的判断
        int len = s.length();
        if (len == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        int pre = 1, curr = 1;  // dp[-1] = dp[0] = 1
        char[] chars = s.toCharArray();
        for (int i = 1; i < len; i++) {
            int tmp = curr;
            if (chars[i] == '0'){
                if (chars[i-1] == '1' || chars[i-1] == '2') curr = pre;
                else return 0;
            } else if (chars[i-1] == '1' || (chars[i-1] == '2' && chars[i] >= '1' && chars[i] <= '6')){
                curr += pre;
            }
             pre = tmp;
        }
        return curr;

    }

}

















