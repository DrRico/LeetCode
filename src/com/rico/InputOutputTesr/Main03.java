package com.rico.InputOutputTesr;

/**
 * @author Rico_dds
 * @date 2020/8/29 11:52
 */
import java.util.Scanner;
public class Main03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b ==0) return;
            System.out.println(a+b);
        }
    }
}
