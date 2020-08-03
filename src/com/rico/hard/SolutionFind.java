package com.rico.hard;

/**
 * @author Rico_dds
 * @date 2020/8/3 17:42
 * 在一个二维数组中（每个一维数组的
 * 长度相同），每一行都按照从左到右
 * 递增的顺序排序，每一列都按照从上
 * 到下递增的顺序排序。请完成一个函
 * 数，输入这样的一个二维数组和一个整
 * 数，判断数组中是否含有该整数。
 */
public class SolutionFind {

    public static boolean Find(int target, int [][] array) {
        int x = array.length;
        int y = array[0].length - 1;
        for(int i = 0; i < x; i ++){
                if(array[i][0] < target && array[i][y] > target){
                    return true;
                }
        }
        return false;
    }

    public static boolean Find_1(int target, int [][] array) {
        int x = array.length;
        int y = array[0].length;
        for(int i = 0; i < x; i ++){
            int L = 0, R = y - 1;
            while(R >= L){
                int mid = L + ((R-L)>>1);
                if (array[i][mid] > target){
                    R = mid - 1;
                } else if (array[i][mid] < target){
                    L = mid + 1;
                } else if (array[i][mid] == target){
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean Find_2(int target, int [][] array) {
        int x = array.length;
        int y = array[0].length;
        int i = x - 1;
        int j = 0;
        while (i >= 0 && j < y){
            if(array[i][j] == target){
                return true;
            }else if (array[i][j] < target){
                j ++;
            }else{
                i --;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] a = new int[][] {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find_2(7,a));

    }
}
