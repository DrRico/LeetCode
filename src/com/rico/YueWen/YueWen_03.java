package com.rico.YueWen;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/10/21 18:51
 */
public class YueWen_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        int m = Integer.valueOf(s[0]),p = Integer.valueOf(s[1]),n =Integer.valueOf(s[2]);
        int[][] a = new int[m][p],b = new int[p][n];
        for (int i = 0; i < m; i++) {
            String[] string = sc.nextLine().split(",");
            for (int j = 0; j < p; j++) {
                a[i][j] = Integer.valueOf(string[j]);
            }
        }

        for (int i = 0; i < p; i++) {
            String[] string = sc.nextLine().split(",");
            for (int j = 0; j < n; j++) {
                b[i][j] = Integer.valueOf(string[j]);
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < b.length; k++) {
                    res[i][j]+=a[i][k] * b[k][j];
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length - 1; j++) {
                System.out.print(res[i][j] + ",");
            }
            System.out.println(res[i][res[0].length - 1]);
        }
    }
}
