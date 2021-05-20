package com.springjobhunting.newcoder;

import java.util.Arrays;

/**
 * @author Rico_dds
 * @date 2021/3/5 21:43
 */
public class spiralArrayOrder {
    public static void main(String[] args) {
        int[][] arr1 = {{1,11},{2,12},{3,13},{4,14},{5,15},{6,16},{7,17},{8,18},{9,19},{10,20}};
        int[][] arr2 = {{1,2,3,4},{4,5,6,6},{7,8,9,10}};
        System.out.println(Arrays.toString(spiralOrder(arr1)));
        System.out.println(Arrays.toString(spiralOrder(arr2)));
    }
    public static int[] spiralOrder(int[][] matrix) {
        int n = matrix.length;
        if(n == 0) return new int[]{};
        int m = matrix[0].length;
        int[] res = new int[n*m];
        int up = 0,down = n - 1, left = 0, right = m - 1;
        int index = 0;
        while (true){
            for(int i = left; i <= right; i ++){     // 左到右
                res[index ++] = matrix[up][i];
            }
            if(++up > down) break;

            for(int i = up; i <= down; i ++){        // 上到下
                res[index ++] = matrix[i][right];
            }
            if(--right < left) break;

            for(int i = right; i >= left; i --){     // 右到左
                res[index ++] = matrix[down][i];
            }
            if(--down < up) break;

            for(int i = down; i >= up; i --){     // 下到上
                res[index ++] = matrix[i][left];
            }
            if(++left > right) break;
        }
        return res;
    }

}
