package com.rico.medium;

/**
 * @author Rico_dds
 * @date 2020/7/21 10:58
 */
public class SolutionFibonacci {
    public static int Fibonacci(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        int a = 0,b = 1, c = 1;
        for (int i = 2; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(8));
    }
}
