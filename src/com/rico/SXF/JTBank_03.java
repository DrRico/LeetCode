package com.rico.SXF;

/**
 * @author Rico_dds
 * @date 2020/9/27 16:41
 */

import java.util.ArrayList;
import java.util.List;

public class JTBank_03 {

    public static boolean isHaveLoop(int[][] graph, int n) {
        //这段代码可要可不要，可以提前判断结果
//        if (graph.length >= n) {//当边数大于节点的个数时，必定存在环 自己可以画图推导
//            return true;
//        }
        //习惯上转换成临接表的形式
        List<Integer>[] adj = new ArrayList[n];
        for (int[] edg : graph) {
            int node1 = edg[0];
            int node2 = edg[1];
            if (adj[node1] == null) {
                adj[node1] = new ArrayList<>();
            }
            if (adj[node2] == null) {
                adj[node2] = new ArrayList<>();
            }
            adj[node1].add(node2);
            adj[node2].add(node1);
        }
        boolean[] visited = new boolean[n];//定义一个节点状态数组  判断是否访问过
        int[] a = {0};
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {//如果没有进行访问  则进行深度优先搜索回溯
                dfsCycle(adj, i, -1, visited, a);//引用传递  函数内部修改值后退出函数可见
//                System.out.println(a[0]);
                if (a[0] == 1) {//只要有一次i循环时存在环路那就直接提前返回，说明存在环
                    return true;
                }
            }
        }
        return a[0] == 1;
    }


    /**
     * @param adj     图的临接表
     * @param current 当前节点
     * @param parent  父节点
     * @param visited 判断是否访问
     * @param flag    是否存在环
     */
    private static void dfsCycle(List<Integer>[] adj, int current, int parent, boolean[] visited, int[] flag) {
        visited[current] = true;//首先 访问当前节点   并进行标记
        List<Integer> list = adj[current];  //获取到当前节点能够到达的所有节点
        for (Integer can : list) {
            if (visited[can] == false) {//如果节点没有被访问过
                dfsCycle(adj, can, current, visited, flag);//当前节点就是父节点，循环的节点就是子节点
            } else if (can != parent) {// 在节点被访问过的情况下 如果该节点不等于父节点  ，说明有环
                flag[0] = 1;
            }
            //循环节点等于父节点的情况直接跳过，不用处理
        }
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
        boolean b = isHaveLoop(num, sb.length()/2);
        if (b) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

        String string = "{(A,B)->(B,C)->(C,D)}";
        //System.out.println(graph_circle_check(string));

        //int[][] graph = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {2, 4}};
        //int n = 5;
        System.out.println(graph_circle_check(string));
    }
}

