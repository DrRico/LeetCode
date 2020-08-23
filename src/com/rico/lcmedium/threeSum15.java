package com.rico.lcmedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Rico
 * @date 2020/8/23 10:44
 * 给你一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条
 * 件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
示例：
给定数组 nums = [-1, 0, 1, 2, -1, -4]，
满足要求的三元组集合为：
[
    [-1, 0, 1],
    [-1, -1, 2]
]
 */

public class threeSum15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Arrays.sort(nums);
        int start , end;
        for (int i = 0; i < nums.length - 2; i ++){
            start = i + 1;
            end = nums.length - 1;
            if(i >= 1 && nums[i - 1] == nums[i])continue;
            while (start < end) {
                if ((nums[end] + nums[i] + nums[start]) > 0) {
                    end --;
                } else if ((nums[end] + nums[i] + nums[start]) < 0) {
                    start ++;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    res.add(new ArrayList<>(list));
                    start ++;
                    end --;
                    while (start < end && nums[start - 1] == nums[start]) start  ++;
                    while (start < end && nums[end + 1] == nums[end]) end  --;
                }
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        //int[] a = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        // int[] a = {-1,0,1,2,-1,-4};
        int[] a = {0, 0, 0, 0};

        // [[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]
        System.out.println(threeSum(a));
    }

}














