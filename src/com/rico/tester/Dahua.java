package com.rico.tester;

/**
 * @author Rico_dds
 * @date 2020/9/15 19:10
 */
public class Dahua {
    static boolean foo( char c){
        System.out.print(c);
        return true;
    }

    public static void main(String[] args) {
        int i = 0;
        for (foo('B'); foo('A') && (i < 2); foo('C')) {
            i ++;
            foo('D');

        }
    }
}
