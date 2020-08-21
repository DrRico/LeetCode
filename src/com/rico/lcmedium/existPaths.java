package com.rico.lcmedium;

/**
 * @author Rico_dds
 * @date 2020/8/21 16:57
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字
 * 符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步
 * 可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩
 * 阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的
 * 矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 *[["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 *但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占
 * 据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 */
@SuppressWarnings("ALL")
public class existPaths {

    public static boolean exist(char[][] board, String word) {
       boolean[][] isvis = new boolean[board.length][board[0].length];
       for (int i = 0; i < board.length; i ++){
           for (int j = 0; i < board[i].length; j ++){
               return dfs(board, word, i, j, isvis,0);
           }
       }
       return false;

    }

    private static boolean dfs(char[][] board, String word, int x, int y, boolean[][] isvis, int index) {
        if (0 > x || x > board.length - 1  || 0 > y || y > board[0].length - 1 || isvis[x][y]){
            return false;
        }
        if (word.charAt(index) != board[x][y]){
            return false;
        }
        if (word.length() - 1 == index){
            return true;
        }
        isvis[x][y] = true;

        boolean flag = dfs(board, word,x + 1, y, isvis,index + 1) ||
                       dfs(board, word,x - 1, y, isvis,index + 1) ||
                       dfs(board, word, x , y + 1, isvis,index + 1) ||
                       dfs(board, word, x , y - 1, isvis,index + 1);

        isvis[x][y] = false;

        return flag;
    }

    public static void main(String[] args) {
        char[][] a =  {{'a','b'}};
        System.out.println(exist(a,"ab"));

    }
}
