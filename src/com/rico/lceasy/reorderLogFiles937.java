package com.rico.lceasy;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Rico_dds
 * @date 2020/8/31 14:13
 * 你有一个日志数组 logs。每条日志都是以空格分隔的字串。
 *
 * 对于每条日志，其第一个字为字母与数字混合的 标识符 ，除标识符之外的所有字为这一条日志的 内容 。
 *
 * 除标识符之外，所有字均由小写字母组成的，称为 字母日志
 * 除标识符之外，所有字均由数字组成的，称为 数字日志
 * 题目所用数据保证每个日志在其标识符后面至少有一个字。
 *
 * 请按下述规则将日志重新排序：
 *
 * 所有 字母日志 都排在 数字日志 之前。
 * 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序；
 * 数字日志 应该按原来的顺序排列。
 * 返回日志的最终顺序。
 * 示例 ：
 *
 * 输入：["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * 输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]

 *
 */
public class reorderLogFiles937 {

    public static String[] reorderLogFiles(String[] logs) {
        int len = logs.length;
        if (len < 2) return logs;
        ArrayList numlist = new ArrayList();
        ArrayList charlist = new ArrayList();
        for(int i = 0; i < len; i ++){
            if (logs[i].charAt(logs[i].length() - 1) >= '0' && logs[i].charAt(logs[i].length() - 1) <= '9'){
                numlist.add(logs[i]);
            } else {
                charlist.add(logs[i]);
            }
        }
        Collections.sort(charlist, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // 取字母a日志的标识符及内容
                int ai = a.indexOf(" ");
                String ida = a.substring(0, ai);
                String loga = a.substring(ai + 1);

                // 取字母b日志的标识符及内容
                int bi = b.indexOf(" ");
                String idb = b.substring(0, bi);
                String logb = b.substring(bi + 1);

                // 对比二者内容，如果相同则对比标识符
                int cmp = loga.compareTo(logb);
                if (cmp == 0)
                    return ida.compareTo(idb);
                return cmp;
            }
        });
        charlist.addAll(numlist);
        return (String[]) charlist.toArray(new String[charlist.size()]);
    }

    public static void main(String[] args) {
        String[] a = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        System.out.println(Arrays.toString(reorderLogFiles(a)));
    }
}
