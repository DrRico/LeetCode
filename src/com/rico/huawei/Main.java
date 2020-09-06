package com.rico.huawei;
/**
 * @author Rico_dds
 * @date 2020/8/26 16:57
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: 24
 */
public class Main {
    public static void main(String[] args) {
        int[] a = {0,2,1,1,-65,6,7};
        System.out.println(maximumProduct(a));
    }
    public static int maximumProduct(int[] a) {
        // 定义三个变量保存最大的三个数。
        int maxOne = Integer.MIN_VALUE;
        int maxTwo = Integer.MIN_VALUE;
        int maxThree = Integer.MIN_VALUE;
        // 两个最小负数
        int minOne = Integer.MAX_VALUE;
        int minTwo = Integer.MAX_VALUE;
        // 遍历一次数组，将各个合适的元素放到对应的位置。
        for(int i = 0;i < a.length; i ++) {
            if(maxOne < a[i])  {
                maxThree = maxTwo;
                maxTwo = maxOne;
                maxOne = a[i];
            } else {
                if(maxTwo < a[i])  {
                    maxThree = maxTwo;
                    maxTwo = a[i];
                } else  {
                    if (maxThree < a[i]) {
                        maxThree = a[i];
                    }
                }
            }
            // 求两个最小负数。
            if(minOne > a[i])  {
                minTwo = minOne;
                minOne = a[i];
            } else  {
                if(minTwo > a[i]) {
                    minTwo = a[i];
                }
            }
        }
        int maxMulipty = maxOne*maxTwo*maxThree;
        int minMulipty = minOne*minTwo*maxOne;
        return maxMulipty > minMulipty ? maxMulipty : minMulipty;
    }
}
