package com.rico.SXF;

/**
 * @author Rico_dds
 * @date 2020/9/27 16:41
 */

import java.util.Arrays;

public class JTBank_02 {

    private static int[] parent;
    private static int[] rank;

    public static boolean detecteCycle(int[][] edges, int n) {
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

    private static boolean union(int x, int y) {
        int x_root = find_root(x);
        int y_root = find_root(y);
        if (x_root == y_root) {
            return false;
        } else {
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

    private static int find_root(int x) {
        int x_root = x;
        while (parent[x_root] != -1) {
            x_root = parent[x_root];
        }
        return x_root;
    }

    public static int graph_circle_check(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                sb.append(ch);
            }
        }
        int[][] num = new int[sb.length()/2][2];
        for (int i = 0; i < sb.length() / 2; i ++) {
            num[i][0] = sb.charAt(i*2)-'A';
            num[i][1] = sb.charAt(i*2 +1)-'A';
        }
        boolean b = detecteCycle(num, sb.length()/2);
        if (b) {
            return 1;
        } else {
            return 0;
        }
    }


    public static void main(String[] args) {

        //String string = "{(A,B)->(B,C)->(C,A)}";
        String string = "{(A,B)->(B,C)->(C,A)}";

        System.out.println(graph_circle_check(string));
    }
}

