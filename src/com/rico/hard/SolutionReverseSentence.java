package com.rico.hard;

/**
 * @author Rico_dds
 * @date 2020/8/4 22:33
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿
 * 着一本英文杂志，写些句子在本子上。同事Cat对Fish
 * 写的内容颇感兴趣，有一天他向Fish借来翻看，但却
 * 读不懂它的意思。例如，“student. a am I”。后
 * 来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一
 * 一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class SolutionReverseSentence {
    public static String ReverseSentence(String str) {
        String[] s = str.split(" ");
        for(int i = 0; i < (s.length >> 1); i ++){
            String temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
        String res = "";
        for(int i = 0; i < s.length - 1; i  ++){
            res += s[i] + " ";
        }
        return res + s[s.length - 1];
    }

    public static void main(String[] args) {
        //System.out.println(ReverseSentence("I am a student."));
        System.out.println(ReverseSentence("    "));
    }
}
