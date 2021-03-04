package com.springjobhunting.newcoder;

/**
 * @author Rico_dds
 * @date 2021/3/4 8:42
 */
public class majorityElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(fun(arr));
    }
    static private int fun(int[] arr){
        int max = 1, cur = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == cur){
                max ++;
            } else {
                max --;
            }
            if (max == 0){
                cur = arr[i];
            }
        }
        if (max != 0) return cur;
        else return -1;
    }
}
