package com.rico.lcmedium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Rico_dds
 * @date 2020/8/5 10:10
 */
public class SolutionPermuteUnique47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.containsKey(i) ? map.get(i) + 1 : 1);
        }
        int len = map.size();
        int[] p = new int[len];
        int[] pb = new int[len];
        int[] index = new int[1];
        map.forEach((k,v)->{
            p[index[0]] = k;
            pb[index[0]] = v;
            index[0] ++;
        });
        dfs(nums.length, p, pb, new ArrayList<>(), res);
        return res;

    }

    static void  dfs(int size, int[] p, int[] pb, ArrayList<Integer> chain, List<List<Integer>> res){
        //边界条件的判断：
        if(size == chain.size()){
            res.add(new ArrayList(chain));//这里记得要深拷贝一下！！！
            //res.add(chain);
            return;
        }
        for(int i = 0; i < p.length; i ++){//遍历候选节点
            int c = p[i];
            if(pb[i]>0){   //候选节点的判断
                pb[i] --;
                chain.add(c);
                dfs(size, p, pb, chain, res);
                pb[i] ++;
                chain.remove(chain.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1,2};
        System.out.println(permuteUnique(a));
    }

}
