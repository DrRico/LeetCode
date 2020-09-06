package com.rico.lchard;

/**
 * @author Rico_dds
 * @date 2020/8/28 12:17
 */
public class maximalRectangle85 {

    public static int maximalRectangle(String[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        //保存以当前数字结尾的连续 1 的个数
        int[][] width = new int[matrix.length][matrix[0].length];
        int maxArea = 0;
        //遍历每一行
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                //更新 width
                if (matrix[row][col].equals("1")) {
                    if (col == 0) {
                        width[row][col] = 1;
                    } else {
                        width[row][col] = width[row][col - 1] + 1;
                    }
                } else {
                    width[row][col] = 0;
                }
                //记录所有行中最小的数
                int minWidth = width[row][col];
                //向上扩展行
                for (int up_row = row; up_row >= 0; up_row--) {
                    int height = row - up_row + 1;
                    //找最小的数作为矩阵的宽
                    minWidth = Math.min(minWidth, width[up_row][col]);
                    //更新面积
                    maxArea = Math.max(maxArea, height * minWidth);
                }
            }
        }
        return maxArea;
    }

    /**
     * 调用84题栈的函数进行实现
     */
    public static int maximalRectangle_1(String[][] matrix) {
        int len = matrix.length;
        if(len == 0) return 0;
        int height = matrix[0].length;
        int[][] temp = new int[len][height];
        int res = 0;
        for (int i = 0; i < len; i ++){
            for (int j = 0; j < height; j ++){
                if(matrix[i][j].equals("1")){
                    if (i == 0){
                        temp[i][j] = 1;// i = 0第一层的情况，赋值为1
                    } else {
                        temp[i][j] = temp[i - 1][j] + 1; // 将上一层的数，加上1，得到本层当前的值
                    }
                }
            }
            // 遍历完一层之后，将这一层一维数组传递进去
            res = Math.max(res,largestRectangleArea84.largestRectangleArea_1(temp[i]));
        }
        return res;
    }


    public static void main(String[] args) {
        String[][] a = {{"1","0","1","0","0"},
                        {"1","0","1","1","1"},
                        {"1","1","1","1","1"},
                        {"1","0","0","1","0"}};
        System.out.println(maximalRectangle_1(a));
    }

}
