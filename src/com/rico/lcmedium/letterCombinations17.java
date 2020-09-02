package com.rico.lcmedium;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

/**
 * @author Rico_dds
 * @date 2020/9/2 10:59
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 */
public class letterCombinations17 {
    static char[][] m = {{},{},{'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},{'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}}; //0和1是空的，值是从2开始

    public static List<String> letterCombinations(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str.length() == 0) return res;

        dfs(0, str, new StringBuilder(), res);
        return res;

    }

    static void dfs(int index,String str, StringBuilder sb, ArrayList<String> res){
        if (sb.length() == str.length()){
            res.add(sb.toString());
            return;
        }
        for (char c : m[str.charAt(index) - '0']){
            sb.append(c);
            dfs(index + 1, str, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

}
