package com.rico.lcmedium;

/**
 * @author Rico
 * @date 2020/8/23 9:47
 */

public class maxArea11 {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length;
        int sum = 0, maxSum = 0;
        while (right > left){
            sum = Math.min(height[left],height[right]) * (right - left);
            maxSum = Math.max(maxSum,sum);
            if (height[left] > height[right]){
                right --;
            } else {
                left ++;
            }
        }
        return maxSum;
    }

}
