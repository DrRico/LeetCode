package com.rico.lcmedium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Rico_dds
 * @date 2020/9/1 14:40
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 *示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 提示：
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 */
public class combinationSum39 {
/*

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) return res;
        dfs(candidates,target,new ArrayList<>(), res);
        return res;
    }

    static void dfs(int[] candidates, int target, ArrayList<Integer> list, List<List<Integer>> res){
        if(target <= 0){
            if (target == 0){
                ArrayList<Integer> tempList = new ArrayList<>(list);
                Collections.sort(tempList);
                if (!res.contains(tempList)) res.add(tempList);
            }
            return;
        }
        for (int i = 0; i < candidates.length; i ++){
            list.add(candidates[i]);
            dfs(candidates,target - candidates[i],list,res);
            list.remove(list.size() - 1);
        }
    }
*/

    public static void main(String[] args) {
        int[] a ={2,3,5};
        System.out.println(combinationSum(a,8));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length == 0) return res;
        dfs(candidates, target, new ArrayList<Integer>(), res);
        return res;
    }

    private static void dfs(int[] candidates, int target, ArrayList<Integer> list, List<List<Integer>> res) {
        if(target <= 0){
            if(target == 0){
                ArrayList<Integer> temp = new ArrayList<>(list);
                Collections.sort(temp);
                if (!res.contains(temp)) res.add(temp);
            }
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            int n = candidates[i];
            list.add(n);
            dfs(candidates,target - n, list, res);
            list.remove(list.size() - 1);
        }
    }
}
