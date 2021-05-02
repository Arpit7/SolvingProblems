package com.company.arpit.slidingwindow;

/*
 * Given an array of positive numbers and a positive number ‘S,’
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
 *  Return 0 if no such subarray exists.
 * */
public class SmallestSubArray {

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 2, 3, 2};
        int sum = 7;
        int test1 = getSmallestSubArrayLength(arr, sum);
        System.out.println(test1);

        System.out.println("--------------------------------------------");

        int[] arr2={2, 1, 5, 2, 8};
        int sum2=7;
        int test2 = getSmallestSubArrayLength(arr2, sum2);
        System.out.println(test2);

        System.out.println("--------------------------------------------");

        int[] arr3={3, 4, 1, 1, 6};
        int sum3=8;
        int test3 = getSmallestSubArrayLength(arr3, sum3);
        System.out.println(test3);


    }

    private static int getSmallestSubArrayLength(int[] arr, int givensum) {

        int sum = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum >= givensum) {
                int length = i - start+1;
                minLength = Math.min(minLength, length);
                sum = sum - arr[start];
                start++;
            }


        }

        return minLength;

    }


}
