package com.springjobhunting.newcoder;

/**
 * @author Rico_dds
 * @date 2021/4/6 10:36
 */
public class removeDuplicates80 {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(arr));
    }
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 2) return len;
        int index = 2, i = 2;
        while (i < len){
            if (nums[index-2] != nums[i]){
                nums[index]= nums[i];
                index++;
            }
            i ++;
        }
        return index;
    }
}
