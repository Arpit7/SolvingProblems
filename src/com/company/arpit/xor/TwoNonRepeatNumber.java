package com.company.arpit.xor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
In a non-empty array of numbers, every number appears exactly twice except two numbers that appear only once.
Find the two numbers that appear only once.
 */
public class TwoNonRepeatNumber {

    public static void main(String[] args) {
        /*
        Input: [1, 4, 2, 1, 3, 5, 6, 2, 3, 5]
        Output: [4, 6]
         */

        int[] arr = {1, 4, 2, 1, 3, 5, 6, 2, 3, 5};
        List<Integer> twoNumbers = getTwoNonRepeatNumber(arr);

        System.out.println(twoNumbers);

        /*
        Input: [2, 1, 3, 2]
        Output: [1, 3]
         */

        int[] arr1 = {2, 1, 3, 2};
        List<Integer> twoNumbers1 = getTwoNonRepeatNumber(arr1);
        System.out.println(twoNumbers1);


    }

    public static int[] findSingleNumbers(int[] nums) {
        // get the XOR of the all the numbers
        int n1xn2 = 0;
        for (int num : nums) {
            n1xn2 ^= num;
        }

        // get the rightmost bit that is '1'
        int rightmostSetBit = 1;
        while ((rightmostSetBit & n1xn2) == 0) {
            rightmostSetBit = rightmostSetBit << 1;
        }
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) != 0) // the bit is set
                num1 ^= num;
            else // the bit is not set
                num2 ^= num;
        }
        return new int[] { num1, num2 };
    }

    private static List<Integer> getTwoNonRepeatNumber(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> nonRepeat = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        }

        for (Integer el : map.keySet()) {
            if (map.get(el) == 1) {
                nonRepeat.add(el);
            }
        }

        return nonRepeat;


    }






    /*private static List<Integer> getTwoNonRepeatNumber(int[] arr) {

        int xorOfNumber=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            xorOfNumber=xorOfNumber ^ arr[i];
        }
        int firstNumber=0;

        for(int k=0;k< arr.length;k++)
        {

            int xor=xorOfNumber ^ arr[k];

            if(xor==0)
            {
               firstNumber=arr[k];
            }
        }

        List<Integer> lst=new ArrayList<>();
        lst.add(firstNumber);
        lst.add(xorOfNumber ^ firstNumber);
        return  lst;
    }*/


}
