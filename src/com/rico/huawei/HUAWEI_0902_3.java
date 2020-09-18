package com.rico.huawei;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/9/2 18:58
 */
public class HUAWEI_0902_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int [] w = new int[n];
            int [] v = new int[n];
            for (int i = 0; i < n; i ++){
                w[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i ++){
                v[i] = scanner.nextInt();
            }
            System.out.println(maxValue(k,w,v));
        }

    }
    public static int maxValue(int k, int[] w, int[] v){
        int m[][] = new int[v.length][k+1];
        for (int i = 1; i < v.length; i ++){
            for (int j = 1;j <= k; j ++){
                if(j >= w[i]){
                    m[i][j] = m[i-1][j - w[i]] + v[i] > m[i-1][j] ? m[i-1][j - w[i]] + v[i] : m[i - 1][j];
                } else {
                    m[i][j] = m[i - 1][j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < v.length; i ++){
            for (int j = 0; j <= k; j ++){
                if(m[i][j] > max) max = m[i][j];
            }
        }
        return max;
    }
}
