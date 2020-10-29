package com.rico.YueWen;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/10/21 18:51
 */
public class YueWen_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(",");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.valueOf(s[j]);
            }
        }
        System.out.println(Arrays.toString(arr[0]));
        System.out.println(Arrays.toString(arr[1]));
        System.out.println(Arrays.toString(arr[2]));
        System.out.println(Arrays.toString(arr[3]));


//        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int n = arr.length;
//        int [][] temp = new int[n][n];
//        int dst = n-1;
//        for (int i = 0; i < arr.length; i++,dst--) {
//            for (int j = 0; j < arr[0].length; j++) {
//                temp[j][dst] = arr[i][j];
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == n-1 && j == n-1) break;
//                System.out.print(temp[i][j]+",");
//            }
//        }
//        System.out.print(temp[n-1][n-1]);
    }
}
