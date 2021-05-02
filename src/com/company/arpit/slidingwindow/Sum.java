package com.company.arpit.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/*Given an array, find the sum/average of all contiguous subarrays of size ‘K’ in it.*/
public class Sum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 10, 9, 22, 33, 44};

        int k = 3;
        List<Integer> resultBF = getArraySumBF(arr, k);
        System.out.println(resultBF);
        System.out.println("---------------------------------------");
        List<Integer> result = getArraySum(arr, k);
        System.out.println(result);
        System.out.println("--------Average-------------");
        List<Double> resultAverage = getArrayAverage(arr, k);
        System.out.println(resultAverage);


    }

    private static List<Double> getArrayAverage(int[] arr, int k) {
        List<Double> result = new ArrayList<>();
        double sum = 0;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i >= k - 1) {
                result.add(sum / k);
                sum = sum - arr[start];
                start++;
            }
        }
        return result;
    }

    private static List<Integer> getArraySum(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i >= k - 1) {
                result.add(sum);
                sum = sum - arr[start];
                start++;
            }
        }
        return result;
    }

    private static List<Integer> getArraySumBF(int[] arr, int k) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= arr.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            result.add(sum);
        }


        return result;

    }

}
