package com.company.arpit.recursion;

public class Palandrome {

    public static void main(String[] args) {
        String el="abba";
        Boolean result=palandrome(el);
        System.out.println(result);
    }

    private static Boolean palandrome(String el) {

        int start= 0;
        int end=el.length()-1;
       return isPalandrome(el,start,end);
    }

    private static Boolean isPalandrome(String el, int start, int end) {

        if(start>=end)
        {
            return true;
        }
        if(el.charAt(start)!=el.charAt(end))
        {
            return false;
        }
        return isPalandrome(el,start+1,end-1);

    }


}
