package com.rico.tester;

/**
 * @author Rico_dds
 * @date 2020/8/6 21:10
 */
public class reverseTime {
    public static int solve (int n, int k) {
        if(n == 0 || k == 0){
            return 0;
        }
        // write code here
        int t = k % n;
        return t == 0 ? 0 : 1 << t;
    }

    public static void main(String[] args) {
        System.out.println(solve(14,4));
    }
}
