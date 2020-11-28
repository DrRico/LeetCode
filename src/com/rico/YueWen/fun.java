package com.rico.YueWen;

/**
 * @author Rico_dds
 * @date 2020/11/24 14:53
 */
public class fun {
    public static void main(String[] args) {
        System.out.println(function(4));
    }

    private static int function(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i ++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    private static int func(int n){
        if(n <= 2){
            return n;
        } else {
            return func(n - 1) + func(n - 2);
        }
    }
}
