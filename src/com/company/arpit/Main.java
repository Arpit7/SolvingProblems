package com.company.arpit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
       /* int[] arr={-2, -3, 4, -1, -2, 1, 5, -3};
        int max_so_far=Integer.MIN_VALUE;
        int max_till_now=0;


        for(int i=0;i<arr.length;i++)
        {
            max_till_now+=arr[i];

            if(max_till_now<0)
                max_till_now=0;
            else if(max_so_far<max_till_now)
            {
                max_so_far=max_till_now;
            }

        }

        System.out.println(max_so_far);*/
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";

        String word2 = "coding";
        int result = shortestDistance(wordsDict, word1, word2);

        System.out.println(result);


    }


    public static int shortestDistance(String[] wordsDict, String word1, String word2) {

        Map<String, List<Integer>> indexMap = new HashMap<>();
        int result = 0;

        for (int i = 0; i < wordsDict.length; i++) {

            List<Integer> lst = new ArrayList<>();
            if (indexMap.get(wordsDict[i]) == null) {
                lst.add(i);
                indexMap.put(wordsDict[i], lst);
            } else {
                lst = indexMap.get(wordsDict[i]);
                lst.add(i);
            }

        }


        List<Integer> firstWordIndexes = indexMap.get(word1);
        List<Integer> secondWordIndexes = indexMap.get(word2);

        if (firstWordIndexes.size() == 1 && secondWordIndexes.size() == 1) {
            result = Math.abs(firstWordIndexes.get(0) - secondWordIndexes.get(0));
        } else if (firstWordIndexes.size() > 1 && secondWordIndexes.size() == 1) {


            int secondIndex = secondWordIndexes.get(0);
            for (int index : firstWordIndexes) {
                int diff = index - secondIndex;
                diff = diff < 0 ? (-1 * diff) : diff;
                result = Math.min(result, diff);
            }

        } else if (firstWordIndexes.size() == 1 && secondWordIndexes.size() > 1) {


            int firstWordIndex = firstWordIndexes.get(0);
            for (int index : secondWordIndexes) {
                int diff = index - firstWordIndex;
                diff = diff < 0 ? (-1 * diff) : diff;
                result = Math.min(result, diff);
            }

        }
        return result;

    }
}
