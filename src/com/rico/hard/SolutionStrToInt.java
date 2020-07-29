package com.rico.hard;

/**
 * @author Rico_dds
 * @date 2020/7/29 16:11
 */
public class SolutionStrToInt {

    public static int StrToInt(String str) {
        int len = str.length();
        if(len == 0 || str == null){
            return 0;
        }
        boolean flag = str.charAt(0)=='-'?false:true;
        int[] list = new int[len];
        for(int i=0;i<len;i++){
            if(str.charAt(i)>= '0' && str.charAt(i) <= '9'){
                list[i] = (int)str.charAt(i) - 48;
            }else if(i == 0 && (str.charAt(i) == '+' ||str.charAt(i) == '-')){
                continue;
            }else{
                return 0;
            }
        }
        int sum = 0;
        for(int i=0;i<len;i++){
            sum += list[i] * Math.pow(10,len - i - 1) ;
        }
        return flag?sum:-sum;
    }

    public static void main(String[] args) {
        System.out.println(StrToInt("-012378"));
    }
}
