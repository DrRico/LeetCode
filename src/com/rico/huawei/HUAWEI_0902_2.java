package com.rico.huawei;

import com.sun.org.apache.bcel.internal.generic.RET;

import javax.security.auth.callback.CallbackHandler;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/9/2 18:58
 * 4,5
 * SSHHH
 * SSHHH
 * HHSHH
 * HHHSS
 */
public class HUAWEI_0902_2 {
    static int ROW;
    static int COL;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sss = scanner.nextLine();
        String[] ss = sss.split(",");

        int rows = Integer.valueOf(ss[0]);
        int cols = Integer.valueOf(ss[1]);

//        int rows = ss[0] - '0';
//        int cols = ss[ss.length - 1] - '0';
        char[][] chars = new char[rows][cols];
        for (int i = 0; i < rows; i ++){
            String s = scanner.nextLine();
            for (int j = 0; j < cols; j ++){
                chars[i][j] = s.charAt(j);
            }
        }
        System.out.println(number(chars));

    }

    public static void dfs (char[][] chars,int i, int j){
        //截止条件
        if (i < 0 || j < 0 || i >= chars.length || j >=chars[0].length || chars[i][j] == 'H') return;
        chars[i][j] = 'H';
        dfs(chars, i + 1, j);
        dfs(chars, i - 1, j);
        dfs(chars, i, j + 1);
        dfs(chars, i, j - 1);
    }
    public static int number(char[][] chars){
        int res = 0;
        for (int i = 0; i < chars.length; i ++){
            for (int j = 0; j < chars[0].length; j ++){
                if (chars[i][j] == 'S'){
                    dfs(chars,i,j);
                    res ++;
                }
            }
        }
        return res;
    }
}
