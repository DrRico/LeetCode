package com.rico.InputOutputTesr;

/**
 * @author Rico_dds
 * @date 2020/8/29 15:12
 */
import java.util.*;
public class Main07 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            if(!str.contains(" ")){
                System.out.println(str);
                continue;
            }
            String[] strs = str.split(" ");
            Arrays.sort(strs);
            for (int i = 0; i < strs.length; i ++){
                System.out.print(strs[i] + " ");
            }
            System.out.println();
        }
    }
}
