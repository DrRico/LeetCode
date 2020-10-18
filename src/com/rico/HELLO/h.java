package com.rico.HELLO;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Rico_dds
 * @date 2020/10/13 9:43
 */

public class h {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        // qwe  ewq
        for (int i = 0; i < a.length / 2; i++) {
            int temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(a));
//        StringBuffer sb = new StringBuffer("abcdefg");
//        System.out.println(sb);
//        sb.reverse();
//        System.out.println(sb);
//        "".indexOf("");
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("key", "oldValue");
        System.out.println(map.put("key", "newValue"));
        System.out.println(map.get("key"));
    }
}
