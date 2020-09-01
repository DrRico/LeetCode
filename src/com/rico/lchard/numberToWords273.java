package com.rico.lchard;

/**
 * @author Rico_dds
 * @date 2020/8/31 22:11
 */
public class numberToWords273 {
    static String[] num2string = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
    static String[] ten2string = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    static String[] big2string = {"Hundred","Thousand","Million","Billion"};
    static String[] spec2string = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};


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

            if (chars.length - 1 - i == 2 || chars.length - 1 - i == 5 || chars.length - 1 - i == 8){ // 白
                sb.append(big2string[0]+ " ");
            } else if (chars.length - 1 - i == 3){  // 千
                sb.append(big2string[1]+ " ");
                if (chars.length - i >= 4 && i >= 1){
                    int tenBit = chars[i] -'0' + (chars[i-1]-'0')*10;
                    if (tenBit >=10 && tenBit <=19){
                        sb.append(spec2string[chars[i] -'0']+ " "); // 进行处理
                        i--;
                    }
                    // sb.append(big2string[1]+ " "); // 进行处理
                    continue;
                }
            } else if (chars.length - 1 - i == 6){// 百万
                sb.append(big2string[2]+ " ");
            } else if (chars.length - 1 - i == 9){// 十亿
                sb.append(big2string[3] + " ");
            }
            sb.append(num2string[(int) chars[i] - '0'] + " ");
        }


        String[] res = sb.toString().split(" ");
        sb.delete(0,sb.length());
        for (int i = res.length - 1; i > 0; i --){
            if(res[i].length() != 0)sb.append(res[i] + " ");
        }
        if(res[0].length() != 0){
            sb.append(res[0]);
        } else {
            sb.delete(sb.length()-1,sb.length());
        }
        return sb.toString();
    }


    private static String[] THOUSAND = {"", "Thousand", "Million", "Billion"};
    private static String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static String[] HUNDRED = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String numberToWords_1(int num) {
        if(num == 0) return "Zero";

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(num > 0) {
            if(num % 1000 != 0) {
                StringBuilder tmp = new StringBuilder();
                helper(num % 1000, tmp);
                sb.insert(0, tmp.append(THOUSAND[index]).append(" "));
            }
            index++;
            num /= 1000;
        }
        return sb.toString().trim();
    }

    private static void helper(int num, StringBuilder tmp) {
        if(num == 0) return;
        if(num < 20) {
            tmp.append(LESS_THAN_TWENTY[num]).append(" ");
        }else if(num < 100) {
            tmp.append(HUNDRED[num / 10]).append(" ");
            helper(num % 10, tmp);
        }else {
            tmp.append(LESS_THAN_TWENTY[num / 100]).append(" Hundred").append(" ");
            helper(num % 100, tmp);
        }
    }

    public static void main(String[] args) {
//        System.out.println(numberToWords(1234567));
//        System.out.println(numberToWords(12345));
//        System.out.println(numberToWords(110345));
        System.out.println(numberToWords_1(1000));


    }
}
