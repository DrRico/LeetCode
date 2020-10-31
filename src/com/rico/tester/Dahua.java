package com.rico.tester;

import java.util.ArrayList;

/**
 * @author Rico_dds
 * @date 2020/9/15 19:10
 */
public class Dahua {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str.length() == 0 || str.equals("")) return res;
        boolean[] dp = new boolean[str.length()];
        dfs(str,dp,new StringBuilder(),res);
        return res;
    }
    public static void dfs(String str,boolean[] dp,StringBuilder sb,ArrayList<String> res){
        if(sb.length() == str.length()){
            res.add(sb.toString());
            return;
        }
        for (int j = 0; j < str.length(); j++) {
            char ch = str.charAt(j);
            if(!dp[j]){
                dp[j] = true;
                sb.append(ch);
                dfs(str,dp,sb,res);
                sb.deleteCharAt(sb.length()-1);
                dp[j] = false;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(Permutation("abc"));
    }
}
