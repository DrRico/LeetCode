package com.rico.oppo;

/**
 * @author Rico_dds
 * @date 2020/11/18 18:36
 * 判断字符串是否包含子字符串，并返回子字符串所在字符串的下标
 */
public class Main_02 {

    public static void main(String[] args) {
        System.out.println(findIndex("remenber","men"));
        System.out.println(findIndex("aaaaaaa","bb"));
        System.out.println(findIndex("aaaaaaaaa","aaaaa"));
//        long b = 0, c = 1, a = 8;
//        int cnt = 0;
//        while (c <= a) {
//            a -= c;
//            c += b;
//            b = c - b;
//            cnt ++;
//        }
//        System.out.println(cnt);
    }

    public static int findIndex(String a, String b){
        int p1 = 0;
        int index = 0;
        for (int i = 0; i < a.length(); i++) {
            index = i;
            String str = "";
            for (int j = i;str.length() < b.length(); j--) {
                if (j >= 0){
                    str = a.charAt(j) + str;
                } else break;
            }
            if (b.equals(str)){
                p1 = 1;
                break;
            } else {
                p1 = 0;
            }
        }
        if (p1 == 1){
            return index + 1 - b.length();
        } else if (b == "") {
            return 0;
        } else {
            return -1;
        }
    }
}
