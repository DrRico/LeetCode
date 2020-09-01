package com.rico.lcmedium;

import java.security.interfaces.ECKey;
import java.util.*;

/**
 * @author Rico_dds
 * @date 2020/8/31 15:39
 */
public class lengthOfLongestSubstring03 {
    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring_2("pwwkew")); // 3
        System.out.println(lengthOfLongestSubstring_2("aab"));    // 2
        System.out.println(lengthOfLongestSubstring_2("dvdf"));   // 3
        System.out.println(lengthOfLongestSubstring_2("ddddd"));   // 1
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len <= 1) return len;
        HashSet<Character> set = new HashSet<>();
        int maxCount = 0;
        int left = 0;
        int right = 0;
        set.add(s.charAt(0));
        while (left < len){
            while (right + 1 < len && !set.contains(s.charAt(right + 1))){

                set.add(s.charAt(right + 1));
                right ++;
            }
            maxCount = Math.max(maxCount, right - left + 1);
            if (len == (right + 1)){
                break;
            }
            set.remove(s.charAt(left));
            left ++;

        }
        return maxCount;
    }

    public static int lengthOfLongestSubstring_1 (String s) {
        if (s.length() == 0) {
            return 0;
        }
        int inlen = s.length();
        int result = 0;
        int start = 0;  // 左指针初始位置
        int end = 0;    // 右指针初始位置
        HashSet<Character> subset = new HashSet<>();
        subset.add(s.charAt(0)); // 先把第0个字符放入Set

        while (start < inlen) {
            // 先判断长度，再判断是否包含字符，避免越界
            // end初始位置是0，0号字符已被加入集合，从下一个字符开始计算
            while (end + 1 < inlen && ! subset.contains(s.charAt(end + 1)) ) {
                subset.add(s.charAt(end + 1));
                end++;
            }
            result = Math.max(result, end - start + 1);
            if (end + 1 == inlen) { // 右指针移动到最后，可以终止计算，不需要再循环
                break;
            }
            subset.remove(s.charAt(start));
            start ++;
        }

        return result;
    }

    public static int lengthOfLongestSubstring_2(String s) {
        int len = s.length();
        if (len < 2) return len;

        int left = 0;
        int right = 0;
        int maxSum = 0;

        Set<Character> set = new HashSet<Character>();

        while (left < len){
            while (right < len && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right ++;
            }
            maxSum = Math.max(maxSum, right - left);
            set.remove(s.charAt(left++));   // 将第一个出现重复字符的头去掉如abcdaqwe,将b前面的a去掉
        }

        return maxSum;
    }
}
