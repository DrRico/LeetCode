package com.rico.lceasy;

/**
* @author Rico_dds
* @date 2020/8/27 10:30
*/
import java.util.*;
    class maxProfit122{
    public static int maxProfit(int[] pricestemp) {
        if (pricestemp.length <= 1) return 0;
        int [] prices = new int[pricestemp.length + 1];

        for (int i = 0; i < pricestemp.length; i ++)prices[i] = pricestemp[i];
        int min = prices[0];
        prices[prices.length - 1] = -1;
        int max = 0;
        for (int i = 1; i < prices.length - 1; i ++){

            if (min > prices[i]){
                min = prices[i]; // 保存遍历过的最小的值
            }

            if (prices[i] > prices[i+1]){
                max += prices[i] - min; // 符合条件则更新利润的值
                min = prices[i];
            }

        }
        return max;
    }

    public static int maxProfit_1(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1];
        }
        return max;
    }
    public static void main(String[] args) {
        //int[] a = {7,1,5,3,6,4};
        //int[] a = {2,1,4}; // 3 是正确答案
        // int[] a = {2,4,1}; // 2 是正确答案
         int[] a = {7,6,4,3,1}; // 0 是正确答案
        System.out.println(maxProfit(a));
    }
}