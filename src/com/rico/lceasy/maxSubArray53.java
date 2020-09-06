package com.rico.lceasy;

import java.beans.IntrospectionException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Rico
 * @date 2020/8/23 15:24
 * 给定一个整数数组 nums ，
 * 找到一个具有最大和的连续子
 * 数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */

public class maxSubArray53 {

    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return 0;
        }
        int[] dp = Arrays.copyOf(nums,len);
        for (int i = 1; i < dp.length; i++){
            //这一步很关键，就是当前的值和前一个值取大者
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }
        int sum = dp[0];
        for (int i = 0; i < dp.length; i++){
            if (sum < dp[i]){
                sum = dp[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
//        HashSet<Integer> set = new HashSet<>();
//        set.add(1);

    }
}
