package com.company.arpit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given an array of unsorted numbers, find all unique triplets in it that add up to zero.*/
public class UniqueTripletsAddingToZero {

    public static void main(String[] args) {

    /*
    * Input: [-3, 0, 1, 2, -1, 1, -2]
    Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
    Explanation: There are four unique triplets whose sum is equal to zero.
    * */

        int[] arr = {-3, 0, 1, 2, -1, 1, -2};

        Arrays.sort(arr);
        List<List<Integer>> integerList = findUniqueTriplet(arr);
        System.out.println(integerList);


        /*
        * Input: [-5, 2, -1, -2, 3]
        Output: [[-5, 2, 3], [-2, -1, 3]]
        Explanation: There are two unique triplets whose sum is equal to zero.
        * */
        int[] arr1 = {-5, 2, -1, -2, 3};

        Arrays.sort(arr1);
        List<List<Integer>> integerList1 = findUniqueTriplet(arr1);
        System.out.println(integerList1);

    }

    private static List<List<Integer>> findUniqueTriplet(int[] arr) {
        List<List<Integer>> integerList = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            findSum(arr, -arr[i], i + 1, integerList);
        }
        return integerList;
    }

    private static void findSum(int[] arr, int targetSum, int left, List<List<Integer>> integerList) {

        int start = left;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] + arr[end] == targetSum) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[start]);
                list.add(arr[end]);
                list.add(-targetSum);
                integerList.add(list);
                start++;
                end--;
                while (arr[start] == arr[start - 1]) {
                    start++;
                }

                while (arr[end] == arr[end + 1]) {
                    end--;
                }

            } else if (targetSum > arr[start] + arr[end]) {
                start++;

            } else {
                end--;

            }


        }


    }

    public static boolean binarySearch(int[] arr, int start, int end, int num) {

        if (start <= end) {
            int mid = start / 2 + end / 2;

            if (arr[mid] == num)
                return true;
            if (num > arr[mid]) {
                return binarySearch(arr, mid + 1, end, num);
            } else {
                return binarySearch(arr, start, mid - 1, num);
            }
        }
        return false;
    }


}
