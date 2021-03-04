package com.springjobhunting.newcoder;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Rico_dds
 * @date 2021/3/1 14:51
 */
public class getLeastNumbers {
    public static void main(String[] args) {
        int[] arr = {3,2,1}, arr1 = {0,1,2,1};
        int k = 2,k1 = 1;

        System.out.println(Arrays.toString(getLeastNumbers(arr, k)));
        System.out.println(Arrays.toString(getLeastNumbers(arr1, k1)));
    }
    static private int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int[] nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = queue.poll();
        }
        return nums;
    }

    static private int[] getLeastNumbers_1(int[] arr, int k) {
        Arrays.sort(arr);
        int[] nums = new int[k];
        for (int i = 0; i < k; i ++){
            nums[i] = arr[i];
        }
        return nums;
    }
}
