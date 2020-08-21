package com.rico.medium;

import java.util.ArrayList;

/**
 * @author Rico_dds
 * @date 2020/8/21 9:11
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 * 他马上就写出了正确答案是100。但是他并不满足于此,他在想究
 * 竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久
 * ,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在
 * 把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺
 * 序，序列间按照开始数字从小到大的顺序
 */
public class SolutionFindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();// 结果数组
        int left = 1, right = 2;// 初始值
        if(sum < left + right)return res; // 当sum小于3是不满足要求的，直接返回
        int cur = left + right;        // 记录当前窗口中的值
        while(right > left && sum > right){ // 主循环
            while(cur < sum && sum > right){ // 小循环，当窗口和小于目标，则不断向右扩大
                right ++;    // 移动右边，扩大窗口
                cur += right;// 更新窗口内值的和
            }
            if(sum == cur){  // 满足要求，添加到结果数组
                res.add(getResList(left, right));
            }
            cur -= left;    // 减去最左边窗口的元素值
            left ++;        // 左窗口移动
        }
        return res;
    }



    public static ArrayList<Integer> getResList(int left, int right){
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = left; i <= right; i ++){
            res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(FindContinuousSequence(100));

    }


}
