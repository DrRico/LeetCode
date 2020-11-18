package com.rico.YueWen;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Rico_dds
 * @date 2020/10/21 14:25
 */
public class YueWen_01 {
    public static void main(String[] args) {
        int num = 17;
        while (num > 0){
            System.out.println(num ++ % 5);
            num /= 5;
        }
    }
}
