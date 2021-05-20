package com.springjobhunting.sortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Rico_dds
 * @date 2021/4/5 11:09
 */
public class quickSort {
    public static void main(String[] args) {
        int N = 100000;
        int[] arr = new int[N];
        Random random=new Random();//这是随机数发生器
        for (int i = 0; i < N; i++) {
            int x = random.nextInt(N);//生成一个[10,100)范围内的随机数
            arr[i] = x;
        }
        long before = System.currentTimeMillis();     //获取当前系统时间(毫秒)
        System.out.println(Arrays.toString(new quickSort().sortArray(arr)));
        System.out.println(System.currentTimeMillis() - before + " MS");
    }
    public int[] sortArray(int[] nums) {
        randomizedQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public void randomizedQuicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            randomizedQuicksort(nums, l, pos - 1);
            randomizedQuicksort(nums, pos + 1, r);
        }
    }

    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
