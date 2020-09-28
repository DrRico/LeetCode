package com.rico.WeBank;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/9/20 19:09
 */
public class WeBank_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] nums = new int[n];
        for (int j = 0; j < n; j++) {
            nums[j] = sc.nextInt();
        }
        String temp = sc.nextLine();
        for (int i = 0; i <= q; i++) {
        //while (sc.hasNextLine()){
            String nn = sc.nextLine();
            int nnn = Integer.valueOf(nn);
            //System.out.println(nn);
            System.out.println(find(nnn, nums));
        }
    }

    public static int find(int n , int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid =  (right + left)/2;
            if (nums[mid] == n){
                return nums[mid];
            } else if (nums[mid] > n){
                right= mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

}
