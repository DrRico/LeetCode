package com.springjobhunting.newcoder;

/**
 * @author Rico_dds
 * @date 2021/3/2 15:24
 */
public class minArray {
    public static void main(String[] args) {
        int[] arr1 = {3,4,5,1,2};
        int[] arr2 = {2,2,2,0,1};
        int[] arr3 = {1,3,5};

        System.out.println(findMin(arr1));
        System.out.println(findMin(arr2));
        System.out.println(findMin(arr3));
    }
    static private int findMin(int[] numbers){
        int len = numbers.length;
        int left = 0, right = len - 1;
        while (right > left) {
            int mid = left + ((right - left) >> 1);
            if (numbers[left] > numbers[mid]){
                right = mid;
            } else if (numbers[mid] > numbers[right]){
                left = mid + 1;
            } else {
                right --;
            }
        }
        return numbers[left];
    }
}
