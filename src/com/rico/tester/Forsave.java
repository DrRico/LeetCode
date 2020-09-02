package com.rico.tester;

/**
 * @author Rico_dds
 * @date 2020/9/2 16:45
 */

    import java.util.*;
    public class Forsave {
        public static int house (int[] num) {
            int len = num.length;
            int left = 0;
            int right = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++){
                if (num[i] < min){
                    left = i;
                    right = i;
                    min = num[i];
                }
            }

            int res[] = new int[len];
            res[left] = 1;
            while (left - 1 >= 0){
                if (num[left - 1] >num[left]){
                    res[left - 1] = res[left] + 1;
                } else {
                    res[left - 1] = res[left];
                }
                left --;
            }
            while (len - 1 > right){
                if (num[right + 1] > num[right]){
                    res[right + 1] = res[right] + 1;
                } else if(num[right + 1] == num[right]) {
                    res[right + 1] = 1;
                } else {
                    res[right + 1] = res[right];
                }
                right ++;
            }
            int sum = 0;
            for (int i = 0; i < len; i ++){
                sum += res[i];
            }
            return sum;
            //System.out.println(Arrays.toString(res));// [4,1,3,3,3] >>[2,1,2,1,1]
        }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] arr = s.substring(1,s.length() - 1).split(",");
            int[] num = new int[arr.length];
            for (int i = 0; i < arr.length; i ++){
                num[i] = Integer.valueOf(arr[i]);
            }
            System.out.println(house(num));// [4,1,3,3,3] >>[2,1,2,1,1]
        }

    }
