package com.rico.huawei;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2020/8/25 16:37
 */
public class Main09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            char[] res = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < res.length; i ++){
                char ch = res[i];
                if(ch >= 'A' && ch <= 'Z'){
                    sb.append((char)(ch+32)!='z'?(char)(ch+33):'a');
                } else if(ch >= 'a' && ch <= 'z'){
                    int p = ch - 97;
                    if(p <= 18){
                        if (p == 18){
                            sb.append(7);
                            continue;
                        }
                        int toAppend = p/3 + 2;
                        sb.append(toAppend);
                    } else if(p >=19 && p <= 21){
                        sb.append(8);
                    } else {
                        sb.append(9);
                    }

                } else {
                    sb.append(ch);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
