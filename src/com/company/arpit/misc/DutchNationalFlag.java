package com.company.arpit.misc;


class DutchNationalFlag {

    public static void sort(int[] arr) {

        int low = 0;
        int high = arr.length - 1;
        for (int i = 0; i <= high; ) {
            if (arr[i] == 0) {
                swap(arr, i, low);
                i++;
                low++;
            }
            else if (arr[i] == 1) {
                i++;
            }
           else  if (arr[i] == 2) {
                swap(arr, i, high);
                high--;
            }


        }


    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;


    }

}
