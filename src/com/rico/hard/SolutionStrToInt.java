package com.rico.hard;

/**
 * @author Rico_dds
 * @date 2020/7/29 16:11
 */
public class SolutionStrToInt {

    public static int StrToInt(String str) {
        int len = str.length();
        if(len == 0 || str == null){//判断空串或者null
            return 0;
        }
        //排除"0123"、"-0123"、"+0123"、"-"、"+"等情况，若是则直接返回0
        if(str.charAt(0)=='0' || (len>1 && ((str.charAt(0) == '+' ||str.charAt(0) == '-') && str.charAt(1) == '0'))){
            return 0;
        }
        int[] list = new int[len];    //创建数组来保存正确匹配的结果
        for(int i=0;i<len;i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                list[i] = (int)str.charAt(i) - 48;    //返回真正的数值，‘0’的ASCII码为48
            }else if(i == 0 && (str.charAt(i) == '+' ||str.charAt(i) == '-')){
                continue;    //处理带符号的情形
            }else{
                return 0;
            }
        }
        int sum = 0;
        for(int i=0;i<len;i++){    //处理返回的数值
            sum = sum * 10 + list[i];
            // 或者sum += list[i] * Math.pow(10,len - i - 1) ;以空间换时间
        }
        return str.charAt(0)!='-' ? sum : -sum;
    }

    public static void main(String[] args) {
        System.out.println(StrToInt("-1237809"));
    }
}
