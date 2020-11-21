package com.rico.lcmedium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Rico_dds
 * @date 2020/10/31 14:37
 */
public class findKthLargest215 {
    public static void main(String[] args) {
        //int[] a = {3,4,5,6,4,3,2,1};
        int[] a = {3,2,5,4,1};
        System.out.println(findKthLargest(a,2));
    }

    public static int findKthLargest(int[] nums, int k) {   // 第K大的数，使用小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : nums){
            queue.add(i);
            if(queue.size() > k)queue.poll();
        }
        return queue.peek();
    }

    public static int findKthLargest_1(int[] nums, int k) {// 第K小的数，使用大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i : nums){
            queue.add(i);
            if(queue.size() > k)queue.poll();
        }

        return queue.peek();
    }
}
