package com.rico.SXF;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/9/26 20:20
 */
public class KDXF_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String s = getResult(num);
        System.out.println(s.substring(1));

    }
    private static String getResult(int n){
        String str = "";
        for (int i = 2; i < n; i++) {
            if (n % i == 0){
                return "*" + str + i + getResult(n / i);
            }
        }
        return "*" + n;
    }

}
