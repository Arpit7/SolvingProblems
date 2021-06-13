package com.company.arpit.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestDistanceBetweenWords {

    public static void main(String[] args) {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "coding";
        int result = shortestDistance(wordsDict, word1, word2);

        System.out.println(result);


    }


    public static int shortestDistance(String[] wordsDict, String word1, String word2)
    {
        int p1=-1;int p2=-1;int minDistance=Integer.MAX_VALUE;

        for(int i=0;i<wordsDict.length;i++)
        {

            if(wordsDict[i].equals(word1))
                p1=i;
            if(wordsDict[i].equals(word2))
                p2=i;

            if(p1!=-1 && p2!=-1)
            {
                minDistance=Math.min(minDistance,Math.abs(p1-p2));
            }


        }
        return minDistance;


    }
}
