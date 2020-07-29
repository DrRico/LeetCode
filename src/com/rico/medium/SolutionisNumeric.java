package com.rico.medium;

/**
 * @author Rico_dds
 * @date 2020/7/28 14:29
 */
public class SolutionisNumeric {

    public static boolean isNumeric(String str) {

        return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        // return str.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
                            //"[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?"
    }

    public static void main(String[] args) {

        System.out.println(isNumeric("-123.3"));
    }

}
