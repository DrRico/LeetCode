package com.rico.vivo;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/9/12 18:51
 */
public class Main_03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(fun(str)){
            System.out.println(false);
            return;
        } else {

        }
    }
    private static boolean fun(String s){
        int low = 0, hi = s.length() - 1;
        while (low < hi){
            char char1 = s.charAt(low), char2 = s.charAt(hi);
            if (char1 == char2){
                low ++;
                hi --;
            } else {
                boolean f1 = true, f2 = true;
                for (int i = low, j = hi - 1; i < j; i++, j --) {
                    char char3 = s.charAt(i), char4 = s.charAt(j);
                    if (char3 != char4){
                        f1 = false;
                        break;
                    }
                }
                for (int i = low + 1, j = hi; i < j; i++, j --) {
                    char char3 = s.charAt(i), char4 = s.charAt(j);
                    if (char3 != char4){
                        f2 = false;
                        break;
                    }
                }
                return f2 || f1;

            }

        }
        return  true;
    }

}
