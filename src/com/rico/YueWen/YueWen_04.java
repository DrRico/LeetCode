package com.rico.YueWen;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/10/21 20:18
 */
public class YueWen_04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String[][] arr = new String[n][4];
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(",");
            arr[i] = s;
        }

        for (int i = 0; i < n; i++) {
            //System.out.println(Arrays.toString(arr[i]));
            //arr[i] = s;
            System.out.println(arr[i][0]);
        }
    }

}
