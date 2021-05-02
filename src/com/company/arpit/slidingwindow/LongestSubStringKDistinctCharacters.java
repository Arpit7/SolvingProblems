package com.company.arpit.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
* Given a string, find the length of the longest substring in it with no more than K distinct characters.

You can assume that K is less than or equal to the length of the given string.
* */

// OR

/*
Given an array of characters where each character represents a fruit tree, you are given two baskets,
and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
You can start with any tree, but you can’t skip a tree once you have started.
You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
 */

//OR

/*
Given a string, find the length of the longest substring in it with at most two distinct characters.

 */

public class LongestSubStringKDistinctCharacters {

    public static void main(String[] args) {
        /*
        Input: String="araaci", K=2
        Output: 4
        Explanation: The longest substring with no more than '2' distinct characters is "araa".
         */

        String str1 = "araaci";
        int k = 2;
        int longestLength = getLongestSubStringWithKDistinctCharacter(str1, k);
        System.out.println(longestLength);
        System.out.println("------------------------------");
        /*
        * Input: String="araaci", K=1
          Output: 2
          Explanation: The longest substring with no more than '1' distinct characters is "aa".
        *
        * */

        String str2 = "araaci";
        int k2 = 1;
        int longestLength2 = getLongestSubStringWithKDistinctCharacter(str2, k2);
        System.out.println(longestLength2);


        System.out.println("------------------------------");
        /*

        Input: String="cbbebi", K=3
        Output: 5
        Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
         */

        String str3 = "cbbebi";
        int k3 = 3;
        int longestLength3 = getLongestSubStringWithKDistinctCharacter(str3, k3);
        System.out.println(longestLength3);


    }

    private static int getLongestSubStringWithKDistinctCharacter(String str1, int k) {

        Map<Character, Integer> charMap = new HashMap<>();
        int start = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < str1.length(); i++) {
            Character c = str1.charAt(i);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);

            while (charMap.size() > k) {

                char startCharacter = str1.charAt(start);
                charMap.put(startCharacter, charMap.get(startCharacter) - 1);

                if (charMap.get(startCharacter) == 0) {
                    charMap.remove(startCharacter);
                }
                start++;


            }
            int length = i - start +1;

            maxLength = Math.max(maxLength, length);


        }

        return maxLength;


    }


}
