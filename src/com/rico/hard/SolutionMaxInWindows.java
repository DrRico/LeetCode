package com.rico.hard;

import java.util.ArrayList;

/**
 * @author Rico_dds
 * @date 2020/8/3 21:02
 * 给定一个数组和滑动窗口的大小，
 * 找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}
 * 及滑动窗口的大小3，那么一共存在6个
 * 滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以
 * 下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 窗口大于数组长度的时候，返回空
 */
public class SolutionMaxInWindows {

    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (size > num.length){
            return list;
        }
        int len = num.length - size + 1;
        int[] result = new int[len];
        for (int i = 0; i < len; i ++){
            for (int j = i; j < size + i; j ++){
                result[i] = Math.max(result[i],num[j]);
            }
        }
        for(int i = 0; i < result.length; i ++){
            list.add(result[i]);
        }
        return  list;
    }

    public static void main(String[] args) {
        int[] a = new int[] {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(a,3));
    }

}
