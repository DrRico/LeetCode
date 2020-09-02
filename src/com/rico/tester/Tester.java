package com.rico.tester;

/**
 * @author Rico_dds
 * @date 2020/6/29 20:38
 */
public class Tester{
    static{
        int x=5;
    }
    static int x,y;
    public static void main(String args[]){
//        x--;
//        myMethod( );
//        System.out.println(x+y+ ++x);
        //System.out.println(val());

        String str =
                "";
        System.out.print(str.split(",").length);

    }
    public static void myMethod( ){
        y=x++ + ++x;
    }

    public static int val() {
        int num = 5;
        try {
            num = num / 0;
        } catch (Exception e) {
            num = 10;
        } finally {
            num = 15;
        }
        return num;
    }
}
