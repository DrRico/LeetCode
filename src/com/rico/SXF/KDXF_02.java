package com.rico.SXF;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/9/17 18:56
 */
public class KDXF_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int len = Integer.valueOf(string);
        int[] arr = new int[len];
        String num = scanner.nextLine();
        String[] nums = num.split(",");
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }
        // System.out.println(Arrays.toString(arr));
        for (int i = 0; i < len - 1; i++) {
            int mIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[mIndex]){
                    mIndex = j;
                }
            }
            if (i != mIndex){
                int temp = arr[i];
                arr[i] = arr[mIndex];
                arr[mIndex]= temp;
            }
        }

        for (int i = 0; i < len - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[len-1]);
    }

}
