package com.rico.HELLO;

/**
 * @author Rico_dds
 * @date 2020/10/20 14:41
 */
public class hh {
    public static void main(String[] args) {
        OneToMoreMap<Integer, Integer> map = new OneToMoreMap<>();
        map.put(0,0);
        map.put(0,1);
        map.put(0,2);
        map.put(0,2);
        map.put(1,2);
        map.put(1,2);
        map.put(2,3);
        for (int i = 0; i < map.getSize(); i++) {
            System.out.println(map.get(i));
        }
        System.out.println(map.getAll());

    }
}


