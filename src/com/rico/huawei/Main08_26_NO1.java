package com.rico.huawei;

import javafx.scene.effect.Light;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/8/28 21:44
 *
 */
public class Main08_26_NO1 {
    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        // if(sc.nextLine().length() == 0) return;
        String[] str = sc.nextLine().split(" ");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i ++){
            nums[i] = Integer.valueOf(str[i]);
        }*/
        int[] nums = {1,2};
        print(nums);
    }

    public static void print(int [] nums){
        int[] temp = new int[nums.length];
        for (int i = 0 ; i < nums.length; i ++){
            temp[i] = nums[i] >> 2;
        }
        for (int i = 0; i < nums.length - 1; i ++){
            if((nums[i] & 0x03) != 0){
                temp[i + 1] = ((nums[i] & 0x03) << 30) | temp[i + 1];
            }
        }
        if((nums[nums.length - 1] & 0x03) != 0){
            temp[0] = ((nums[nums.length - 1] & 0x03) << 30) | temp[0];
        }

        System.out.println(Arrays.toString(temp));
    }
}
