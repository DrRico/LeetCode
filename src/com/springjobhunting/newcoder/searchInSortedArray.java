package com.springjobhunting.newcoder;

/**
 * @author Rico_dds
 * @date 2021/3/8 14:32
 */
public class searchInSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {5,7,7,8,8,8,8,9,9,9,10};
        System.out.println(find(arr1,7));
    }
    private static int find(int[] nums, int target){
        int len = nums.length;
        if(len == 0) return 0;
        int left = 0, right = len - 1;
        int cnt = 0;
        while(left <= right){
            if(nums[left] < target){
                left ++;
                cnt ++;
            } else if (nums[right] > target){
                right --;
                cnt ++;
            } else {
                return len - cnt;
            }
        }
        return 0;
    }
}
