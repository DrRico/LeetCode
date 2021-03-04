package com.springjobhunting.newcoder;

/**
 * @author Rico_dds
 * @date 2021/3/2 14:08
 */
public class fibonacciFindN {
    public static void main(String[] args) {
        System.out.println(fun(0));
        System.out.println(fun(1));
        System.out.println(fun(5));
        System.out.println(fun(48));
        System.out.println(fun(95));
        System.out.println(fun(99));
    }

    static private int fun (int num){
        int a = 0, b = 1, sum = 2;
        if (num == 0) {
            return 0;
        }
        if (num == 1 || num == 2){
            return 1;
        }
        for (int i = 0; i < num; i++) {
            sum = (a + b) % 1000000007;
            b = a;
            a = sum ;
        }
        return sum;
    }
}