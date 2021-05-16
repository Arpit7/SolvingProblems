package com.company.arpit.misc;

import java.util.Arrays;

/*
Find next higher number using digits in number given
 */
public class NextHigherNumber {

    public static void main(String[] args) {
        /*
        INPUT: 3597
        OUTPUT: 3759

         */
        int num = 3597;
        int nextHigherNum = findNextHigherNumber(num);
        System.out.println(nextHigherNum);

    }

    private static int findNextHigherNumber(int num) {

        String[] arr = String.valueOf(num).split("");
        int lastDigit = Integer.parseInt(arr[arr.length - 1]);
        int smallDigitIndex = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int el = Integer.parseInt(arr[i]);
            if (lastDigit > el) {
                swap(arr, arr.length - 1, i);
                smallDigitIndex = i;
                break;

            }
        }
        Arrays.sort(arr, smallDigitIndex + 1, arr.length);
        StringBuffer result = new StringBuffer();
        for (String s : arr) {
            result.append(s);
        }

        return Integer.parseInt(result.toString());
    }

    private static void swap(String[] arr, int i, int i1) {

        String temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;

    }


}
