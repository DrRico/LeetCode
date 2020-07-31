package com.rico.tester;

import java.util.Arrays;

/**
 * @author Rico_dds
 * @date 2020/7/30 21:33
 */
public class SolutionSovle {
    public static int[] sovle (int[] a, int n, int m) {
        int[] b = Arrays.copyOfRange(a,0,a.length);
        Arrays.sort(a);
        int L = 0,R = a.length;
        int temp1 = -1 ,temp2 = -1;
        int mid = 0;
        while(R >= L){
            mid = L + ((R-L) >> 1);
            if(n < a[mid]){
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        temp1 = mid;
        L = 0;
        R = a.length;
        mid = 0;
        while(R > L){
            mid = L + ((R-L) >> 1);
            if(m < a[mid]){
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        temp2 = mid;
        int temp = b[temp2];
        b[temp2] = b[temp1];
        b[temp1] = temp;
        return b;
    }

    public static int[] sovle1 (int[] a, int n, int m) {
        int len = a.length;
        int[] b = new int[len];
        for (int i = 0; i < len; i++){
            b[i] = a[i];
        }
        Arrays.sort(b);
        int x = 0,y = 0;
        for (int i = 0;i < len; i++){
            if(b[len - n] == a[i]){
                x = i;
            }
            if(b[len - m] == a[i]){
                y = i;
            }
        }
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2};
        System.out.println(Arrays.toString(sovle1(a,1,2)));
        // System.out.println(Arrays.toString(a));

    }
}
