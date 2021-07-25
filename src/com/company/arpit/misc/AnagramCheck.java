package com.company.arpit.misc;

import java.util.Arrays;

public class AnagramCheck {

    public static void main(String[] args) {
        String s1="ab";
        String s2="bc";

        int diff=findDifference(s1,s2);
        System.out.println(diff);
    }

    private static int findDifference(String s1, String s2) {

        if(s1.length()!=s2.length())
        {
            return -1;
        }
        else
        {
            int diff=0;
            int[] char_count=new int[26];
            for(int i=0;i<s1.length();i++)
            {
                char_count[s1.charAt(i)-'a']++;
            }

            for(int i=0;i<s1.length();i++)
            {
                char_count[s2.charAt(i)-'a']--;
            }
            for(int i=0;i<26;i++)
            {
                if(char_count[i]!=0)
                {
                    diff+=Math.abs(char_count[i]);
                }
            }
            return diff/2;
        }


    }


}
