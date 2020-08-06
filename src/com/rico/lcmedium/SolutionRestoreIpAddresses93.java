package com.rico.lcmedium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rico_dds
 * @date 2020/8/5 15:51
 *给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
示例:
输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]
 */
public class SolutionRestoreIpAddresses93 {

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.equals("") || s.length()==0){
            return res;
        }
        dfs(s, -1, new StringBuilder(), res);
        return res;
    }

    static void dfs(String s, int index, StringBuilder sb, List<String> res){
        //1 截止条件
        if(sb.length() == s.length() + 4 || index == s.length() - 1){
            if(sb.length() == s.length() + 4  && index == s.length() - 1){
                res.add(sb.toString().substring(0,sb.length() - 1));
            }
            return;
        }
        // 2 候选节点
        for(int i = 1; i < 4; i++){
            if(index + i + 1 >= s.length() + 1){
                continue;
            }
            String x = s.substring(index + 1,index + i + 1);
            //if(x.equals(""))continue;
            //2.1 筛选候选节点
            int num = Integer.parseInt(x);
            if(num <= 255 && (x.equals("0") || !x.startsWith("0"))){
                int len = sb.length();
                sb.append(x + ".");
                dfs(s, index + i, sb, res);
                sb.delete(len, len + x.length() + 1);
            }
        }
    }



    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("19216801"));
    }

}
