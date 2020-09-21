package com.rico.MeiTuan;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/9/20 9:42
 */
public class MeiTuan_03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            StringBuilder s = new StringBuilder();
            StringBuilder t = new StringBuilder();
            for (int i = 0; i < a; i++) {
                s.append(sc.next());
            }
            for (int i = 0; i < b; i++) {
                t.append(sc.next());
            }

            boolean flag = isSubsequence(t.toString(),s.toString());
            System.out.println(flag ? "Yes" : "No");
            if (flag) System.out.println(getIndex(s.toString(),t.toString()));

        }


    }

    private static int getIndex(String s, String t) {
        char[] chars = t.toCharArray();
        int cnt = 0;
        for (int i = 0; i < chars.length; i++) {
            cnt += s.indexOf(chars[i]) + 1;
        }
        return cnt;
    }

    public static boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

}
