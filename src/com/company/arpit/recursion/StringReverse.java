package com.company.arpit.recursion;

public class StringReverse {

    public static void main(String[] args) {
        String str = "Arpit Bhargava";
        printStringInReverseOrder(str);
    }

    private static void printStringInReverseOrder(String str) {

        helper(0, str);

    }

    private static void helper(int i, String str) {

        if (str == null || i > str.length() - 1) {
            return;
        }

        helper(i + 1, str);
        System.out.print(str.charAt(i));


    }
}
