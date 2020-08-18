package com.rico.hard;
import java.util.*;

/**
 * @author Rico_dds
 * @date 2020/8/18 16:17
 * 输入n个整数，找出其中最小的K个数。例
 * 如输入4,5,1,6,2,7,3,8这8个数字，则最
 * 小的4个数字是1,2,3,4。
 */
public class SolutionGetLeastNumbers {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(k > input.length) return  res;
        Arrays.sort(input);
        for(int i = 0; i < k; i ++){
            res.add(input[i]);
        }
        return res;
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution_1(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(k > input.length) return  res;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        for(int i : input){
            queue.add(i);
            while (!queue.isEmpty() && queue.size() > k)queue.poll();
        }
        while (!queue.isEmpty()){
            res.add(queue.poll());
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] a = {4,5,1,6,2,7,3,8};
        System.out.println(GetLeastNumbers_Solution_1(a, 4));
    }
}
