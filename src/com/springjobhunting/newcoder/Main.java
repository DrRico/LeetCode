package com.springjobhunting.newcoder;

/**
 * @author Rico_dds
 * @date 2021/3/8 19:19
 */
public class Main {
    public static void main(String[] args){
        int a = 4, b = 2;
        int c = 0, res;
        do {
            res = a ^ b;
            c = (a & b) << 1;
            a = res;
            b = c;
        }
        while(c != 0);
        System.out.println(res);
    }
}
