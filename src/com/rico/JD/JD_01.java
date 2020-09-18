package com.rico.JD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Rico_dds
 * @date 2020/9/17 18:56
 */
public class JD_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String string = sc.nextLine();
            String regEx="[^0-9]";
            Pattern p=Pattern.compile(regEx);
            String[] r = p.split(string);
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < r.length; i++) {
                if (r[i].equals("") || r[i].length() == 0)continue;
                Integer num = Integer.valueOf(r[i]);
                if (num >= 1000 && num <= 3999) list.add(num);
            }
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.print(list.get(i) + " ");
            }

            System.out.print(list.get(list.size() - 1));
        }
    }

}
