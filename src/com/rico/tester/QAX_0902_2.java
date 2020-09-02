package com.rico.tester;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/9/2 14:59
 */
public class QAX_0902_2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int[] dp = new int[input +1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= input; i ++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[input]);

    }


    static int fun(int n){
        if(n<=0 || n >= 36){
            return 0;
        } else if (n <= 2){
            return n;
        } else {
            return fun(n - 1) + fun(n - 2);
        }

    }
}
