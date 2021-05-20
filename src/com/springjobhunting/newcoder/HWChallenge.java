package com.springjobhunting.newcoder;

import java.util.*;

/**
 * @author Rico_dds
 * @date 2021/3/11 15:49
 */
public class HWChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strN = sc.nextLine();
        int N = Integer.parseInt(strN);
        List<List<String>> server = new ArrayList<>(N);
        while(N -- > 0){    // N个服务器的情况
            String string = sc.nextLine();
            String[] strings = string.substring(1,string.length() - 1).split(", ");
            ArrayList<String> list = new ArrayList<>(5);
            for (int i = 0; i < 5; i++) {
                list.add(strings[i]);
            }
            server.add(new ArrayList<>(list));
        }
        System.out.println(server);
        int M = Integer.parseInt(sc.nextLine());
        List<List<String>> virtual = new ArrayList<>(M);
        while(M -- > 0){    // M个虚拟机的情况
            String string = sc.nextLine();
            String[] strings = string.substring(1,string.length() - 1).split(", ");
            ArrayList<String> list = new ArrayList<>(4);
            for (int i = 0; i < 4; i++) {
                list.add(strings[i]);
            }
            virtual.add(new ArrayList<>(list));
        }
        System.out.println(virtual);
        int T = Integer.parseInt(sc.nextLine());
        Set<String> user = new HashSet<>();
        while (T-- > 0){    // T天的请求序列
            int R = Integer.parseInt(sc.nextLine());
            while (R-- > 0){    // 每天的情况，R个请求数
                String string = sc.nextLine();
                String[] strings = string.substring(1,string.length() - 1).split(", ");
                if(strings[0].equals("add")){
                    user.add(strings[2]);
                } else {
                    user.remove(strings[1]);
                }
            }
            // 清算每天的结果
            System.out.println(user);
        }

    }
}
