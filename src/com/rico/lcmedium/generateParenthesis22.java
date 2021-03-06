package com.rico.lcmedium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rico_dds
 * @date 2020/9/1 9:52
 */
public class generateParenthesis22 {

    public static List<String> generateParenthesis(int n) {
        char[] p = new char[]{'(', ')'};
        int[] pb = new int[]{n, n};
        List<String> res = new ArrayList<>();
        dfs(n, p, pb, new StringBuilder(), res);
        return res;
    }
    static void dfs(int n,char[] p, int[] pb, StringBuilder sb, List<String> res){
        //截止条件
        if(n*2 == sb.length()){
            res.add(sb.toString());
            return;
        }
        //候选节点；
        if(pb[0]>0){
            pb[0] --;
            sb.append(p[0]);
            dfs(n, p, pb, sb, res);
            sb.delete(sb.length() - 1, sb.length());
            pb[0] ++;
        }
        if(pb[1]>0 && pb[0] != pb[1]){
            pb[1] --;
            sb.append(p[1]);
            dfs(n, p, pb, sb, res);
            sb.delete(sb.length() - 1, sb.length());
            pb[1] ++;
        }
    }


    public static List<String> generateParenthesis_1(int n){
        List<String> res = new ArrayList<String>();
        if (n <= 0) return res;
        dfs_1(n, n, new StringBuffer(), res);
        return res;
    }

    private static void dfs_1(int left, int right, StringBuffer sb, List<String> res) {
        if(left > right || left < 0 || right < 0) return;
        if(left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        sb.append('(');
        dfs_1(left - 1, right, sb, res);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        dfs_1(left, right - 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);
    }


    public static void main(String[] args) {
        System.out.println("[((())), (()()), (())(), ()(()), ()()()]");
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis_1(3));
    }
}
