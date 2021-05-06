package com.company.arpit.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array containing 0s and 1s, if you are allowed
 * to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.
 *
 * */
public class LongestSubStringWithOnesAfterReplacement {

    public static void main(String[] args) {
        /*
        * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
        Output: 6
        Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
        * */

        int[] arr = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        int k = 2;

        int length = getMaximumSubArrayWithAllOnesAfterKZeroReplacement(arr, k);
        System.out.println(length);
        /*
        * Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
           Output: 9
            Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
        * */

        int[] arr1 = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int k1 = 3;

        int length1 = getMaximumSubArrayWithAllOnesAfterKZeroReplacement(arr1, k1);
        System.out.println(length1);


    }

    private static int getMaximumSubArrayWithAllOnesAfterKZeroReplacement(int[] arr, int k) {
        int start = 0;
        int maxOnesLength = 0;
        int maxCountOfOnes = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            maxCountOfOnes = Math.max(maxCountOfOnes, map.getOrDefault(1,0));

            if (i - start + 1 - maxCountOfOnes > k) {
                map.put(arr[start], map.get(arr[start]) - 1);
                start++;
            }
            maxOnesLength = Math.max(maxOnesLength, i - start + 1);


        }
        return maxOnesLength;

    }
}
