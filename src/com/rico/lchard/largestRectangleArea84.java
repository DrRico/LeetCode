package com.rico.lchard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Rico_dds
 * @date 2020/8/28 9:42
 *给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 */
public class largestRectangleArea84 {
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len == 0) return 0;
        int left, right, max = 0;
        for (int i = 0; i < len; i ++){
            left = i;
            right = i;
            while (left - 1 >= 0 && heights[i] <= heights[left - 1] ){
                left --;
            }
            while (right < len && heights[i] <= heights[right]){
                right ++;
            }
            max = Math.max(max, (right - left) * heights[i]);
        }
        return max;
    }

    public static int largestRectangleArea_1(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        if (len == 1) return heights[0];
        int res = 0;
        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }


    public static void main(String[] args) {
        // int[] a = {2,1,5,6,6,7};
        //int[] a = {1,2,3,4,5};
        int[] a = {2,1,5,6,2,3};

        System.out.println(largestRectangleArea_1(a));
    }
}
