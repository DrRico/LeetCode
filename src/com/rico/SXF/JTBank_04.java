package com.rico.SXF;

import java.util.Arrays;


public class JTBank_04 {

    private int[] parent;
    private int[] rank;

    /**
     * 这里要求节点编号从0开始进行编号
     * 如果不是的话就不可以用数组来作为map，可能需要用两个HashMap才行
     *
     * @param edges 边
     * @param n     节点个数
     * @return
     */
    public boolean detecteCycle(int[][] edges, int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
        rank = new int[n];
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (!union(x, y)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 连接节点
     *
     * @param x
     * @param y
     * @return
     */
    private boolean union(int x, int y) {
        int x_root = find_root(x);
        int y_root = find_root(y);
        if (x_root == y_root) {
            return false;   // 连接失败  // 说明有环
        } else {
            // 可以进行连接
            // 下边的判断是为了降低树的高度  一个小优化
            if (rank[x_root] > rank[y_root]) {
                parent[y_root] = x_root;
            } else if (rank[x_root] < rank[y_root]) {
                parent[x_root] = y_root;
            } else {
                parent[x_root] = y_root;
                rank[y_root]++;
            }
            return true;
        }
    }

    /**
     * 找到根节点函数
     *
     * @param x
     * @return
     */
    private int find_root(int x) {
        int x_root = x;
        while (parent[x_root] != -1) {
            x_root = parent[x_root];
        }
        return x_root;
    }


    public static void main(String[] args) {
        JTBank_04 disjoinSet = new JTBank_04();
      //int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}, {2, 4}, {4, 5}}; // 有环
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}, {4, 5}};  //无环
        boolean b = disjoinSet.detecteCycle(edges, 6);
        if (b) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}

