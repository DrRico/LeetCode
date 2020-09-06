package com.rico.huawei;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/8/25 14:35
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 * 输入描述:
 *  输入一个整数（int类型）
 * 输出描述:
 *  这个数转换成2进制后，输出1的个数
 * 示例1
 * 输入
 * 5
 * 输出
 * 2
 */
public class Main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int cnt = 0;
        while (num != 0){
            if((num&1)==1)cnt++;
            num = num >> 1;
        }
        System.out.println(cnt);
    }
}
