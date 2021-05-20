package com.springjobhunting.BAIDU;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2021/3/17 20:06
 */
public class BAIDU01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        String code = sc.nextLine();
        for (int i = 0;i < code.length(); i ++){  // U、D、L和R
            char c = code.charAt(i);
            if (c == 'L'){
                x --;
            } else if (c == 'R'){
                x ++;
            } else if (c == 'U'){
                y ++;
            } else if (c == 'D'){
                y --;
            }
        }
        System.out.println(new String(x+" " + y));
    }
}
