package com.rico.newcoderCompetition;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author Rico_dds
 * @date 2020/11/18 9:18
 */
public class Maxsumforknumers {

    public static String Maxsumforknumers (String x, int k) {
        // write code here
        int[] arr = new int[10];
        for(int i = 0; i < x.length(); i++) {
            arr[x.charAt(i) - '0']++;
        }
        // System.out.println(x);
        int idx = 9;
        int[] nums = new int[x.length() - (k - 1) + 1];
        int start = 1;
        for(int j = 1; j <= x.length() - (k - 1); j++) {
            while(arr[idx] == 0) {
                idx--;
            }
            nums[start] = idx;
            arr[idx]--;
            start++;
        }
        // System.out.println("Line 29:" + Arrays.toString(nums));
        for(int i = 1; i <= k - 1; i++) {
            while(arr[idx] == 0) {
                idx--;
            }
            int add = idx;
            for (int j = nums.length - 1; j >= 0 ; j--) {
                add = add + nums[j];
                nums[j] = add % 10;
                if (add >= 10) {
                    add /= 10;
                } else {
                    break;
                }
            }
            arr[idx]--;
        }
        StringBuilder sb = new StringBuilder();
        if (nums[0] != 0) {
            sb.append(nums[0]);
        }
        for (int i = 1; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    public static String Maxsumforknumers_1(String x, int k){
        char[] chars = x.toCharArray();
        int[] arr = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            arr[i] = chars[i] - '0';
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int i;
        if (k == 1){
            for (i = arr.length - 1; i >= 0; i --) {
                sb.append(arr[i]);
            }
            return sb.toString();
        } else if (k == 2){
            for (i = arr.length - 1; i >= 1; i --) {
                sb.append(arr[i]);
            }
            BigDecimal num = new BigDecimal(arr[0]);
            return num.add(new BigDecimal(sb.toString())).toString();
        } else {
            for (i = arr.length - 1; i >= arr.length - 1 - (arr.length - k); i --) {
                sb.append(arr[i]);
            }
            BigDecimal decimal = new BigDecimal(sb.toString());
            for (int j = 0; j < i + 1; j++) {
                decimal = decimal.add(new BigDecimal(arr[j]));
            }
            return decimal.toString();
        }
    }

    public static void main(String[] args) {
        String x = "345";
        int k = 2;
        System.out.println(Maxsumforknumers_1 (x, k)); // 57

        x = "233333";
        k = 3;
        System.out.println(Maxsumforknumers_1 (x, k)); // 3338

        x = "111222333444555666777888999";
        k = 1;
        System.out.println(Maxsumforknumers_1 (x, k)); // 999888777666555444333222111

        x = "999";
        k = 2;
        System.out.println(Maxsumforknumers_1 (x, k)); // 108
    }
}
