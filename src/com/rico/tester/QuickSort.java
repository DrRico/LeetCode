package com.rico.tester;

import java.util.Arrays;

/**
 * @author Rico_dds
 * @date 2020/9/16 16:53
 */



public class QuickSort {

    public static void main(String[] args) {
        int[] a = {6,4,87,34,98,44,2,9,8,45,92,21,1,7};
        System.out.println("before:" + Arrays.toString(a));
        quickSort(a, 0, a.length - 1);
        System.out.println("-after:" + Arrays.toString(a));
    }

    public static void quickSort(int[] array, int left, int right){
        if (left >= right) return;
        int partitionIndex = partition(array,left,right);
        quickSort(array, left, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int leftIndex = left;
        int rightIndex = right - 1;
        while (true){
            while (leftIndex < right & array[leftIndex] <= pivot){
                leftIndex ++;
            }
            while (rightIndex >= left && array[rightIndex] > pivot){
                rightIndex --;
            }
            if (leftIndex > rightIndex)break;
            swap(array, leftIndex, rightIndex);

        }
        swap(array, leftIndex, right);
        return leftIndex;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


    public static void insertionSort(int[] array){
        for (int i = 1; i < array.length; i ++) {
            int cur = array[i];
            int insertionIndex = i - 1;
            while (insertionIndex >= 0 && array[insertionIndex] > cur){
                array[insertionIndex + 1] = array[insertionIndex];
                insertionIndex --;
            }
            array[insertionIndex + 1] = cur;
        }
    }

}
