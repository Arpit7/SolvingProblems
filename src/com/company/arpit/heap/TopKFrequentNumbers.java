package com.company.arpit.heap;

import java.util.*;
/*
Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.
 */
public class TopKFrequentNumbers {
    public static void main(String[] args) {
        /*
        Input: [1, 3, 5, 12, 11, 12, 11], K = 2
        Output: [12, 11]
        Explanation: Both '11' and '12' apeared twice.
         */
        int k=2;
        int[] arr={1, 3, 5, 12, 11, 12, 11};
        List<Integer> result=getKFrequentNumbers(arr,k);
        System.out.println(result);

        /*
        Input: [5, 12, 11, 3, 11], K = 2
        Output: [11, 5] or [11, 12] or [11, 3]
        Explanation: Only '11' appeared twice, all other numbers appeared once.
         */
        int k1=2;
        int[] arr1={5, 12, 11, 3, 11};
        List<Integer> result1=getKFrequentNumbers(arr1,k1);
        System.out.println(result1);


    }

    private static List<Integer> getKFrequentNumbers(int[] arr, int k) {

        Map<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap=new PriorityQueue<>((e1,e2)->e1.getValue()-e2.getValue());
        for(int el:arr)
        {
            map.put(el,map.getOrDefault(el,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            minHeap.add(entry);
            if(minHeap.size()>k)
            {
                minHeap.poll();
            }
        }

       List<Integer> frequentNumbers=new ArrayList<>();
        while(!minHeap.isEmpty())
        {
            frequentNumbers.add(minHeap.poll().getKey());
        }
        return  frequentNumbers;
    }
}
