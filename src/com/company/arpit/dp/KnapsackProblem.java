package com.company.arpit.dp;

public class KnapsackProblem {

    public static void main(String[] args) {

        String[] items = {"Apple", "Orange", "Banana", "Melon"};
        int[] profit = {4, 5, 3, 7};
        int[] weights = {2, 3, 1, 4};
        int capacity = 5;

        int maxProfit = maxProfit(profit, weights, capacity);
        System.out.println(maxProfit);


    }

    public static int maxProfit(int[] profit, int[] weights, int capacity) {
        Integer[][] dp=new Integer[profit.length][capacity+1];

        return knapsack(dp,profit, weights, capacity, 0);
    }

    public static int knapsack(Integer[][] dp,int[] profit, int[] weights, int capacity, int currentIndex) {


        if (capacity <= 0 || currentIndex >= weights.length)
            return 0;

       /* if(dp[currentIndex][capacity]!=null)
            return dp[currentIndex][capacity];*/

        int profit1 = 0;
        if (weights[currentIndex] <= capacity) {
            profit1 = profit[currentIndex] + knapsack(dp,profit, weights, capacity - weights[currentIndex], currentIndex + 1);
        }


        int profit2 = knapsack(dp,profit, weights, capacity, currentIndex + 1);
     //   dp[currentIndex][capacity]=Math.max(profit1, profit2);
        return  Math.max(profit1, profit2);


    }


}
