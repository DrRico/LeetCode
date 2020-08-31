package com.rico.tester;

/**
 * @author Rico_dds
 * @date 2020/8/31 9:51
 */

import java.util.*;
public class Main8_31_ZTE_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num*2];
        for (int i = 0; i < num * 2; i ++){
            arr[i] = sc.nextInt();
        }
        int co = 0;
        for(int i = 0; i < arr.length; i ++){
            for(int j = i + 1; j < arr.length; j ++){
                if(arr[i] > arr[j])co ++;
            }
        }
        System.out.println(co);
    }
}



