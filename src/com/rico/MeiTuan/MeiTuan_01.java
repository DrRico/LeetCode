package com.rico.MeiTuan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Rico_dds
 * @date 2020/9/20 9:42
 */
public class MeiTuan_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int cnt = 0;
        if (start >= end){
            System.out.println(0);
            return;
        }
        for (int i = start; i < end; i++) {
            if (isCo(i)){
                cnt ++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean isCo(int n){

        int num = n;
        int a,b,c,d,e,f;
        a = num/100000%10;
        if (a == 0) return false;

        b = num/10000%10;
        if (b == a) return false;

        c = num / 1000 % 10;
        if (c == b || c == a) return false;

        d = num / 100 % 10;
        if (d == b || d == a || d == c) return false;

        e = num / 10 % 10;
        if (e == b || e == a || e == c || e == d) return false;

        f = num % 10;
        if (f == b || f == a || f == c || f == d || f == e) return false;

        if (!((a*10+b) + (c*10+d) == (e*10+f))) return  false;

        return true;
        /*Set set = new HashSet<Integer>();
        while (num!=0){
            if (!set.add(num%10)){
                return false;
            }
            num = num / 10;
        }
        int tem = n % 100;
        int hun = n / 100 % 100;
        int so = n / 10000 % 100;
        if(tem + hun == so)
            return true;
        return false;*/
    }
}
