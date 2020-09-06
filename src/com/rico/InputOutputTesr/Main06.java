package com.rico.InputOutputTesr;

/**
 * @author Rico_dds
 * @date 2020/8/29 15:06
 */
import java.util.*;
public class Main06 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nums = Integer.parseInt(sc.nextLine());
        if (nums == 0)return;
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        Arrays.sort(strs);
        for (int i = 0; i < strs.length; i ++){
            System.out.print(strs[i] + " ");
        }
    }
}