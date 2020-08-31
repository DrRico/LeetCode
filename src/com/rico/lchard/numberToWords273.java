package com.rico.lchard;

/**
 * @author Rico_dds
 * @date 2020/8/31 22:11
 */
public class numberToWords273 {
    static String[] num2string = {" ","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    static String[] ten2string = {" "," ","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    static String[] big2string = {"Hundred","Thousand","Million","Billion"};
    static String[] spec2string = {"Ten","Eleven","Twelve","Billion "};


    public static String numberToWords(int num) {
        String str = num + "";
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i --){

            if (i == chars.length - 1 && chars[i] == '0'){
                sb.append(ten2string[(int) chars[--i] - '0']+ " ");
                continue;
            }

            if (i == chars.length - 1 && chars[i] != '0'){
                sb.append(num2string[(int) chars[i] - '0']+ " ");
                continue;
            }

            if (chars.length - 1 - i == 4 || chars.length - 1 - i == 7 || chars.length - 1 - i == 1){
                sb.append(ten2string[(int) chars[i] - '0']+ " ");
                continue;
            }

            if (chars.length - 1 - i == 2 || chars.length - 1 - i == 5 || chars.length - 1 - i == 8){
                sb.append(big2string[0]+ " ");
            } else if (chars.length - 1 - i == 3){
                sb.append(big2string[1]+ " ");
                if (){
                    sb.append(big2string[1]+ " "); // 进行处理
                    continue;
                }
            } else if (chars.length - 1 - i == 6){
                sb.append(big2string[2]+ " ");
            } else if (chars.length - 1 - i == 9){
                sb.append(big2string[3] + " ");
            }
            sb.append(num2string[(int) chars[i] - '0'] + " ");
        }
        String[] res = sb.toString().split(" ");
        sb.delete(0,sb.length());
        for (int i = res.length - 1; i > 0; i --){
            sb.append(res[i] + " ");
        }
        sb.append(res[0]);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(1234567));
        System.out.println(numberToWords(12345));
        System.out.println(numberToWords(10345));

        // out: Seven Six Hundred Five Thousand Four Three Hundred Two Million One
        //      Seven Six Hundred Five Thousand Four Thirty Hundred Two Million One
        //      One Million Two Hundred Thirty Four Thousand Five Hundred Six Seven
        //      One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven
        //      One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
    }
}
