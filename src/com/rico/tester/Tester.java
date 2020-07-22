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
        x--;
        myMethod( );
        System.out.println(x+y+ ++x);
    }
    public static void myMethod( ){
        y=x++ + ++x;
    }
}
