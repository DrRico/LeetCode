package com.springjobhunting.MEITUAN;

import java.util.*;

/**
 * @author Rico_dds
 * @date 2021/3/13 17:19
 */
public class MEITUAN04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // System.out.println(Arrays.toString(arr));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length - k + 1; i++) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int j = 0; j < k; j++) {
                if(map.containsKey(arr[j + i])){
                    map.put(arr[j + i],map.get(arr[j + i]) + 1);
                } else {
                    map.put(arr[j + i],1);
                }
            }
            int maxtime = Integer.MIN_VALUE, minval = Integer.MAX_VALUE;
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                if (entry.getValue() > maxtime) {
                    maxtime = entry.getValue();
                    minval = entry.getKey();
                }
                if (entry.getValue() >= maxtime && minval > entry.getKey()){
                    minval = entry.getKey();
                }
            }
            list.add(minval);
        }
        // System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
