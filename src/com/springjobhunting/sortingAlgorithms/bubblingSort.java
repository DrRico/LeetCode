package com.springjobhunting.sortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Rico_dds
 * @date 2021/3/12 15:08
 * 冒泡排序算法
 */
public class bubblingSort {
    public static void main(String[] args) {
        int N = 10000;
        int[] arr = new int[N];
        Random random=new Random();//这是随机数发生器
        for (int i = 0; i < N; i++) {
            int x = random.nextInt(N);//生成一个[10,100)范围内的随机数
            arr[i] = x;
        }
        System.out.println(Arrays.toString(arr));
        long before = System.currentTimeMillis();     //获取当前系统时间(毫秒)
        System.out.println(Arrays.toString(sort(arr)));
        System.out.println(System.currentTimeMillis() - before + " MS");
    }
    private static int[] sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j ++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
