package com.rico.oppo;

import java.util.*;
/**
 * @author Rico_dds
 * @date 2020/11/18 20:19
 */
public class Main_03 {
    public static void main(String[] args) {
        System.out.println(isvalid("<{}>"));
    }
    public static boolean isvalid(String s){
        if (s.equals("") || s.length() == 0) return true;// 特殊条件判断
        Stack<Character> stack = new Stack<>();    // 使用辅助栈去判断
        for (char ch : s.toCharArray()){    // 遍历进行判断
            if(ch == '('){
                stack.push(')');
            } else if (ch == '['){
                stack.push(']');
            } else if (ch == '{'){
                stack.push('}');
            } else if (ch == '<'){
                stack.push('>');
            } else if (stack.isEmpty() || ch != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}

