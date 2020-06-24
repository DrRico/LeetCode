package com.rico.medium;

/**
 * @author Rico_dds
 * @date 2020/6/15 22:42
 */
public class SolutionFindGreatestSumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0)
            return 0;
        else{
            int total=array[0],maxSum=array[0];
            for(int i=1;i<array.length;i++){
                if(total>=0)
                    total +=  array[i];
                else
                    total=array[i];
                if(total>maxSum)
                    maxSum=total;
            }
            return maxSum;
        }

    }

    public static void main(String[] args) {
        // int[] array = new int[]{4,-1,4,-2,5,8,1,-7,2};
        int[] array = new int[]{6,-3,-2,-3,7,-15,1,13,2,2,-13};
        System.out.println(new SolutionFindGreatestSumOfSubArray().FindGreatestSumOfSubArray(array));
    }


}
