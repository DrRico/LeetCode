package com.springjobhunting.BAIDU;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2021/3/17 20:35
 */
public class BAIDU03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] res = new int[n][n];
        String s = sc.nextLine();
        for (int i = 0; i < n; i ++){
            String[] ss = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                res[i][j] = Integer.parseInt(ss[j]);
            }
        }
        int[][] dp = new int[n][n];
        dp[0][0] = res[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + res[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + res[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] - dp[i][j], res[i][j] - dp[i][j-1]);
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}
