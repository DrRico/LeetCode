package com.springjobhunting.newcoder;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2021/3/10 20:06
 */
public class SF01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] ss = str.split(" ");
        int n,q;
        n = Integer.parseInt(ss[0]);
        q = Integer.parseInt(ss[1]);
        String[] score = sc.nextLine().split(" ");
        int[] scorenum = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            scorenum[i] = Integer.parseInt(score[i]);
        }
        while (q > 0){
            String scs = sc.nextLine();
            if(scs.equals("")) continue;
            q --;
            String[] scss = scs.split(" ");
            int left = Integer.parseInt(scss[0]);
            int right = Integer.parseInt(scss[1]);
            if ((right - left) < 2){
                System.out.println("NoScore");
                continue;
            }
            int sum = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = left - 1; i < right; i++) {
                sum += scorenum[i];
                if (scorenum[i] > max) max = scorenum[i];
                if (scorenum[i] < min) min = scorenum[i];
            }
            sum = sum - max - min;
            System.out.println(sum/(right - left - 1));
        }

    }
}
