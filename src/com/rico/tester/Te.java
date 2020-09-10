package com.rico.tester;

/**
 * @author Rico
 * @date 2020/9/6 15:49
 */

public class Te {
    private String name = "abc";
    public static void main(String[] args) {
        Te test = new Te();
        Te testB = new Te();
        String result = test.equals(testB) + ",";
        result += test.name.equals(testB.name) + ",";
        result += test.name == testB.name;
        System.out.println(result);
    }
}
