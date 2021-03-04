package com.rico.newcoderCompetition;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Rico_dds
 * @date 2020/12/3 16:58
 */

public class MostTenTime  {
    public static void main(String[] args) {
        String str = "The Consumers’ Day, also called International Day for Protecting Consumers’ Rights, is held on 15th March every year. The consumers’ day aims to protect the customers’ right and enhance the customers’ cooperation and communication among nations. The former United States President John Kennedy was the first one to put forward the consumer’s day. He said that the consumers’ have four basic rights, which are the right to have the security of commodity, the right to know the precise detail of commodity, the right to choose goods freely and the right to express personal objection.\n" +
                "   In China, we usually hold an evening party to let the people know about their rights. On that special night, the CCTV will expose the fake goods in the markets and the special guests will be invited to come to the show to tell about the inside stories of producing fake products. These kinds of programs will cause heated debate in the society. The consumers will pay more attention to their rights. Here are some useful tips for how to protect your rights.\n" +
                "   Always buy goods from the regular stores, don’t fall for small advantages. Why people buy the fake goods? Generally speaking, the fake one is much cheaper than the real one. Check the commodity before you pay for it. Pay attention to the production date and the storing way. Remember to get the receipt. If something is wrong with the product, you can have your money back with it.\n" +
                "   I think every consumer should know their rights and protect their rights. It’s our responsibilities to make this market become better and healthier.";
        String[] strs = str.split(" ");
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (String s : strs){
            if (treeMap.containsKey(s)){
                treeMap.put(s,treeMap.get(s) + 1);
            } else {
                treeMap.put(s, 1);
            }
        }
        Set<String> set = treeMap.keySet();
        int cnt = 0;
        String[] sstr = new String[10];
        int[] scnt = new int[10];
        for (String string : set) {
            sstr[cnt++] = string;
            treeMap.get(string);
            if (cnt >= 10) break;
        }
        System.out.println();
    }
}
