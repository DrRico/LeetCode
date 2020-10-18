package com.rico.lcmedium;
import java.util.Arrays;

/**
 * @author Rico_dds
 * @date 2020/10/7 9:27
 */

public class sortColors75 {

    public static void main(String[] args) {
        int[] a = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(a));
        sortColors(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sortColors(int[] nums) {
        int p = 0, q = nums.length - 1;
        for (int i = 0; i <= q; i++) {
            if (nums[i] == 0){
                nums[i] = nums[p];
                nums[p] = 0;
                p ++;
            }
            if (nums[i] == 2){
                nums[i] = nums[q];
                nums[q] = 2;
                q --;
                i --;
            }
        }
    }
}
