package com.company.arpit.misc;

import java.util.HashMap;
import java.util.Map;

/*
Find Longest substring having unique characters
 */
public class UniqueCharacterLongestString {

    public static void main(String[] args) {
        /*
        INPUT: abcddeeff
        OUTPUT: 4

        INPUT: abcddeeffghijk
        OUTPUT: 6
         */
        String str = "abcddeeffghijk";
        int length = findLongestUniqueCharacterSubString(str);
        System.out.println(length);


    }

    private static int findLongestUniqueCharacterSubString(String str) {

        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            char el = str.charAt(i);
            map.put(el, map.getOrDefault(el, 0) + 1);
            while (map.get(el) > 1) {
                map.put(str.charAt(start), map.get(str.charAt(start)) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, i - start + 1);


        }
        return maxLength;

    }


}
