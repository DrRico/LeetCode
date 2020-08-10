package com.rico.hard;

import java.sql.SQLOutput;

/**
 * @author Rico_dds
 * @date 2020/8/10 11:39
 * 地上有一个m行和n列的方格。一个机器
 * 人从坐标0,0的格子开始移动，每一次只
 * 能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之
 * 和大于k的格子。 例如，当k为18时，机
 * 器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class SolutionMovingCount {
    public static int movingCount(int threshold, int rows, int cols){
        boolean[][] isVisted = new boolean[rows][cols];
        int[] count = new int[1];
        dfs(threshold, rows, cols ,0, 0, count, isVisted);
        return count[0];
    }

    public static void dfs(int th, int m, int n, int i, int j, int[] count, boolean[][] isVisted) {
        if (sum(i) + sum(j) < th){
            count[0] ++;
            isVisted[i][j] = true;
            //向下遍历，判断i + 1是否超出m的范围，并且判断isVisted[i + 1][j]是否被遍历过
            if (i + 1 < m && !isVisted[i + 1][j]){
                dfs(th, m, n, i + 1, j, count, isVisted);
            }
            //向右遍历，判断j + 1是否超出n的范围，并且判断isVisted[i][j + 1]是否被遍历过
            if (j + 1 < n && !isVisted[i][j + 1]){
                dfs(th, m, n, i, j + 1, count, isVisted);
            }
        }
    }

    public static int sum(int i) {
        int sum = 0;
        while (i > 0){
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(18,10,10));
    }

}
