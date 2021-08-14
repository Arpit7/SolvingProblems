package com.company.arpit.misc;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

    public static void main(String[] args) {
        int[] arr={4,4,4,5,5,5,5,0,0};
        FrequencySort fs=new FrequencySort();
        PriorityQueue<Map.Entry<Integer,Integer>> result=fs.frequencySort(arr);
        System.out.print(result);


    }

     public PriorityQueue<Map.Entry<Integer,Integer>> frequencySort(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        Comparator<Map.Entry<Integer,Integer>> c=new MapCompartor();

        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<Map.Entry<Integer,Integer>>(c);
        pq.addAll(map.entrySet());
        return  pq;


    }

    class MapCompartor implements Comparator<Map.Entry<Integer,Integer>>
    {

        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
           if(o1.getValue().equals(o2.getValue()))
           {
               return o1.getKey()-o2.getKey();
           }

            return o1.getValue()-o2.getValue();
        }
    }


}
