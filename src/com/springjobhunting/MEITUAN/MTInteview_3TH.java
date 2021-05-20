package com.springjobhunting.MEITUAN;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * @author Rico_dds
 * @date 2021/4/17 16:46
 */
public class MTInteview_3TH {
    public static void main(String[] args) {
//        HashMap<Integer,Integer> map = new HashMap<>(); //{0=104, 1=116, 2=82, 3=99, 4=101, 5=88, 6=113, 7=98, 8=106, 9=93}
//        for (int i = 0; i < 1000; i++) {
//            int r = new Random().nextInt(10);
//            if (map.containsKey(r)){
//                map.put(r,map.get(r) + 1);
//            } else {
//                map.put(r, 1);
//            }
//        }
//        System.out.println(map);
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        System.out.println(Arrays.toString(shuffle_1(arr)));
    }
    private static int[] shuffle (int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        while (i < n){
            int random = new Random().nextInt(n);
            while ((!set.contains(random))){
                set.add(random);
                res[random] = arr[i];
                i ++;
            }
        }
        return res;
    }

    private static int[] shuffle_1(int[] arr){
        int[] res = arr.clone();
        for (int i = 1; i < arr.length; i++) {
            int j = new Random().nextInt(i + 1);
            swap(res, i, j);
        }
        return res;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
