package com.rico.InputOutputTesr;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/8/29 11:44
 */
public class Main01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            String[] str = s.split(" ");
            int[] nums = new int[str.length];
            for (int i = 0; i < str.length; i ++){
                nums[i] = Integer.valueOf(str[i]);
            }
            System.out.println(nums[0]*nums[1]);
        }

    }
}
