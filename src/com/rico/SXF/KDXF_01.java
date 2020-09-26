package com.rico.SXF;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/9/17 18:55
 */
public class KDXF_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] ss = s.split(",");
        int[][] arr = new int[Integer.valueOf(ss[0])][Integer.valueOf(ss[1])];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(gift(arr));
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }

    }

    private static int gift(int[][] arr){
        int s = arr.length;
        int n = arr[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < s; i++) {
            dp[0] = dp[0] + arr[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.max(dp[j - 1], dp[j]) + arr[i][j];
            }
        }
        return dp[n - 1];
    }

}
