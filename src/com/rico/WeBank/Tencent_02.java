package com.rico.WeBank;

/**
 * @author Rico_dds
 * @date 2020/11/23 9:20
 */
public class Tencent_02 {
    public static void main(String[] args) {
        int n = -7;
        int cnt = 0;
        // 解法一：
        /*
        * 把一个整数n减去1，再和原来的整数与运算，会把该整数的最右边的1变成0，
        * 那么，一个整数的二进制中有多少个1，就可以进行多少次这样的操作。循环结束的条件是n为0
        * */
        int num = n;
        while (num != 0){
            num = (num - 1) & num;
            cnt ++;
        }
        System.out.println(cnt);

        // 解法二：
        /*
        *   将int转换为二进制的字符串后，判断1的个数。
        * */
        int num2 = n;
        cnt = 0;
        String string = Integer.toBinaryString(num2);
        for (char ch : string.toCharArray()){
            if(ch == '1')cnt ++;
        }
        System.out.println(cnt);
    }
}
