package com.springjobhunting.newcoder;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2021/2/28 10:19
 */
public class numberOf1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int cnt = 0;
        while (num != 0){
            num = (num - 1) & num;
            cnt ++;
        }
        System.out.println(cnt);
    }
}
