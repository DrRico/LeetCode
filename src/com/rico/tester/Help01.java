package com.rico.tester;

import java.util.*;

/**
 * @author Rico_dds
 * @date 2020/9/8 10:59
 *
 *-------------------------未调试完成-------------------------------
 */
public class Help01 {
    public static void main(String[] args) {
        String[] c = {"c1","c2","c3"};
        Integer[] x = {3,2,1};
        Integer[] y = {3,3,3};
        String[] q = {"c3","c2","c1"};
        System.out.println(closetStraightCity(Arrays.asList(c),Arrays.asList(x),Arrays.asList(y),Arrays.asList(q)));

    }
    public static List<String> closetStraightCity(List<String> c,List<Integer> x,List<Integer> y, List<String> q){
        int xmin, ymin;
        TreeMap<String,Integer> map = new TreeMap<>();
        String[] resString = new String[c.size()];
        int j = 0;
        for(String s : q){
            int index = c.indexOf(s);
            int xx = x.get(index), yy = y.get(index);
            xmin = Integer.MAX_VALUE;
            ymin = Integer.MAX_VALUE;
            for (int i = 0;i < c.size(); i ++){
                if (index == i) continue;
                if (xx == x.get(i) && yy != y.get(i) && Math.abs(yy - y.get(i)) <= ymin){
                    ymin = Math.abs(yy - y.get(i));
                    map.put(c.get(i),ymin);
                }
                if (yy == y.get(i) && xx != x.get(i) && Math.abs(xx - x.get(i)) <= xmin){
                    xmin = Math.abs(xx - x.get(i));
                    map.put(c.get(i),xmin);
                }
            }
            if (map.size() == 0){
                resString[j ++] = "None";
            } else {
                int min = Integer.MAX_VALUE;
                int k = 0;
                Set<String> set = map.keySet();
                String[] p = new String[set.size()];
                for (String string : set) {
                    if (map.get(string) <= min){
                        min = map.get(string);
                        p[k++] = string;
                        // if(map.get(string) == min)
                    }
                }
                Arrays.sort(p);
                resString[j ++] = p[0];
            }
            map.clear();
        }
        return Arrays.asList(resString);
    }
}


/*
for (int i = 0; i < c.size(); i ++){
        int xx = x.get(i), yy = y.get(i);
        xmin = Integer.MAX_VALUE;
        ymin = Integer.MAX_VALUE;
        for (int j = i; j < c.size(); j++) {
        if (i != j && xx == x.get(j) && Math.abs(xx - x.get(j)) < xmin){
        xmin = Math.abs(xx - x.get(j));
        sb.add(c.get(i));
        }
        if (i != j && yy == y.get(j) && Math.abs(yy - y.get(j)) < ymin){
        ymin = Math.abs(yy - y.get(j));
        sb.add(c.get(i));
        }
        }
        if (sb.size() == 0){
        resString[i] = "None";
        } else {
        Collections.sort(sb);
        resString[i] = sb.get(0);
        }
        sb.clear();
        }*/
