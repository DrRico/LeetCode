package com.springjobhunting.newcoder;

import java.util.Stack;

/**
 * @author Rico_dds
 * @date 2021/2/28 10:35
 */
public class validSymbol {
    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "(]";
        String s3 = "([)]";

        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
    }

    static boolean isValid(String s){
        if (s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()){
            if (ch == '('){
                stack.push(')');
            } else if (ch == '['){
                stack.push(']');
            } else if (ch == '{'){
                stack.push('}');
            } else if (stack.isEmpty() || ch != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
