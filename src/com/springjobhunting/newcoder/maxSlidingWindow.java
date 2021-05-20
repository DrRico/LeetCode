package com.springjobhunting.newcoder;

import java.util.Arrays;

/**
 * @author Rico_dds
 * @date 2021/3/20 10:54
 */
public class maxSlidingWindow {
    public static void main(String[] args) {
        int[] a1 = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(find(a1, 3)));

    }
    private static int[] find(int[] arr, int k){    // 暴力破解
        int len = arr.length;
        int[] res = new int[len - k + 1];
        for (int i = 0; i < len - k + 1; i++) {
            int max = arr[i];
            for (int j = 0; j < k; j++) {
                max = Math.max(max, arr[j + i]);
            }
            res[i] = max;
        }
        return res;
    }

    private static int[] find_1(int[] arr, int k){


        return new int[0];
    }
}
