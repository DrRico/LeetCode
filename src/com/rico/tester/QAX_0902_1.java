package com.rico.tester;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/9/2 14:59
 */
public class QAX_0902_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.substring(1,s.length() - 1).split(",");
        int[] num = new int[arr.length];
        for (int i = 0; i < arr.length; i ++){
            num[i] = Integer.valueOf(arr[i]);
        }
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
        System.out.println(count);///[4,1,3,3,3]
    }
}
