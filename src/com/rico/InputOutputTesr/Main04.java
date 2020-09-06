package com.rico.InputOutputTesr;

/**
 * @author Rico_dds
 * @date 2020/8/29 12:09
 */
import java.util.*;
public class Main04 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            if (str.equals("0"))return;
            if (!str.contains(" ")){
                System.out.println(Integer.valueOf(str));
                continue;
            }
            String[] strs = str.split(" ");
            int sum = 0;
            for (int i = 1; i < strs.length; i ++){
                sum += Integer.valueOf(strs[i]);
            }
            System.out.println(sum);
        }
    }
}