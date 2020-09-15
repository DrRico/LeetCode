package com.rico.tester;

import java.util.ArrayList;

import java.util.List;

/**
 * @author Rico_dds
 * @date 2020/7/3 14:40
 */
public class TestInteger {

    static int s = Integer.MAX_VALUE;
    static int min = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] a = {1,2,9,5,8,10};
        int t = 15;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] dp = new boolean[a.length];
        dfs(0,a,dp ,t, new ArrayList<>(),res);
        System.out.println(res);
    }

    static void dfs(int index ,int[] a,boolean[] dp,int t,ArrayList<Integer> list, List<List<Integer>> res){
        if (t <= 0){
            if (list.size() < s || t > min){
                s = list.size();
                min = t;
                res.clear();
                res.add(new ArrayList<>(list));
                return;
            }
        }
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
