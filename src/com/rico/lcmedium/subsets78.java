package com.rico.lcmedium;

import java.util.ArrayList;

import java.util.List;

/**
 * @author Rico_dds
 * @date 2020/7/3 14:40
 */
public class subsets78 {

    static int s = Integer.MAX_VALUE;
    static int min = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int t = 15;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] dp = new boolean[a.length];
        dfs(0,a,dp ,t, new ArrayList<>(),res);
        System.out.println(res);
    }

    static void dfs(int index ,int[] a,boolean[] dp,int t,ArrayList<Integer> list, List<List<Integer>> res){

        res.add(new ArrayList<>(list));
        for (int i = index; i < a.length; i++) {
            if (!dp[i]){
                dp[i] = true;
                list.add(a[i]);
                dfs(index + 1,a,dp,t - a[i],list,res);
                list.remove(list.size() - 1);
                dp[i] = false;
            }
        }

    }

}
