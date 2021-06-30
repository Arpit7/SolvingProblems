package com.company.arpit.recursion;

public class SubSequenceOfString {

    public static void main(String[] args) {

        String str = "abc";
        printPermutation(str);
    }

    private static void printPermutation(String str) {

        String currString = "";
        int start = 0;
        printPermutations(str,start,currString);

    }

    private static void printPermutations(String str, int start,String currString) {


        if (start == str.length()) {
            System.out.println(currString);
            return;
        }

        printPermutations(str, start + 1,currString + str.charAt(start));
        printPermutations(str, start + 1,currString);

    }


}
