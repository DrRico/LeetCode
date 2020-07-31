package com.rico.lcmedium;

/**
 * @author Rico_dds
 * @date 2020/7/30 16:10
 */
public class SolutionIntegerBreak {
    public static int integerBreak(int n) {
        if(n == 2 || n ==3){
            return n-1;     //处理2和3的情形
        }
        if (n % 3 == 0){
            return (int) Math.pow(3, n / 3);
        } else if (n % 3 == 1){
            return (int)Math.pow(3, n / 3 - 1) * 4;
        } else {
            return (int)Math.pow(3, n / 3) * 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

}
