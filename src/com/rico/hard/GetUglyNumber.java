package com.rico.hard;

/**
 * @author Rico_dds
 * @date 2020/8/21 21:50
 *把只包含质因子2、3和5的数称作丑数
 * （Ugly Number）。例如6、8都是丑
 * 数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求
 * 按从小到大的顺序的第N个丑数。
 *
 */
public class GetUglyNumber {

    private static int GetUglyNumber_Solution(int index) {
        if (index < 0) return 0;
        int[] uglyArr = new int[index];
        uglyArr[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < index; i ++){
            int lastMaxUgly = uglyArr[i - 1];
            while (lastMaxUgly >= uglyArr[p2] * 2) p2 ++;
            while (lastMaxUgly >= uglyArr[p3] * 3) p3 ++;
            while (lastMaxUgly >= uglyArr[p5] * 5) p5 ++;
            uglyArr[i] = Math.min( Math.min(uglyArr[p2] * 2,uglyArr[p3] * 3),uglyArr[p5] * 5);

        }
        return uglyArr[index - 1];
    }

    private static int GetUglyNumber_Solution_1(int index){
        if (index <= 0) return 0;
        int num = 0,count = 0;
        while (count < index){
            num ++;
            if(isUgly(num)){
                count ++;
            }
        }
        return num;
    }

    private static int GetUglyNumber_Solution_2(int index){
        int[] a = new int[index];
        a[0] = 1;
        int index1 = 0, index2 = 0, index3 = 0;
        for (int i = 1; i < index; i++){
            a[i] = Math.min(Math.min(a[index1] * 2,a[index2] * 3),a[index3] * 5);
            if(a[i] == a[index1] * 2) index1 ++;
            if(a[i] == a[index2] * 3) index2 ++;
            if(a[i] == a[index3] * 5) index3 ++;
        }
        return a[index - 1];
    }

    private static boolean isUgly(int n){
        while(n % 2 == 0) n /= 2;
        while(n % 3 == 0) n /= 3;
        while(n % 5 == 0) n /= 5;
        return n == 1;
    }

    public static void main(String[] args) {
        // System.out.println(GetUglyNumber_Solution(8));
        System.out.println(GetUglyNumber_Solution_1(15));
    }

}
