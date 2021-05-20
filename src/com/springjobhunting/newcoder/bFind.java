package com.springjobhunting.newcoder;

/**
 * @author Rico_dds
 * @date 2021/3/10 12:29
 */
public class bFind {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11,12,13,16,17,19};
        int k = 13;
        System.out.println(bfind(arr,k));
    }
    private static int bfind(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if (arr[mid] < target){
                left = mid + 1;
            } else if (arr[mid] > target){
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
