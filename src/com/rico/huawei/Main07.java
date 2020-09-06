package com.rico.huawei;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/8/25 15:14
 */
public class Main07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println(fun(x,y));
    }
    public static int fun(int x, int y){
        if(x == 0 || y == 0){
            return 1;
        }
        return fun(x - 1, y) + fun(x, y - 1);
    }
}
