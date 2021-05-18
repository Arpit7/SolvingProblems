package com.company.arpit.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with minimum cost.
The cost of connecting two ropes is equal to the sum of their lengths.
 */
public class ConnectRopes {

    public static void main(String[] args) {
        /*
        Input: [1, 3, 11, 5]
        Output: 33
        Explanation: First connect 1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is 33 (4+9+20)
         */

        int[] arr = {1, 3, 11, 5};
        int minCost = getMinCostOfConnect(arr);
        System.out.println(minCost);

        /*
        Input: [3, 4, 5, 6]
        Output: 36
        Explanation: First connect 3+4(=7), then 5+6(=11), 7+11(=18). Total cost is 36 (7+11+18)

         */
        int[] arr1 = {3, 4, 5, 6};
        int minCost1 = getMinCostOfConnect(arr1);
        System.out.println(minCost1);
        /*
        Input: [1, 3, 11, 5, 2]
        Output: 42
        Explanation: First connect 1+2(=3), then 3+3(=6), 6+5(=11), 11+11(=22). Total cost is 42 (3+6+11+22)
         */
        int[] arr2 = {1, 3, 11, 5, 2};
        int minCost2 = getMinCostOfConnect(arr2);
        System.out.println(minCost2);

    }

    private static int getMinCostOfConnect(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(arr.length, Comparator.naturalOrder());
        for (int el : arr) {
            minHeap.add(el);
        }
        int minCost = 0;

        while (minHeap.size()>1) {

            int smallestData = minHeap.poll();
            int secondSmallest = minHeap.poll();
            int cost = smallestData + secondSmallest;
            minCost += cost;
            minHeap.add(cost);


        }
        return minCost;

    }


}
