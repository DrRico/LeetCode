package com.rico.lcmedium;

/**
 * @author Rico_dds
 * @date 2020/10/7 21:01
 */
public class exist79 {
    static int n;
    static int m;
    static int w;
    static char[] letters;
    static char[][] board;
    static boolean[][] isvisted;

    public static boolean exist(char[][] b, String word) {
        n = b.length;
        m = b[0].length;
        w = word.length();
        letters = word.toCharArray();
        board = b;
        isvisted = new boolean[n][m];

        for (int i = 0; i < n; i ++){
            for (int j = 0; j < m; j ++){
                boolean res = dfs(i,j,0);
                if (res) return true;
            }
        }
        return false;
    }

    public static boolean dfs(int i,int j,int k){
        if (k >= w) return true;
        if (i < 0 || j < 0 || i >= n || j >= m || letters[k] != board[i][j] || isvisted[i][j])return false;
        isvisted[i][j] = true;

        boolean res = dfs(i+1,j,k+1) || dfs(i,j+1,k+1) || dfs(i-1,j,k+1)  || dfs(i,j-1,k+1);

        isvisted[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        char[][] a = {{'A','B','C','E'},
                      {'S','F','C','S'},
                      {'A','D','E','E'}};
        //System.out.println(exist(a,"ABCCED"));
        System.out.println(exist(a,"SEE"));
        System.out.println(exist(a,"ABCB"));
     }
}
