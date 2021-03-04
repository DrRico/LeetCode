package com.springjobhunting.newcoder;

import java.util.Arrays;

/**
 * @author Rico_dds
 * @date 2021/3/3 21:59
 */
public class exchangeOddAndEven {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
        // int[] arr1 = {1,67,34,3,87,12,86,256,49,26,6579,36,456,345};
        System.out.println(Arrays.toString(exchange(arr1)));
    }
    static private int[] exchange(int[] arr){
        int left = 0, right = arr.length - 1;
        while (right > left) {
            if ((arr[left] & 1) == 1){
                left ++;
                continue;
            }
            if ((arr[right] & 1) == 0){
                right --;
                continue;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        return arr;
    }
}
