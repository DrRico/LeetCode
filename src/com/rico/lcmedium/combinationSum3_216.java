package com.rico.lcmedium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rico_dds
 * @date 2020/9/11 21:11
 *找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 *示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class combinationSum3_216 {
    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k >= n) return res;
        dfs(n,k,1,new ArrayList(), res);
        return res;
    }
    private static void dfs(int n,int k, int index,List<Integer> list, List<List<Integer>> res){
        if (list.size() >= k || 0 >= n){
            if(list.size() == k && 0 == n){
                res.add(new ArrayList(list));
            }
            return;
        }
        for (int i = index; i <= 9; i ++){
            list.add(i);
            dfs(n - i, k, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        //System.out.println(combinationSum3(3,9));

    }
}
