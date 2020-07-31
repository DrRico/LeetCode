package com.rico.hard;

/**
 * @author Rico_dds
 * @date 2020/7/31 10:05
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模
 * 式中的字符'.'表示任意一个字符，而'*'表示它前面的字
 * 符可以出现任意次（包含0次）。 在本题中，匹配是指字
 * 符串的所有字符匹配整个模式。例如，字符串"aaa"与模式
 * "a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class SolutionMatch {
    public boolean match(char[] str, char[] pattern)
    {
        if (str.length == 0 && pattern.length == 0){
            return true;
        }
        if (str.length != 0 && pattern.length == 0){
            return false;
        }
        return false ;

    }


}
