package com.rico.mi;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/9/8 18:00
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ss = scanner.nextLine();
        String[] strings = ss.split(" ");

        for (int i = 0; i < strings.length; i ++){
            boolean aflag = false;
            boolean Aflag = false;
            boolean numflag = false;
            boolean flag = false;
            char[] chars = strings[i].toCharArray();
            if (strings[i].length() < 8 || strings[i].length() > 120){
                System.out.println(1);
                continue;
            }
            for (int j = 0; j < chars.length ; j++){
                if (chars[j] >= 'a' && chars[j] <='z')aflag = true;
                else if (chars[j] >= 'A' && chars[j] <='Z')Aflag =true;
                else if (chars[j] >= '0' && chars[j] <='9')numflag = true;
                else if (chars[j] >= 33 && chars[j] <= 47 || chars[j] >= 58 && chars[j] <= 64)flag = true;
            }
            if (aflag && Aflag && numflag && flag){
                System.out.println(0);
                continue;
            }
            System.out.println(2);

        }
    }

}
