package com.rico.lceasy;

/**
 * @author Rico_dds
 * @date 2020/9/20 15:20
 */
public class isSubsequence392 {

    public static boolean isSubsequence(String s, String t) {
        int slen = s.length(), tlen = t.length();
        int m = 0, n = 0;
        while (m < tlen && n < slen){
            if (s.charAt(n) == t.charAt(m)){
                n ++;
            }
            m ++;
        }

        return slen == n;
    }

    public static void main(String[] args) {

        System.out.println(isSubsequence("abc","ahbgdc"));

    }

}
