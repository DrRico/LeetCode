package com.springjobhunting.MEITUAN;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2021/3/13 15:55
 */
public class MEITUAN01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] res =  fun(arr,n,m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static int[][] fun(int[][] arr,int n,int m){
        int[][] res = new int[m][n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[j][k] = arr[i][j];
            }
            k ++;
        }
        return res;
    }
}
