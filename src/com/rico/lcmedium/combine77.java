package com.rico.lcmedium;

import java.util.*;
import java.util.List;

/**
 * @author Rico_dds
 * @date 2020/9/8 16:17
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */

public class combine77 {
    public static void main(String[] args) {
        System.out.println(combine(4,2));

    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        // Deque<Integer> path = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        dfs(n, k, 1, list, res);
        return res;
    }

    private static void dfs(int n, int k, int index, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 只有这里 i <= n - (k - path.size()) + 1 与参考代码 1 不同
        for (int i = index; i <= n; i++) {
            list.add(i);
            dfs(n, k, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

}
