package com.company.arpit.xor;
/*
Given an array of n integers in the range from 1 to n, find the one number that is missing from the array.
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        /*
        Input: 1, 5, 2, 6, 4
        Answer: 3
        */

        int[] arr={1,5,2,6,4};

        int missingNumber=getMissingNumber(arr);
        System.out.println(missingNumber);



    }

    private static int getMissingNumber(int[] arr) {

        int length=arr.length+1;

        int xorOfGivenNumber=arr[0];
        int xorOfSequence=1;
        for(int i=2;i<=length;i++)
        {
            xorOfSequence=xorOfSequence ^ i;
        }

        for(int k=1;k<arr.length;k++)
        {
            xorOfGivenNumber=xorOfGivenNumber^arr[k];
        }


        return xorOfGivenNumber ^ xorOfSequence;


    }


}
