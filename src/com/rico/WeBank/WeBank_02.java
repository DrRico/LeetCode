package com.rico.WeBank;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/9/20 19:09
 */
public class WeBank_02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] min = new int[n];
        int[] max = new int[n];
        int[] nums = new int[n];
        for (int j = 0; j < n; j++) {
            nums[j] = sc.nextInt();
        }
        min[0] = nums[0];
        max[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            min[i] = Math.min(nums[i],min[i - 1]);
        }

        for (int i = n - 2; i >= 0; i --) {
            max[i] = Math.max(min[i],max[i + 1]);
        }
        int count = 0;

        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > min[i - 1] && nums[i] < max[i + 1]){
                count ++;
            }
        }
        System.out.println(count);
    }



}
