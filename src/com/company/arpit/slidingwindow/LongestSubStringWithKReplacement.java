package com.company.arpit.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string with lowercase letters only, if you are allowed to replace no more than
 * ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.
 *
 * */
public class LongestSubStringWithKReplacement {

    public static void main(String[] args) {
        String str = "aabccbb";
        int k = 2;

        int result = getLongestSubStringWithKReplacement(str, k);
        System.out.println(result);
/*
* Input: String="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
*
* */

        String str2 = "abbcb";
        int k2 = 1;

        int result2 = getLongestSubStringWithKReplacement(str2, k2);
        System.out.println(result2);

        /*
        * Input: String="abccde", k=1
Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
        * */
        String str3 = "abccde";
        int k3 = 1;

        int result3 = getLongestSubStringWithKReplacement(str3, k3);
        System.out.println(result3);


    }

    private static int getLongestSubStringWithKReplacement(String str, int k) {

        int start = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int maxRepeatCharLength = 0;
        int longestLength = 0;
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
            maxRepeatCharLength=Math.max(maxRepeatCharLength,charMap.get(ch));

            if (i - start +1 - maxRepeatCharLength > k) {
                char startChar=str.charAt(start);
                charMap.put(startChar,charMap.get(startChar)-1);
                start ++;
            }
            longestLength = Math.max(longestLength, i - start + 1);


        }
        return longestLength;


    }


}
