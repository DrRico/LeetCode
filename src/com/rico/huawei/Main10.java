package com.rico.huawei;

import java.util.*;

/**
 * @author Rico_dds
 * @date 2020/8/25 17:35
 * 数据表记录包含表索引和数值（int范围的整数），
 * 请对表索引相同的记录进行合并，即将相同索引的
 * 数值进行求和运算，输出按照key值升序进行输出。
 *
 *输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 *
 * 输出描述:
 * 输出合并后的键值对（多行）
 *输入
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 *
 * 输出
 * 0 3
 * 1 2
 * 3 4
 *
 *
 */
public class Main10 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        while(sc.hasNext()){
            int rows = sc.nextInt();
            for(int i = 0; i < rows; i ++){
                int key = sc.nextInt();
                int value = sc.nextInt();
                if(map.containsKey(key)){
                    map.put(key,map.get(key) + value);
                } else {
                    map.put(key,value);
                    list.add(key);
                }

//                String[] strs = sc.nextLine().split(" ");
//                if(map.containsKey(strs[0])){
//                    map.put(Integer.valueOf(strs[0]),map.get(strs[0]) + Integer.valueOf(strs[1]));
//                } else {
//                    map.put(Integer.valueOf(strs[0]),Integer.valueOf(strs[1]));
//                }
            }
            Collections.sort(list);
            for(Integer i : list){
                System.out.println(i+ " " + map.get(i));
            }
        }
    }

}
