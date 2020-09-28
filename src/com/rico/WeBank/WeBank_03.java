package com.rico.WeBank;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/9/20 19:09
 */

/*6
        2 3 5 4 3 3*/
public class WeBank_03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                //int num = sc.nextInt();
                int[] nums = new int[n];
                for (int j = 0; j < n; j++) {
                    nums[j] = sc.nextInt();
                }
                int count = 0;
                for (int j = 0; j < n; j++) {
                    for (int k = j; k < n; k++) {
                        for (int l = k; l < n; l++) {
                            if ((nums[i] < nums[j] && nums[j] < nums[l]))count ++;
                        }
                    }
                }
                System.out.println(count);
            }
        }


    }

}
