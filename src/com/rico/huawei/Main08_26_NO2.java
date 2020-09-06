package com.rico.huawei;
import java.util.*;

/**
 * @author Rico_dds
 * @date 2020/8/28 19:37
 * 和lc84很像：​84:  给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * ​	            求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 此题中给两个数组，一个是宽度信息，即宽度不全是1，可以2、3、..，-1则返回0即可，另一个就是高低信息；
 *
 * 思路，装换成简单的宽度为1的数组即可！！！
 */


public class Main08_26_NO2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] string = str.split("],\\[");
        String xStr = string[0].substring(1);
        String yStr = string[1].substring(0,string[1].length() - 1);
        String[] xs = xStr.split(",");
        String[] ys = yStr.split(",");
        int[] x = new int[xs.length];
        int[] y = new int[ys.length];
        for (int i = 0; i < xs.length; i ++){
            x[i] = Integer.valueOf(xs[i]);
        }
        for (int i = 0; i < ys.length; i ++){
            y[i] = Integer.valueOf(ys[i]);
        }
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));

        // [1,2,3,2,1],[4,3,5,6,2]           [1,2,3,2,1    4,3,5,6,2]
        // [1,1,1,1,3,1,-1],[5,2,5,4,5,1,6]
        //int[] x = {1,1,1,1,3,1,2};
        //int[] y = {5,2,5,4,5,1,6};

        System.out.println(maxArea(x,y));
    }

    public static int maxArea(int[] x, int[] y){
        if (x.length ==0 || y.length == 0)return 0;
        int newLength = 0;
        for (int i = 0;i < x.length; i ++){
            if(x[i]>100 || x[i] < 1)return 0;
            newLength += x[i];
        }
        newLength = newLength + 2;
        int[] arr = new int[newLength];
        arr[0] = 0;
        arr[newLength - 1] = 0;
        for (int i = 0,j = 1;i < x.length; i ++){
            int temp = x[i];
            while (temp-- >= 1){
                arr[j++] = y[i];
            }
        }

        // 使用栈来完成；
        Deque<Integer> stack = new ArrayDeque<>(newLength);
        stack.addLast(0);
        int maxArea = 0;
        for (int i = 1;i < newLength; i ++){
            while (arr[i] < arr[stack.peekLast()]){
                int curH = arr[stack.pollLast()];
                int curW = i - stack.peekLast() - 1;
                maxArea = Math.max(maxArea, curH * curW);
            }
            stack.addLast(i);
        }

        return maxArea;
    }

}
