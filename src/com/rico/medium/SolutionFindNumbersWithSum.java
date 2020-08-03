package com.rico.medium;

import java.util.ArrayList;

/**
 * @author Rico_dds
 * @date 2020/8/3 9:21
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */

public class SolutionFindNumbersWithSum {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0, j =array.length - 1;
        while (i>j){
            if ((array[i] + array[j]) == sum){
                list.add(array[i]);
                list.add(array[j]);
                return list;
            }else if ((array[i] + array[j]) < sum){
                i ++;
            }else if ((array[i] + array[j]) > sum){
                j --;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,2,4,7,11,15};
        System.out.println(FindNumbersWithSum(a,15));
    }
}

