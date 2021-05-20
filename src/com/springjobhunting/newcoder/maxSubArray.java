package com.springjobhunting.newcoder;

import java.util.Arrays;

/**
 * @author Rico_dds
 * @date 2021/3/7 11:05
 */
public class maxSubArray {
    public static void main(String[] args) {
        int[] arr1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] arr2 = {-2,1};
        System.out.println(find(arr1));
        System.out.println(find(arr2));
    }
    private static int find(int[] arr){
        int len = arr.length;
        int[] res = Arrays.copyOf(arr,len);
        int max = res[0];
        for (int i = 1; i < len; i++) {
            res[i] = Math.max(res[i], res[i-1]+res[i]);
            max = Math.max(max, res[i]);
        }
        return max;
    }
}
