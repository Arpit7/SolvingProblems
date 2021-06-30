package com.company.arpit.recursion;

import java.util.HashSet;
import java.util.Set;

public class PermutationOfString {

    public static void main(String[] args) {
        String str="abc";
        printPermutation(str);
    }

    private static void printPermutation(String str) {
        Set<String> set=new HashSet<>();
        int start=0;
        int last=str.length()-1;
        printPermutations(str,start,last,set);



    }



    private static void printPermutations(String str, int start, int last, Set<String> set) {

        if(start==last)
        {
           if(!set.contains(str))
           {
               set.add(str);
               System.out.println(str);
           }

            return ;
        }

        for(int i=0;i<=last;i++)
        {
            str=swap(str,i,start);
            printPermutations(str,start+1,last,set);
            str=swap(str,i,start);
        }



    }

    private static String swap(String str, int i, int start) {
        char[] arr=str.toCharArray();
        char temp=arr[i];
        arr[i]=arr[start];
        arr[start]=temp;
        return String.valueOf(arr);


    }

}
