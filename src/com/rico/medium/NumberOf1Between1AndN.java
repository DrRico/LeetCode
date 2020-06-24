package com.rico.medium;

/**
 * @author Rico_dds
 * @date 2020/6/23 20:42
 */
public class NumberOf1Between1AndN {

    public static int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        for(int i = 1;i <= n;i *= 10){
            int a = n/i,b = n%i;
            if(a%10 == 0){
                sum += a/10 * i;
            }else if(a%10 == 1){
                sum += (a/10*i) + b + 1;
            }else{
                sum += (a/10 + 1) * i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 3141592;
        n = NumberOf1Between1AndN.NumberOf1Between1AndN_Solution(n);
        System.out.println(n);
    }
}
