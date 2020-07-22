package com.rico.medium;

/**
 * @author Rico_dds
 * @date 2020/7/20 20:42
 */
public class SolutionPower {
    public static double Power(double base, int exponent) {
        if(exponent == 0){
            return 1;
        }
        double sum = 1.0;
        boolean f = (exponent > 0 ? true : false);
        if(!f){
            exponent = -exponent;
        }
        for(int i = 0; i < exponent; i++){
            sum = sum * base;
        }
        if(f){
            return sum;
        }else {
            return 1/sum;
        }
    }
    public static double Power_(double base, int exponent) {
        if(exponent<0){
            exponent = -exponent;
        }
        double sum = 1.0;
        while(exponent!=0){
            if((exponent&1) == 1){
                sum = base * sum;
            }
            base = base * base;
            exponent =  exponent >> 1;
        }
        return exponent>=0?sum:(1/sum);
    }

    public static void main(String[] args) {
        System.out.println(Power_(2,-3));
    }

}
