package com.springjobhunting.newcoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Rico_dds
 * @date 2021/3/19 14:42
 */
public class findContinuousSequence {
    public static void main(String[] args) {
        int t = 15;
        findContinuousSequence(t);
    }
    public static int[][] findContinuousSequence(int target) {
        int half = target >> 1;
        ArrayList<int[]> res = new ArrayList<>();
        int left = 1, right = 1;
        int sum = 1;
        while (left <= half + 1){
            if(sum < target){
                right ++;
                sum += right;
            }
            else if(sum > target){
                left ++;
                sum -= left - 1;
            } else {
                int[] temp = new int[right - left + 1];
                for (int i = left, j = 0; i < right + 1; i++, j ++) {
                    temp[j] = i;
                }
                res.add(temp);
                sum -= left;
                left ++;
            }
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i)));
        }
        return res.toArray(new int[res.size()][]);
    }
}
