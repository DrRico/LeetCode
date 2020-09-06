package com.rico.lceasy;

import java.util.Arrays;

/**
 * @author Rico_dds
 * @date 2020/8/28 17:58
 */
public class plusOne66 {
    public static int[] plusOne(int[] digits) {
        int[] temp = new int[digits.length + 1];
        if(++digits[digits.length - 1] == 10){
            for (int i = 0;i < digits.length; i ++){
                temp[i + 1] = digits[i];
            }
        } else {
            return digits;
        }
        digits = temp;
        for (int i = digits.length - 1; i >= 0; i --){
            if(digits[i]>9){
                digits[i] = 0;
                digits[i - 1] ++;
            }
        }
        if (digits[0] == 0){
            return Arrays.copyOfRange(digits,1,digits.length);
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] a = {1,2,9};
        a = plusOne(a);
        for (int i = 0;i < a.length; i ++) {
            System.out.print(a[i]);
        }
    }


}
