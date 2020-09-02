package com.rico.huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Rico_dds
 * @date 2020/9/2 18:58
 */
public class HUAWEI_0902_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int body = sc.nextInt();
        TreeMap<Integer, Integer> rMap = new TreeMap<>();
        TreeMap<Integer, Integer> bMap = new TreeMap<>();
        for (int i = 0; i <body;i ++){
            int cnt = sc.nextInt();
            int color = sc.nextInt();
            if(color == 1){
                rMap.put(cnt, i + 1);
            } else {
                bMap.put(cnt, i + 1);
            }
        }
        if(rMap.size() < 3 && bMap.size()< 3){
            System.out.println("null");
        }
        int[] rMax = new int[3];
        int rCnt = 0;
        if (rMap.size() >= 3){
            for (int i = 2; i >= 0; i --){
                Map.Entry<Integer,Integer> entry = rMap.lastEntry();
                rCnt += entry.getKey();
                rMax[i] = entry.getValue();

            }
        }
        int[] bMax = new int[3];
        int bCnt = 0;
        if (bMap.size() >= 3){
            for (int i = 2; i >= 0; i --){
                Map.Entry<Integer,Integer> entry = bMap.lastEntry();
                bCnt += entry.getKey();
                bMax[i] = entry.getValue();
                bMap.remove(entry.getKey());

            }
        }
        if (rCnt > bCnt){
            out(rMax,1,rCnt);
        } else if (rCnt == bCnt){
            if (rMax[0] < bMax[0]){
                out(rMax,1,rCnt);
            } else {
                out(bMax,2,bCnt);
            }
        } else {
            out(bMax,2,bCnt);
        }




    }
    public static void out(int[] n,int color,int cnt){
        System.out.print(n[0] + " ");
        System.out.print(n[1] + " ");
        System.out.print(n[2]);
        System.out.println(color);
        System.out.println(cnt);
    }

}
