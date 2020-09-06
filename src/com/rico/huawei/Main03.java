package com.rico.huawei;

/**
 * @author Rico_dds
 * @date 2020/8/25 11:50
 * 编写一个函数，计算字符串中含有的不同字符的个数。字
 * 符在ACSII码范围内(0~127)，换行表示结束符，不算在
 * 字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 输入
 * abaca
 * 输出
 * 3
 */
import java.util.*;
public class Main03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int cnt = 0;
        Set set = new HashSet();
        for (int i = 0; i < str.length(); i ++){
            char j = str.charAt(i);
            if(set.add(j) && j > 0 && j < 127)cnt ++; // 使用hashset进行判断重复
        }
        System.out.println(cnt);
    }
}