package com.rico.hard;

import java.util.Arrays;

/**
 * @author Rico_dds
 * @date 2020/8/3 16:44
 * 输入一个整数数组，实现一个函数来调整
 * 该数组中数字的顺序，使得所有的奇数位于
 * 数组的前半部分，所有的偶数位于数组的
 * 后半部分，并保证奇数和奇数，偶数和偶数
 * 之间的相对位置不变。
 */
public class SolutionReOrderArray {
    public static int[] reOrderArray(int [] array) {
        int len = array.length;
        int index = 0;
        for(int i = 0; i < len; i ++){
            if(array[i]%2 == 1){        //处理奇数
                int j = i;
                while (j > index){
                    int c = array[j];
                    array[j] = array[j-1];
                    array[j - 1] = c;
                    j--;
                }
                index ++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(reOrderArray(a)));
    }

}
