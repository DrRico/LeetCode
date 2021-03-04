package com.rico.newcoderCompetition;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/12/1 10:21
 */
public class PureLateEarly {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = 1;
        for(int i = 2; i < Math.sqrt(n);i ++){
            if(n%i == 0){
                sum += n/i;
                sum += i;
            }
        }
        if(sum == n){
            System.out.print("Pure");
        }else if(sum < n){
            System.out.print("Early");
        }else{
            System.out.print("Late");
        }
    }
}
