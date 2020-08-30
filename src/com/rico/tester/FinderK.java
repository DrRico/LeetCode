package com.rico.tester;


/**
 * @author Rico
 * @date 2020/8/30 9:39
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 *
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 *
 * 测试样例：
 *
 * [],5,3
 *
 * 返回：2
 * https://blog.csdn.net/roamer_nuptgczx/article/details/52106972
 */

public class FinderK {
    public static int findKth(int[] a, int n, int K) {
        //Arrays.sort(a);
        //return a[n - K];
        return find(a, 0, n-1, K);
    }
    //递归寻找数组中第K大的元素
    private static int find(int[] a, int low, int high, int K) {
        int pivot = partition(a, low, high);

        if(pivot + 1 < K)//中轴位置少于K个，在右子数组中继续查找
            return find(a, pivot+1, high, K);
        else if(pivot + 1 > K)//中轴位置大于K个，在左子数组中继续查找
            return find(a, low, pivot-1, K);
        else//中轴元素正好是第K大的元素
            return a[pivot];
    }

    //将数组划分为两部分，左边较大，右边较小
    private static int partition(int[] a, int low, int high) {
        // 将数组首元素作为每一轮比较的基准
        int pivotValue = a[low];

        while (low < high) {
            // 从右往左扫描，直到遇到比基准元素小的元素
            while (low < high && a[high] <= pivotValue)
                --high;

            // 将右子数组中不合格的元素放到左边不合格元素的位置（原元素已经移走）
            a[low] = a[high];

            // 从左往右扫描，直到遇到比基准元素大的元素
            while (low < high && a[low] >= pivotValue)
                ++low;

            // 将左子数组中不合格的元素放到左边不合格元素的位置（原元素已经移走）
            a[high] = a[low];
        }

        // 将基准元素放到中间位置
        a[low] = pivotValue;

        // 返回数组的中轴位置
        return low;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,2,2};
        int[] b = {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        System.out.println(findKth(a, 5, 3));
    }
}






