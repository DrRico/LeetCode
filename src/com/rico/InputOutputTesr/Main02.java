package com.rico.InputOutputTesr;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/8/29 11:50
 */
public class Main02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        for (int i = 0; i < lines; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a+b);
        }
    }
}
