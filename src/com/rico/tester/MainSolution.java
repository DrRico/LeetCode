package com.rico.tester;

/**
 * @author Rico_dds
 * @date 2020/7/31 20:48
 *
 * 题目描述
 * 输入一组未排序的整数，其中一个数字
 * 只出现一次，剩下的所有数字都出现了三
 * 次。找出这个只出现一次的数字。
 * 例如输入: [1,2,2,2,3,3,3]，输出为1
 * 输入描述:
 * 输入包含两行:
 *  第一行有一个整数n(1 ≤ n ≤ 100000),表示数组数
 *  字个数n,个数满足题意。 第二行为n个整数,范围均在
 *  32位整数,以空格分隔,保证输入数据合法
 * 输出描述:
 * 出现一次的那个数字
 * 示例1
 * 输入
 * 7 7 2 2 2 3 3 3
 * 输出
 * 1
 */
import java.util.*;
public class MainSolution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        int res = 0;
        for(int i = 0; i < 32; i++){//查看32个位置上面的数字为1的个数是否是3的倍数多1
            int bit = 1 << i;
            int count = 0;
            for(int j = 0; j < n; j ++){
                if((bit & array[j]) != 0)   //这里换成==1答案错误。为了区分可用这种方式：if((array[j] >> i) & 1 == 1)
                    count ++;
            }
            if(count%3 == 1)//代表单独出现的那个数字在 1<<i这个位置上有出现1，故将其相加
                res = res | bit;        //与上面的配套使用，可用使用 res |= 1<<i;
        }
        System.out.println(res);
    }

}
