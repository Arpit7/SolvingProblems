package com.company.arpit.twopointers;

/*Given an array of sorted numbers, remove all duplicates from it.
 You should not use any extra space; after removing the duplicates
 in-place return the length of the subarray that has no duplicate in it.*/
public class RemoveDuplicate {

    public static void main(String[] args) {
        /*
        * Input: [2, 3, 3, 3, 6, 9, 9]
           Output: 4
        Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
        *
        * */

        int[] arr = {2, 3, 3, 3, 6, 9, 9};

        int distinctLength = findNonDuplicateArrLength(arr);
        System.out.println(distinctLength);

        /*
        * Input: [2, 2, 2, 11]
        Output: 2
        Explanation: The first two elements after removing the duplicates will be [2, 11].
        *
        * */
        int[] arr1 = {2, 2, 2, 11};

        int distinctLength1 = findNonDuplicateArrLength(arr1);
        System.out.println(distinctLength1);

    }

    private static int findNonDuplicateArrLength(int[] arr) {
        int i = 0;
        int j = 1;
        while (j < arr.length) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
                j++;
            } else {
                j++;
            }


        }
        return i+1;


    }


}
