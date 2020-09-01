package com.rico.lcmedium;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.*;

/**
 * @author Rico_dds
 * @date 2020/9/1 10:43
 */
public class permute46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        boolean[] dp = new boolean[nums.length];
        dfs(dp,nums,new ArrayList<Integer>(),res);
        return res;
    }
    static void dfs(boolean[] dp, int[] nums, List<Integer> list, List<List<Integer>> res){
        // 截止条件
        if(list.size() == nums.length){
            res.add(new ArrayList(list));
            return;
        }
        // 遍历候选节点
        for (int i = 0; i < nums.length; i ++){
            if(!dp[i]){
                dp[i] = true;
                list.add(nums[i]);
                dfs(dp, nums,list,res);
                dp[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a ={1,2,3};
        System.out.println(permute(a));
    }

}
