package com.rico.mi;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/9/8 18:00
 */
public class Test01 {
    static char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
    static String word;
    static boolean[][] isV;
    static int m;
    static int n;
    static boolean res = false;
    public static boolean fun(String w){
        word = w;
        m = board.length;
        n = board[0].length;
        isV = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && !isV[i][j]){
                    dfs(i,j,1);
                }
            }
        }
        return res;

    }

    public static void dfs(int i,int j,int next){
        if (next == word.length()){
            res = true;
            return;
        }
        isV[i][i] = true;
        if (res== false && i-1>=0 &&board[i-1][j] == word.charAt(next)&&!isV[i-1][j]){
            dfs(i-1,j,next+1);
        }
        if (res== false &&i+1<m &&board[i+1][j] == word.charAt(next)&&!isV[i+1][j]){
            dfs(i+1,j,next+1);
        }

        if (res== false &&j-1>=0&&board[i][j-1] == word.charAt(next)&&!isV[i][j-1]){
            dfs(i,j-1,next+1);
        }

        if (res== false &&  j+1<n &&board[i][j+1] == word.charAt(next)&&!isV[i][j+1]){
            dfs(i,j+1,next+1);
        }
        isV[i][i] = false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ss = scanner.nextLine();
        System.out.println(fun(ss));
    }


}
