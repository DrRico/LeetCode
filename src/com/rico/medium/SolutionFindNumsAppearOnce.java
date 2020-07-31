package com.rico.medium;

import java.util.Arrays;

/**
 * @author Rico_dds
 * @date 2020/7/31 16:53
 * 一个整型数组里除了两个数字之外，其他的数
 * 字都出现了两次。请写程序找出这两个只出现
 * 一次的数字。
 */

/**
 *思路：
 * 1、判断非法输入，比如具体的array的长度为2时，直接赋值给两个num。
 * 2、遍历array中所有的值，每个值进行异或，得到bitRes。
 * 3、bitRes必定不为0，因为题目告诉我们有两个数不一样且只出现一次，
 * 而其他的数都是成对出现的，所以获取bitRes中最低位不为0的index，
 * 也就是转换成二进制后，右起第一个1的下标index。
 * 4、得到index的值后，我们就可以将array的值再遍历一遍，判断元素
 * 值右移index位后，最低位为1还是0，这样子就可以将array分成两组，
 * 同时对这两组的元素值异或后，就能找出单个出现的值。（两个相同的
 * 数异或之后为0，并且一个数与0异或还是他本身）
 */


public class SolutionFindNumsAppearOnce {
    public static int[] FindNumsAppearOnce(int[] array)    {
        int[] num = new int[2];
        int length = array.length;
        if(length == 2){
            return array;
        }
        int bitResult = 0;
        for(int i = 0; i < length; ++i){
            bitResult ^= array[i];
        }
        int index = findFirst1(bitResult);
        for(int i = 0; i < length; ++i){
            if(isBit1(array[i], index)){
                num[0] ^= array[i];
            }else{
                num[1] ^= array[i];
            }
        }
        return num;
    }
    private static int findFirst1(int bitResult){
        int index = 0;
        while(((bitResult & 1) == 0) && index < 32){
            bitResult >>= 1;
            index++;
        }
        return index;
    }

    private static boolean isBit1(int target, int index){
        return ((target >> index) & 1) == 1;
    }

    public static void main(String[] args) {
        int[]  a = new int[] {9,2,6,8,5,5,2,6,12,8};
        System.out.println(Arrays.toString(FindNumsAppearOnce(a)));
    }


}