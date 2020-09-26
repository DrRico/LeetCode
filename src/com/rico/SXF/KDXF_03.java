package com.rico.SXF;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/9/26 19:42
 */

// ___aaa__b____c__dd___
public class KDXF_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder sb = new StringBuilder(str);
        int i;
        for (i = sb.length() - 1; i >= 0; i -- ) {
            if(sb.charAt(i) != '_'){
                break;
            }
        }
        sb = new StringBuilder(sb.substring(0,i + 1));

        // System.out.println(sb.toString());

        StringBuilder out = new StringBuilder();

        boolean flag = true;
        for (int j = 0; j < sb.length(); j++) {
            if (flag && sb.charAt(j) == '_'){
                continue;
            } else if (flag && sb.charAt(j) != '_'){
                flag = false;
                out.append(sb.charAt(j));
            } else if (!flag && sb.charAt(j) == '_'){
                out.append('_');
                while (sb.charAt(j + 1) == '_' && j + 1 < sb.length()){
                    j ++;
                }
            } else {
                out.append(sb.charAt(j));
            }
        }

        System.out.println(out.toString());

/*        for (int i = sb.length() - 1; i >= 0; i --) {
            if(sb.charAt(i) == '_'){
                sb.deleteCharAt(i);
            }
        }
        System.out.println(sb.length());
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i-1) != sb.charAt(i)){
                sb.insert(i,"_");
            }
        }*/
    }
}
