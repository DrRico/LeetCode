package com.rico.mi;

/**
 * @author Rico_dds
 * @date 2020/9/8 19:29
 */

class mi02 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果找到 word 的第一个字母
                if (board[i][j] == word.charAt(0)) {
                    // 再进行 dfs 找之后的字母,成功找到所有字母才返回 true
                    // 有一个字母不满足就遍历其他位置的元素
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        // 所有元素遍历完都没找到就返回 false
        return false;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, int index) {
        // 找到所有的字母则返回 true
        if (index == word.length()) {
            return true;
        }
        return false;
    }
}