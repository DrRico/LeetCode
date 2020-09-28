package com.rico.SXF;

import java.util.*;

public class JTBank_01 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String string = scanner.nextLine();
//        string = string.substring(1,string.length() - 1);
//        String[] strings = string.split(",");
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < strings.length; i++) {
//            int n = Integer.parseInt(strings[i].trim());
//            if(prime(n)){
//                list.add(n);
//            }
//        }
        Integer[] n = {3,5,11,12,17,31,7};
        System.out.println(Arrays.toString(findprime(n)) );
    }

    public static Integer[] findprime(Integer[] nums){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (prime(n)){
                list.add(n);
            }
        }
        return list.toArray(new Integer[0]);
    }

    public static boolean prime(int n){
        if(n < 2){
            return false;
        }
        if(n == 2 || n == 3){
            return true;
        }else{
            int a = (int)Math.sqrt(n);
            for(int i = 2; i <= a ; i++){
                if(n % i == 0){
                    return false;
                }
            }
            return true;
        }
    }

}
