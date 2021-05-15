package com.company.arpit.xor;
/*
In a non-empty array of integers, every number appears twice except for one, find that single number.
 */
public class NonRepeatNumber {

    public static void main(String[] args) {
        /*
        Input: 1, 4, 2, 1, 3, 2, 3
        Output: 4
         */
        int[] arr={1, 4, 2, 1, 3, 2, 3};
        int nonRepeatNumber=getNonRepeatNumber(arr);
        System.out.println(nonRepeatNumber);
        /*
        Input: 7, 9, 7
        Output: 9
         */
        int[] arr1={7,9,7};
        int nonRepeatNumber1=getNonRepeatNumber(arr1);
        System.out.println(nonRepeatNumber1);


    }

    private static int getNonRepeatNumber(int[] arr) {
        int nonRepeatNumber=arr[0];

        for(int i=1;i<arr.length;i++)
        {
            nonRepeatNumber=nonRepeatNumber ^ arr[i];
        }

        return nonRepeatNumber;
    }

}
