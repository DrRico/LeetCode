package com.springjobhunting.newcoder;

/**
 * @author Rico_dds
 * @date 2021/3/1 12:02
 */
public class findRepeatNumber {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int tmp;
        for (int i = 0; i < nums.length; i ++){
            if (i == nums[i]) continue;
            if (nums[i] == nums[nums[i]]){
                System.out.println(nums[i]);
                return;
            }
            tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        System.out.println(-1);
    }
}
