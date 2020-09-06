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
    public static int trap_fail(int[] height) {
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
        int[] c ={2,0,2};
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        //System.out.println(trap(a));
        //System.out.println(cal(a, 3, 7));
        int[] b = {0,1,0};
        System.out.println(trap_dp(c));
        System.out.println(trap_dp(b));
    }

    public static int trap_dp(int[] height) {
        int len = height.length;
        if (len <= 2) return 0;
        int res = 0;
        int[] leftArr = new int[len];
        int[] rightArr = new int[len];
        int max = 0;
        // 从左边遍历的最大值
        for (int i = 0; i < len; i++) {
            if (max <= height[i]){
                max = height[i];
            }
            leftArr[i] = max;
        }
        // 从右边遍历的最大值
        max = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (max <= height[i]){
                max = height[i];
            }
            rightArr[i] = max;
        }

        for (int i = 0; i < len; i++) {
            res += Math.min(leftArr[i],rightArr[i]) - height[i];
        }

        return res;
    }



    public static int trap(int[] height) {
        int len = height.length;
        if (2 >= len) {
            return 0;
        }
        int max = 0, index = 0;
        for (int i = 0; i < len; i++) {
            if (height[i] >= max) {
                max = height[i];
                index = i;
            }
        }

        int left = left(index, height);
        int right = right(index, height);

        return left + right;
    }

    private static int left (int ind , int[] height){
        // 判断出口
        if (ind == 0) return 0;
        int index = ind - 1;
        int max = 0, i = 0;
        for (;index >= 0;index --){
            if (height[index] >= max){// 继续求最大值
                max = height[index];
                i = index;
            }
        }
        int area = max * (ind - (i + 1));// 求总面积

        int solid = 0;
        index = i + 1;
        for(;index < ind; index ++){// 求石头部分，即数组中非空的部分
            solid += height[index];
        }

        int res = area - solid + left(i,height);// 求有效面积

        return res;
    }


    private static int right (int ind , int[] height){
        // 判断出口
        if (ind == height.length - 1) return 0;
        int max = 0, i = 0;
        int index = ind + 1;
        for (;index < height.length; index ++){
            if (max <= height[index]){// 继续求最大值
                max = height[index];
                i = index;
            }
        }
        int area = max * (i - (ind + 1));// 求总面积

        int solid = 0;
        index = i - 1;
        for (;index > ind; index --){// 求石头部分，即数组中非空的部分
            solid += height[index];
        }
        int res = area - solid + right(i, height);// 求有效面积

        return res;
    }

}
