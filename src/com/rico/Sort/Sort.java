package com.rico.Sort;


import java.util.Arrays;
import java.util.Random;

/**
 * @author Rico_dds
 * @date 2020/10/22 15:06
 */
/*        int n = a.length;
        for (int i = 0; i < n; i++) {
            int index = i;
            int j;
            for (j = i + 1; j < n; j++) {
                if(a[j] < a[index]){
                    index = j;
                }
            }
            int temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }*/
public class Sort {
    public static void main(String[] args) {
        int[] a = {3,54,7,1,57,6,54,223,-6,56,0,11,-5,4,4,23,7,567,5,234,52,0,23,4,-55};
        //System.out.println(Arrays.toString(a));

        //数组原料准备
        /*int n = 20000;
        int[] a = new int[n];
        Random ran = new Random();
        for(int i=0;i<a.length;i++) {
            a[i] = ran.nextInt();
        }//*/
        //复制数组
        int[] a1 = Arrays.copyOf(a,a.length);
        int[] a2 = Arrays.copyOf(a,a.length);
        int[] a3 = Arrays.copyOf(a,a.length);
        int[] a4 = Arrays.copyOf(a,a.length);

        long time = System.currentTimeMillis();
        bubbleSort(a1);
        System.out.println("time for bubbleSort   sort is " + (System.currentTimeMillis() - time) + "ms");

        time = System.currentTimeMillis();
        insertSort(a2);
        System.out.println("time for insertSort   sort is " + (System.currentTimeMillis() - time) + "ms");

        time = System.currentTimeMillis();
        insertSort_1(a4);
        System.out.println("time for insertSort01 sort is " + (System.currentTimeMillis() - time) + "ms");

        time = System.currentTimeMillis();
        selectSort(a3);
        System.out.println("time for selectSort   sort is " + (System.currentTimeMillis() - time) + "ms");

//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(a1));
//        System.out.println(Arrays.toString(a2));
//        System.out.println(Arrays.toString(a3));
        System.out.println(Arrays.toString(a1));
    }

    public static void bubbleSort(int[] a){
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    public static void insertSort(int[] a){
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && a[j-1] > a[j]; j--) {
                int temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
            }
        }
        /*for(int i = 1; i < n-1; ++i){
            int key = a[i];
            int j = i-1;
            while( j >= 0 && a[j] > key ) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }*/

    }

    public static void insertSort_1(int[] a){
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key){
                a[j+1] = a[j];
                j --;
            }
            a[j+1] = key;
        }
    }

    public static void selectSort(int[] a){
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int index = i;
            for (int j = i; j < n; j++) {
                if (a[j] < a[index]){
                    index = j;
                }
            }
            int temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }
    }



}
