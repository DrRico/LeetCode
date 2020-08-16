package com.rico.tester;

/**

 * 题目描述
 * 给你一个含有n个元素的数组arr[i]，请你告诉牛牛这个数组的中位数大还是平
 * 均数大，如果中位数更大输出1，如果平均数更大输出-1，如果中位数和平均数相等输出0
 *
 * 示例1
 * 输入
 * [1,3,4]
 * 输出
 * 1
 * 说明
 * 中位数3，平均数约等于2.67，所以输出1
 *
 * 示例2
 * [7,4,8,11]
 * 输出
 * 0
 * 说明
 * 中位数7.5，平均数7.5，所以输出0
 *
 * 示例3
 * 输入
 * [6,6,6,6,5,8]
 * 输出
 * -1
 * 说明
 *
 * 中位数6，平均数约等于6.17，所以输出-1
 *
* */

import java.util.*;
public class Answerofjudge {

    public static int Answerofjudge (int[] arr){
        // write code here
        // write code here
        int len = arr.length;
        double sum = 0;
        double mid = 0;
        double avg = 0;
        Arrays.sort(arr);
        for (int i = 0; i < len; i ++){
            sum += arr[i];
        }
        avg = sum / len;
        if (len % 2 == 0){
            mid = (double)(arr[len / 2] + arr[len / 2 - 1]) / 2;
        } else {
            mid = arr[len / 2];
        }
        if (avg > mid){
            return -1;
        } else if (avg < mid){
            return 1;
        } else {
            return 0;
        }
    }


    public static void main(String[] args) {

        int[] a = {6,6,6,6,5,8};
        System.out.println(Answerofjudge(a));

    }

}













