package com.company.arpit.twopointers;

import java.util.Arrays;

/*
 * Given a sorted array, create a new array containing squares of all
 * the numbers of the input array in the sorted order.
 * */
public class SquareOfNumbers {

    public static void main(String[] args) {
        /*
        * Input: [-2, -1, 0, 2, 3]
          Output: [0, 1, 4, 4, 9]
        * */
        int[] arr = {-2, -1, 0, 2, 3};

        Integer[] result = findSquareOfNumbers(arr);
        Arrays.stream(result).forEach(System.out::print);

        /*
        * Input: [-3, -1, 0, 1, 2]
            Output: [0, 1, 1, 4, 9]
        * */
        int[] arr1 = {-3, -1, 0, 1, 2};

        Integer[] result1= findSquareOfNumbers(arr1);
        System.out.println("-----------");
        Arrays.stream(result1).forEach(System.out::print);

    }

    private static Integer[] findSquareOfNumbers(int[] arr) {
        Integer[] result = new Integer[arr.length];
        int resultIndex = 0;
        int negativeIndex = 0;
        int positiveIndex = 0;
        while (arr[positiveIndex] < 0) {
            positiveIndex++;
        }
        negativeIndex = positiveIndex - 1;

        while (negativeIndex >= 0 && positiveIndex < arr.length) {
            int squareOfNegative = arr[negativeIndex] * arr[negativeIndex];
            int squareOfPositive = arr[positiveIndex] * arr[positiveIndex];

            if (squareOfNegative < squareOfPositive) {
                result[resultIndex] = squareOfNegative;
                negativeIndex--;

            } else {
                result[resultIndex] = squareOfPositive;
                positiveIndex++;
            }

            resultIndex++;


        }

        while(positiveIndex<arr.length)
        {
            result[resultIndex]=arr[positiveIndex] * arr[positiveIndex];
            positiveIndex++;
            resultIndex++;
        }
       while(negativeIndex >= 0)
       {
           result[resultIndex]=arr[negativeIndex] * arr[negativeIndex];
           negativeIndex--;
           resultIndex++;
       }

        return result;


    }

}
