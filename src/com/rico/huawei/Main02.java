package com.rico.huawei;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * @author Rico_dds
 * @date 2020/8/25 10:19
 * 连续输入字符串(输出次数为N,字符串长度小于100)，请按长度为8拆分每个字符串后输出到新的字符串数组，
 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 首先输入一个整数，为要输入的字符串个数。
 * 输入描述:
 * 首先输入数字n，表示要输入多少个字符串。连续输入字符串(输出次数为N,字符串长度小于100)。
 * 输出描述:
 * 按长度为8拆分每个字符串后输出到新的字符串数组，长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * 输入：
 * 2
 * abc
 * 12345789
 * 输出：
 * abc00000
 * 12345678
 * 90000000
 *
 */
public class Main02 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int num = scanner.nextInt();    // 那到第一个数据进行判断接下来有多少组数据
            for (int i = 0; i < num; i ++){ // 循环判断接下来的数据组数
                String string = scanner.next();
                while (string.length() % 8 != 0){   // 这里很关键，判断是不是8的倍数，不是则添加0,直到为8的倍数
                    string += "0";
                }
                for (int j = 0; j < string.length(); j += 8){   // 对目标进行输出，每8个字符输出一次
                    System.out.println(string.substring(j,j + 8));
                }

            }
            break;
        }
    }
}
