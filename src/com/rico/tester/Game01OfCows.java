package com.rico.tester;

import java.awt.geom.FlatteningPathIterator;
import java.util.Stack;

/**
 * @author Rico_dds
 * @date 2020/8/13 21:59
 */
public class Game01OfCows {
    public static String solve (String str) {
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if (!stack.isEmpty() && c == '0' && stack.peek() == '0'){
                stack.pop();
                if(!stack.isEmpty() && stack.peek() == '1'){
                    stack.pop();
                }else{
                    stack.push('1');
                }
            }else if (!stack.isEmpty() && c == '1' && stack.peek() == '1'){
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(solve("00110001"));
    }
}
