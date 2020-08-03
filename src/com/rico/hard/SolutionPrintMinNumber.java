package com.rico.hard;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Rico_dds
 * @date 2020/8/3 15:07
 *输入一个正整数数组，把数组里所有数字拼接
 * 起来排成一个数，打印能拼接出的所有数字
 * 中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
public class SolutionPrintMinNumber {

    public static String PrintMinNumber(int [] numbers) {
        int len = numbers.length;
        if (len == 0 || numbers == null) return "";
        if (len == 1)return numbers[0] + "";
        String[] str = new String[len];
        String sb = "";
        for(int i = 0; i < len; i ++){
            str[i] = "" + numbers[i];
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1,String s2){
                String res1 = s1 + s2;
                String res2 = s2 + s1;
                return res1.compareTo(res2);
            }
        });
        for(int i = 0; i < len; i ++){
            sb += str[i];
        }
        return sb;
    }

    public static String PrintMinNumber_1(int [] numbers) {
        int len = numbers.length;
        if (len == 0 || numbers == null) return "";
        if (len == 1)return numbers[0] + "";
        for(int i = 0; i < len; i ++){
            for(int j = i + 1; j < len; j ++){
                int a = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int b = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if(a > b){
                    int c = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = c;
                }
            }
        }
        String str = "";
        for(int i = 0; i < len; i ++){
            str += numbers[i];
        }
        return str;
    }


    public static void main(String[] args) {
        int[] a = new int[] {3,32,321};
        System.out.println(PrintMinNumber_1(a));
    }


}
