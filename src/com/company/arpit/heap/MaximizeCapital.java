package com.company.arpit.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given a set of investment projects with their respective profits, we need to find the most profitable projects. We are given an initial capital and are allowed to invest only in a fixed number of projects.
Our goal is to choose projects that give us the maximum profit. Write a function that returns the maximum total capital after selecting the most profitable projects.
We can start an investment project only when we have the required capital. Once a project is selected, we can assume that its profit has become our capital.
 */
public class MaximizeCapital {

    public static void main(String[] args) {
        /*
        Input: Project Capitals=[0,1,2], Project Profits=[1,2,3], Initial Capital=1, Number of Projects=2
        Output: 6
        Explanation:

        With initial capital of ‘1’, we will start the second project which will give us profit of ‘2’. Once we selected our first project, our total capital will become 3 (profit + initial capital).
        With ‘3’ capital, we will select the third project, which will give us ‘3’ profit.
        After the completion of the two projects, our total capital will be 6 (1+2+3).
         */
        int[] capital = {0, 1, 2};
        int[] profits = {1, 2, 3};
        int initialCapital = 1;
        int numProject = 2;
        int maxProfit = getMaxProfit(capital, profits, initialCapital, numProject);

        System.out.println(maxProfit);


        /*
        Example 2:

        Input: Project Capitals=[0,1,2,3], Project Profits=[1,2,3,5], Initial Capital=0, Number of Projects=3
        Output: 8
        Explanation:

        With ‘0’ capital, we can only select the first project, bringing out capital to 1.
        Next, we will select the second project, which will bring our capital to 3.
        Next, we will select the fourth project, giving us a profit of 5.
        After selecting the three projects, our total capital will be 8 (1+2+5).
         */
        int[] capital1 = {0, 1, 2, 3};
        int[] profits1 = {1, 2, 3, 5};
        int initialCapital1 = 0;
        int numProject1 = 3;
        int maxProfit1 = getMaxProfit(capital1, profits1, initialCapital1, numProject1);

        System.out.println(maxProfit1);

    }

    /*private static int getMaxProfit(int[] capital, int[] profits, int initialCapital, int numProject) {

        Map<Integer, Integer> map = new HashMap<>();
        int maxProfit = initialCapital;
        int profit = -1;
        for (int i = 0; i < capital.length; i++) {
            map.put(capital[i], profits[i]);
        }

        int startCapital = initialCapital;

        for (int i = 0; i < numProject; i++) {
            while (profit == -1 && startCapital >= 0) {
                profit = map.getOrDefault(startCapital, -1);
                startCapital--;
            }

            startCapital = maxProfit + profit;
            maxProfit += profit;
            profit = -1;

        }

        return maxProfit;


    }*/

    private static int getMaxProfit(int[] capital, int[] profits, int initialCapital, int numProject) {

        int availableCapital = initialCapital;

        int length = profits.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(length, Comparator.naturalOrder());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(length, Comparator.reverseOrder());

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < capital.length; i++) {
            map.put(capital[i], profits[i]);
        }

        for (int i = 0; i < profits.length; i++) {
            minHeap.add(capital[i]);
        }

        for (int k = 0; k < numProject ; k++) {

            while (!minHeap.isEmpty() && minHeap.peek() <= availableCapital) {
                maxHeap.add(map.get(minHeap.poll()));
            }

            if (!maxHeap.isEmpty()) {
                availableCapital += maxHeap.poll();
            }else
            {
                break;
            }

        }


        return availableCapital;


    }

}
