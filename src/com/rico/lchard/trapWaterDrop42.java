package com.rico.lchard;

import sun.security.provider.Sun;

/**
 * @author Rico_dds
 * @date 2020/9/3 22:37
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 */
public class trapWaterDrop42 {
    public static int trap(int[] height) {
        int len = height.length;
        if (len <= 2) return 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (height[left] == 0){
            left ++;
            right ++;
        }
        while (right < len){// 思路应该是要借鉴84题，使用栈去解决的！！先这样明天再看~
            while (right < len && height[left] >= height[right]){
                right ++;
            }
            sum += cal(height,left,right);
            left = right;
        }
        return sum;
    }

    public static int cal(int[] height,int left,int right){
        int sum = (right - left - 1) * Math.min(height[left],height[right]);
        while (left + 1 < right){
            sum -= height[left + 1];
            left ++;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(a));
        //System.out.println(cal(a, 3, 7));
    }
}
