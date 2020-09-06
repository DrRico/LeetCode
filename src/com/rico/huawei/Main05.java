package com.rico.huawei;

/**
 * @author Rico_dds
 * @date 2020/8/25 14:45
 *题目描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * 输入描述:
 * 输入一个正浮点数值
 * 输出描述:
 * 输出该数值的近似整数值
 * 示例1
 * 输入
 * 5.5
 * 输出
 * 6
 */
import java.util.*;
public class Main05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float num = sc.nextFloat();
        System.out.println((int)(num + 0.5));// 通过加上0.5，再强制类型转换
    }
}