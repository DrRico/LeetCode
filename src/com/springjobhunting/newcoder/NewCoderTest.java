package com.springjobhunting.newcoder;

import java.util.Map;

/**
 * @author Rico_dds
 * @date 2021/3/25 15:09
 */
public class NewCoderTest {
    public static void main(String[] args) {
        System.out.println(NewCoderTest.class.getClassLoader().getClass().getName());
        System.out.println(System.class.getClassLoader());
        System.out.println(Map.class.getClassLoader());
        NewCoderTest cl = new NewCoderTest();
        System.out.println(cl.getClass().getName());

    }
}
