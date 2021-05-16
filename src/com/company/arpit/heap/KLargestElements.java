package com.company.arpit.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Given an unsorted array of numbers, find the ‘K’ largest numbers in it.
 */
public class KLargestElements {

    public static void main(String[] args) {
        /*
        Input: [3, 1, 5, 12, 2, 11], K = 3
        Output: [5, 12, 11]
         */

        int[] arr = {3, 1, 5, 12, 2, 11};
        int k = 3;

        PriorityQueue<Integer> lst = getKLargestElements(arr, k);
        System.out.println(lst);

    }

    private static PriorityQueue<Integer> getKLargestElements(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }

        for (int j = k; j < arr.length; j++) {
            if (!minHeap.isEmpty() && arr[j] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[j]);
            }
        }


        return minHeap;


    }
}
