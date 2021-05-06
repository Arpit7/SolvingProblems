package com.company.arpit.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//Given a string, find the length of the longest substring, which has no repeating characters.
public class LongestSubStringWithNoRepeat {

    public static void main(String[] args) {
        /*Input: String="aabccbb"
    Output: 3
    Explanation: The longest substring without any repeating characters is "abc".*/

        String str1 = "aabccbb";
        int result = getLongestDistinctCharacterSubString(str1);
        System.out.println(result);

    /*Input: String="abbbb"
    Output: 2
    Explanation: The longest substring without any repeating characters is "ab".*/
        String str2 = "abbbb";
        int result2 = getLongestDistinctCharacterSubString(str2);
        System.out.println(result2);

   /* Input: String="abccde"
    Output: 3
    Explanation: Longest substrings without any repeating characters are "abc" & "cde".*/

        String str3 = "abccde";
        int result3 = getLongestDistinctCharacterSubString(str3);
        System.out.println(result3);


    }


    private static int getLongestDistinctCharacterSubString(String str) {

        int start = 0;
        int maxLength = Integer.MIN_VALUE;

        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
            while (charMap.get(ch) > 1) {

                Character startChar=str.charAt(start);
                charMap.put(startChar,charMap.get(startChar)-1);
                if(charMap.get(startChar)==0)
                {
                    charMap.remove(startChar);
                }
            start++;
            }
            maxLength = Math.max(maxLength, i - start + 1);


        }


        return maxLength;
    }
}
