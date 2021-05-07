package com.company.arpit.twopointers;

/*
 *
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 *
 * */
public class Sum {

    public static void main(String[] args) {

     /*   Input: [1, 2, 3, 4, 6], target=6
        Output: [1, 3]
        Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
     */

        int[] arr = {1, 2, 3, 4, 6};
        int sum = 6;

        Result result = isPairsSummingToNumberExists(arr, sum);
        if(result.isExists())
        {
            System.out.println(result);
        }

      /*  Input: [2, 5, 9, 11], target=11
        Output: [0, 2]
        Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
        */
        int[] arr1 = {2, 5, 9, 11};
        int sum1 = 11;

        Result result1 = isPairsSummingToNumberExists(arr1, sum1);
        if(result1.isExists())
        {
            System.out.println(result1);
        }

    }

    private static Result isPairsSummingToNumberExists(int[] arr, int sum) {

        Result result = new Result();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int indexSum = arr[i] + arr[j];
            if (indexSum == sum) {
                result.setExists(true);
                result.setFirstIndex(i);
                result.setSecondIndex(j);
                return result;
            }

            if (indexSum < sum) {
                i++;
            } else {
                j--;
            }


        }

        return result;
    }

    static class Result {
        boolean exists;
        int firstIndex;
        int secondIndex;


        public boolean isExists() {
            return exists;
        }

        public void setExists(boolean exists) {
            this.exists = exists;
        }

        public int getFirstIndex() {
            return firstIndex;
        }

        public void setFirstIndex(int firstIndex) {
            this.firstIndex = firstIndex;
        }

        public int getSecondIndex() {
            return secondIndex;
        }

        public void setSecondIndex(int secondIndex) {
            this.secondIndex = secondIndex;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "exists=" + exists +
                    ", firstIndex=" + firstIndex +
                    ", secondIndex=" + secondIndex +
                    '}';
        }
    }


}
