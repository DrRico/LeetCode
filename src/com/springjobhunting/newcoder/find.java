package com.springjobhunting.newcoder;

/**
 * @author Rico_dds
 * @date 2021/3/15 16:14
 */
public class find {
    public static void main(String[] args) {
        int[] arr =  {4,2,3,10};
        int[] arr1 = {0,0,0,10};
        int[] arr2 = {1,100,2,3,4,5,6};
        int[] arr3 = {4,3,2,0};

        System.out.println(find1(arr));
        System.out.println(find1(arr1));
        System.out.println(find1(arr2));
        System.out.println(find1(arr3));

    }
    public static int find1(int[] arr){
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int price : arr) {
            min = Math.min(price, min);
            sum = Math.max(price - min, sum);
        }
        return sum;
    }
    public static int find(int[] arr){
        int len = arr.length - 1;
        int max = len;
        int min = 0;
        int left = 0, right = len;
        int res = 0;
        while (right > left){
            if(arr[left] < arr[min]){
                min = left;
            } else {
                left ++;
            }
            if(arr[right] > arr[max]){
                max = right;
            } else {
                right --;
            }
            res = Math.max(arr[max] - arr[min], max);
        }

        if (res > 0)return res;
        else  return 0;
    }
}
