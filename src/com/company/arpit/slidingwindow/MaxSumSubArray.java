package com.company.arpit.slidingwindow;

/*Given an array of positive numbers and a positive number ‘k,’
 find the maximum sum of any contiguous subarray of size ‘k’.*/
public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;


        int result = maxSumSubArray(arr, k);
        System.out.println(result);

        int[] arr1 = {2, 3, 4, 1, 5};
        int k1 = 2;
        int result1 = maxSumSubArray(arr1, k1);
        System.out.println(result1);

    }

    private static int maxSumSubArray(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int start = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i >= k - 1) {
                max = Math.max(sum, max);
                sum = sum - arr[start];
                start++;
            }
        }
        return max;
    }


}
