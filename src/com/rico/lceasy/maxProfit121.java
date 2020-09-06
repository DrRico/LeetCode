package com.rico.lceasy;

import java.util.Stack;

/**
 * @author Rico_dds
 * @date 2020/8/26 22:52
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class maxProfit121 {

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int min = prices[0];
        int sum = 0;
        for (int i = 1; i < prices.length; i ++){
            if (min > prices[i]){
                min = prices[i]; // 保存遍历过的最小的值
            } else if (prices[i] - min > sum){
                sum = prices[i] - min; // 符合条件则更新利润的值
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // int[] a = {7,1,5,3,6,4};
         int[] a = {2,1,4}; // 3 是正确答案
        // int[] a = {2,4,1}; // 2 是正确答案
        // int[] a = {7,6,4,3,1}; // 0 是正确答案
        System.out.println(maxProfit(a));
    }

}
