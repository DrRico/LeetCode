package com.rico.lceasy;

import java.util.*;

/**
 * @author Rico
 * @date 2020/8/22 23:36
 */

public class findMedianSortedArrays04 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        double res;
        for (int i = 0; i < nums1.length; i ++){
            list.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i ++){
            list.add(nums2[i]);
        }
        Collections.sort(list);
        if((nums1.length + nums2.length) % 2 == 0){
            // 偶数
            res = (list.get((nums1.length + nums2.length) >> 1) + list.get((nums1.length + nums2.length - 1) >> 1))  / 2.0;
        } else {
            res = list.get((nums1.length + nums2.length) >> 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {3,4};
        System.out.println(findMedianSortedArrays(a,b));
    }
}
