package com.company.arpit.dp;

import java.util.HashMap;
import java.util.Map;

public class FP {

    public static void main(String[] args) {

        System.out.println("-------Normal--------");
        int n = 20;
        int fp1=fibonnacci(n);
        System.out.println(fp1);

        System.out.println("-------With Memorization--------");
        Map<Integer, Integer> map = new HashMap<>();
        int fp2 = fibonnacciWithMemoriation(map, n);
        System.out.println(fp2);

        System.out.println("-------With Tabularization--------");
        int[] table = new int[n + 1];
        int fp3 = fibonnacciWithTabularization(table, n);
        System.out.println(fp3);

    }

    private static int fibonnacciWithTabularization(int[] table, int n) {
        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    private static int fibonnacci(int num) {
        if (num < 2)
            return num;

        return fibonnacci(num - 1) + fibonnacci(num - 2);


    }


    private static int fibonnacciWithMemoriation(Map<Integer, Integer> map, int num) {
        if (num < 2)
            return num;

        if (map.get(num) != null)
            return map.get(num);

        int result = fibonnacci(num - 1) + fibonnacci(num - 2);
        map.put(num, result);

        return result;


    }

}
