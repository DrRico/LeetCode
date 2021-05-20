package com.springjobhunting.newcoder;

import java.util.Scanner;

/**
 * @author Rico_dds
 * @date 2021/3/10 20:34
 */
public class SF02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nstr = sc.nextLine();
        int n = Integer.parseInt(nstr);
        String valStr = sc.nextLine();
        String[] valstrs = valStr.split(" ");
        int[] valnum = new int[n];
        int sum = 0,oneval = 0;
        for (int i = 0; i < n; i++) {
            valnum[i] = Integer.parseInt(valstrs[i]);
            sum += valnum[i];
            oneval += valnum[i]*valnum[i];
        }
        String costStr = sc.nextLine();
        String[] costStrs = costStr.split(" ");
        int[] costnum = new int[costStrs.length];
        for (int i = 0; i < costStrs.length; i++) {
            costnum[i] = Integer.parseInt(costStrs[i]);
        }

        int cost = sum * sum;
        cost = cost - costnum[n-1];
        int onecost = oneval - costnum[0];
        int finl = cost > onecost ? cost : onecost;
        System.out.println(finl);
    }
}
