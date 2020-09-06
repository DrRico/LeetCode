package com.rico.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/8/25 9:59
 *
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 * 接口说明
 *  * 反转句子
 *  * @param sentence 原句子
 *  * @return 反转后的句子
 *public String reverse(String sentence);
        *输入描述:
        *将一个英文语句以单词为单位逆序排放。
        *输出描述:
        *得到逆序的句子
        *示例1
        *输入
        *I am a boy
        *输出
        *boy a am I
 */
public class Main01 {
    public static String reverse(String sentence){
        StringBuilder stringBuilder = new StringBuilder();
        String[] s = sentence.split(" ");     // 分割字符串
        for (int i = s.length - 1; i >= 0; i --){   // 倒序输出
            stringBuilder.append(s[i]+ " ");        // 添加到sb中
        }
        return stringBuilder.toString();            // 返回结果
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(reverse(string));
    }

}
