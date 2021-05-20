package com.springjobhunting.BAIDU;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2021/3/17 20:13
 */
public class BAIDU02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] res = new int[n][n];
        String s = sc.nextLine();
        for (int i = 0; i < n; i ++){
            s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                res[i][j] = s.charAt(j) == '1' ? 1 : 0;
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (res[i][j] == 0){
                    if (res[i+1][j] == 1 && res[i-1][j] == 1 &&  res[i][j+1] == 1 || res[i][j-1] == 1){
                        res[i][j] = 1;
                    }
                    if (res[i+1][j] == 1 && res[i-1][j] == 1 ||  res[i][j+1] == 1 && res[i][j-1] == 1){
                        res[i][j] = 1;
                    }
                    if (res[i+1][j] == 1 || res[i-1][j] == 1 &&  res[i][j+1] == 1 && res[i][j-1] == 1){
                        res[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(res[i][j]);
            }
            System.out.println(sb.toString());
        }
    }
}
