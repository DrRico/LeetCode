package com.rico.oppo;

/**
 * @author Rico_dds
 * @date 2020/11/18 18:36
 *
 */
public class Main_01 {
    public static void main(String[] args) {
        int[][] a = {
                {1,2,1},
                {1,3,4},
                {5,7,8}};
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(getMinPath(m));
    }

    public static int getMinPath(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] temp = new int[m][n];
        temp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            temp[i][0] = temp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            temp[0][i] = temp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                temp[i][j] = Math.min(temp[i-1][j],temp[i][j-1]) + grid[i][j];
            }
        }
        return temp[m-1][n-1];
    }

}

    /*public static int getWidth(TreeNode root){
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        LinkedList<Integer> numbers = new LinkedList<>();
        int max = 1;
        numbers.offer(1);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int index = numbers.poll();
                TreeNode n = q.poll();
                if(n.left != null){
                    q.offer(n.left);
                    numbers.offer(2*index + 1);
                }
                if (n.right != null){
                    q.offer(n.right);
                    numbers.offer(2*index + 2);
                }
            }
            if (numbers.size() >= 2){
                max = Math.max(max, numbers.getLast() - numbers.getFirst() + 1);
            }
        }
        return max;
    }*/


