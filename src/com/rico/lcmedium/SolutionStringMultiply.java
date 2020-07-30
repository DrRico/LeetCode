package com.rico.lcmedium;

/**
 * @author Rico_dds
 * @date 2020/7/29 20:57
 */
public class SolutionStringMultiply {

    public static void main(String[] args) {
        System.out.println(multiply("123456", "123456"));
        System.out.println(Mymultiply_01("99", "21"));
        System.out.println(Mymultiply_01("99", "21"));
        // 56088
    }
    public static String Mymultiply_01(String num1, String num2){
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();     //统计数组长度
        int newlen = len1+len2;
        int[] num = new int[newlen];                     //建立结果数组

        for(int i=len1-1;i>=0;i--){
            int n1 = num1.charAt(i) - '0';
            for(int j=len2-1;j>=0;j--){
                int n2 = num2.charAt(j) - '0';
                num[i+j+1] += n1*n2;
            }
        }
        for(int i = newlen - 1; i > 0; i--)
        {
            num[i-1] += num[i]/10;
            num[i] = num[i]%10;
        }
        String s = "";
        int i = newlen - 1,j=0;
        if(num[0] == 0 && i>0)j++;
        for(;j<=i;j++){
            s += num[j];
        }
        return s;
    }

    public static String Mymultiply(String num1, String num2){
        int len1 = num1.length(), len2 = num2.length();     //统计数组长度
        int[] num = new int[len1+len2];                     //建立结果数组


        for(int i=0;i<len1;i++){
            int n1 = num1.charAt(len1 - i - 1) - '0';
            int temp = 0;                                       //处理进位
            for(int j=0;j<len2;j++){
                int n2 = num2.charAt(len2 - j - 1) - '0';
                temp = temp + num[i+j] + n1*n2;
                num[i+j] = temp % 10;
                temp = temp / 10;
            }
            num[i + len2] = temp;
        }
        String s = "";
        int i = len1 + len2 - 1;
        while(i>0&&num[i]==0){      //处理0，即{6,0}会对应为06，处理为最高位为0的情况
            i--;
        }
        while (i>=0){
            s += num[i--];
        }
        return s;
    }


    public static String multiply(String num1, String num2) {
        int l = num1.length();
        int r = num2.length();
        //用来存储结果的数组，可以肯定的是两数相乘的结果的长度，肯定不会大于两个数各自长度的和。
        int[] num = new int[l+r];
        //第一个数按位循环
        for(int i=0;i<l;i++) {
            //得到最低位的数字
            int n1=num1.charAt(l-1-i)-'0';
            //保存进位
            int tmp=0;
            //第二个数按位循环
            for(int j=0;j<r;j++) {
                int n2=num2.charAt(r-1-j)-'0';
                //拿出此时的结果数组里存的数+现在计算的结果数+上一个进位数
                tmp=tmp+num[i+j]+n1*n2;
                //得到此时结果位的值
                num[i+j]=tmp%10;
                //此时的进位
                tmp/=10;
            }
            //第一轮结束后，如果有进位，将其放入到更高位
            num[i+r]=tmp;
        }

        int i=l+r-1;
        //计算最终结果值到底是几位数，
        while(i>0&&num[i]==0){
            i--;
        }
        String result="";
        //将数组结果反过来放，符合正常读的顺序，
        //数组保存的是：1 2 3 4 5
        //但其表达的是54321，五万四千三百二十一。
        while(i>=0) {
            result += num[i--];
        }
        return result;
    }
}
