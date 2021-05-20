package com.springjobhunting.newcoder;

import java.util.Arrays;

/**
 * @author Rico_dds
 * @date 2021/3/15 9:22
 */
public class twoSumOffer57 {
    public static void main(String[] args) {
        int[] arr = {10,26,30,31,47,60};
        int t = 40;
        System.out.println(Arrays.toString(find(arr, t)));
    }
    private static int[] find(int[] arr, int t){
        for (int i = 0; i < arr.length - 1; i++) {
            int left = i + 1, right = arr.length - 1, target = t - arr[i];
            while (left <= right){
                int mid = left + ((right - left) >> 1);
                if (arr[mid] > target){
                    right = mid - 1;
                } else if (arr[mid] < target){
                    left = mid + 1;
                } else {
                    return new int[]{arr[i], target};
                }
            }
        }
        return new int[]{};
    }
}
