package com.rico.lcmedium;

import java.util.ArrayDeque;
/**
 * @author Rico_dds
 * @date 2020/9/1 15:54
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 *
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 *
 * 请返回任意一个合法字符串。
 *
 * 有效「括号字符串」应当符合以下 任意一条 要求：
 *
 * 空字符串或只包含小写字母的字符串
 * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 *示例 1：
 *
 * 输入：s = "lee(t(c)o)de)"
 * 输出："lee(t(c)o)de"
 * 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 * 示例 2：
 *
 * 输入：s = "a)b(c)d"
 * 输出："ab(c)d"
 * 示例 3：
 *
 * 输入：s = "))(("
 * 输出：""
 * 解释：空字符串也是有效的
 */
public class minRemoveToMakeValid1249 {

    public static String minRemoveToMakeValid(String s) {
        if (s.length() == 0) return s;
        boolean[] flags = new boolean[s.length()];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.addLast(i);
            } else if (ch == ')'){
                if(stack.isEmpty()){
                    flags[i] = true;
                }
                else {
                    stack.pollLast();
                }
            }
        }
        while (!stack.isEmpty()){
            flags[stack.pollLast()] = true;
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = s.length() - 1; i >= 0; i --){
            if(flags[i])sb.deleteCharAt(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));

    }
}
