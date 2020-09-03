package com.rico.lchard;

import java.util.Arrays;

/**
 * @author Rico_dds
 * @date 2020/9/3 15:02
 */
public class candy135 {
    public static int candy(int[] num) {
        int[] left = new int[num.length];
        int[] right = new int[num.length];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for (int i = 1; i < num.length; i ++){
            if(num[i] > num[i - 1]) left[i] = left[i - 1] + 1;
        }
        int count = left[num.length - 1];
        for (int i = num.length - 2; i >= 0; i --){
            if(num[i] > num[i + 1])right[i] = right[i+1] + 1;
            count += Math.max(left[i],right[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        // int[] a = {1,2,2};
        // int[] a = {1,3,2,2,1};
        int[] a = {1,2,87,87,87,2,1};

        System.out.println(candy(a));
    }
}
