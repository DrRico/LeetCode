package com.rico.lceasy;

import java.util.Arrays;

/**
 * @author Rico_dds
 * @date 2020/9/1 21:07
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 */
public class addStrings415 {

    // 我自己的解法
    public static String addStrings(String num1, String num2) {
        // 特殊条件判断；
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0) return num2;
        if (len2 == 0) return num1;
        // 建立新数组，只需要在原来最大数值上加1即可
        int maxLen = Math.max(len1,len2) + 1;
        // 建立新数组，将参数传入到新数组上
        int[] res = new int[maxLen];
        int[] resTemp = new int[maxLen];
        // 进行对其操作如 99 和  999
        // 令新数组为:  0099 和 0999
        int k = maxLen - 1;
        for (int i = len1 - 1; i >= 0; i --){
            res[k --] = num1.charAt(i) - '0';
        }
        k = maxLen - 1;
        for (int i = len2 - 1; i >= 0; i --){
            resTemp[k -- ] = num2.charAt(i) - '0';
        }
        // 进行同位相加，并且不进行进位处理
        int i = 0;
        while (i < maxLen){
            res[maxLen - 1 - i] += resTemp[maxLen - 1 - i];
            i ++;
        }
        // 进行进位处理
        for (int j = maxLen - 1; j >= 1 ; j --){
            res[j - 1] += res[j] / 10;
            res[j] %= 10;
        }
        // 按格式输出
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < maxLen ; j ++){
            if (j == 0 && res[j] == 0) continue;
            sb.append(res[j]);
        }
        return sb.toString();
    }

    // 双指针解法
    public static String addStrings_1(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (len1 >= 0 || len2 >= 0 || carry != 0){
            int n1 = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int n2 = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            int sum = n1 + n2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            len1 --;
            len2 --;
        }
        return sb.reverse().toString();
    }



    public static void main(String[] args) {
        System.out.println(addStrings_1("9","97"));
        System.out.println(addStrings_1("1","1"));
        System.out.println(addStrings_1("999","999"));

    }

}
