package com.rico.newcoderCompetition;

/**
 * @author Rico_dds
 * @date 2020/11/17 21:30
 */
public class minDifference {
    public static void main(String[] args) {
        int a[] ={1,2,4};
        System.out.println(minDifference(a));
    }

    public static int minDifference (int[] a) {
        int min = Integer.MAX_VALUE;
        int len = a.length;
        for (int i = 0; i < len - 2; i ++){
            for (int j = i + 1; j < len - 1; j ++){
                if (a[i] == a[j]) return 0;
                if (min > Math.abs(a[i]-a[j])){
                    min = Math.abs(a[i]-a[j]);
                }
            }
        }
        return min;
    }

}
