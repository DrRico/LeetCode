package com.rico.InputOutputTesr;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/8/29 14:50
 */
public class Main05 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int nums = sc.nextInt();
            int sum = 0;
            for (int i = 0; i < nums; i ++){
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }
    }
}
