package com.company.arpit.misc;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/*
Find anagram list
 */
public class FindAnagram {

    public static void main(String[] args) {
        /*
         INPUT: {"diet","tied","now","won","own","wow"}
         OUTPUT: {{"diet","tied"},{"now","won","own"},{wow}}
         */


        List<String> lst = Arrays.asList("diet", "tied", "now", "won", "own", "wow");

       /* List<List<String>> result = findAnagramList(lst);
        System.out.println(result);*/


        List<List<String>> result1 = findAnagramList1(lst);
        System.out.println(result1);


    }

    private static List<List<String>> findAnagramList1(List<String> lst) {

        Map<Integer,List<String>> map=new HashMap<>();
        List<List<String>> result=new ArrayList<>();

        for(int i=0;i<lst.size();i++)
        {
            String el=lst.get(i);
            String str=sortString(el);
            int hashValue=str.hashCode();
            List<String> innerList=map.getOrDefault(hashValue,new ArrayList<>());
            innerList.add(lst.get(i));
            map.put(hashValue,innerList);
        }

        for(Integer el:map.keySet())
        {
            result.add(map.get(el));
        }

        return result;

    }

    private static List<List<String>> findAnagramList(List<String> lst) {

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < lst.size()-1; i++) {
            String el = lst.get(i);
            List<String> innerResult = new ArrayList<>();
            innerResult.add(el);
            for (int j = i+1; j < lst.size(); j++) {
                String el1 = lst.get(j);
                if (isAnagram(el, el1)) {
                    innerResult.add(el1);
                }
            }

           if(!isResultAlreadyContains(result,innerResult))
            result.add(innerResult);
        }

        return result;
    }

    private static boolean isResultAlreadyContains(List<List<String>> result, List<String> innerResult) {

        for(List<String> el: result)
        {
            if(el.containsAll(innerResult))
                return true;
        }
         return false;
    }

    private static boolean isAnagram(String el, String el1) {

        String elsort = sortString(el);
        String el1sort = sortString(el1);
        return elsort.equals(el1sort);
    }

    private static String sortString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        str = String.valueOf(arr);
        return str;


    }


}
