package com.rico.medium;

import java.util.HashMap;

/**
 * @author Rico_dds
 * @date 2020/8/3 10:22
 * 数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class SolutionMoreThanHalfNum_Solution {
    public static int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int max = 0;
        int res = array[0];
        for(int i = 0; i < array.length; i ++){
            if(map.containsKey(array[i])){
                int temp = map.get(array[i]) + 1;
                if (max < temp){
                    max = temp;
                    res = array[i];
                }
                map.put(array[i],temp);
            }else{
                map.put(array[i],1);
            }
        }
        return ((max << 1) > array.length) ? res :0;
    }

    public static int MoreThanHalfNum_Solution_1(int [] array) {
        int res = array[0],time = 0;
        for(int i = 0; i < array.length; i++){
            if (res == array[i]){
                time ++;
            }else{
                time --;
                if(time == 0){
                    res = array[i];
                    time = 1;
                }
            }
        }
        time = 0;
        for(int i = 0; i < array.length; i++){
            if(res == array[i]){
                time ++;
            }
        }
        if(time*2 > array.length){
            return res;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(a));
    }
}
