package com.springjobhunting.newcoder;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2021/2/27 22:20
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，
 * 你能帮助他么？
 *
 *  in : "nowcoder. a am I"
 *
 *  out : "I am a nowcoder."
 */
public class ReverseSentence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        if (s.length == 0){
            System.out.println(str);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length - 1; i++) {
            sb.append(s[s.length - 1 - i] + " ");
        }
        System.out.println(sb.toString() + s[0]);
    }

}
