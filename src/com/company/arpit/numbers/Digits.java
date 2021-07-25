package com.company.arpit.numbers;

public class Digits {

    public static void main(String[] args) {
        int abc=2456789;

        for(int i=1;i<=String.valueOf(abc).length();i++)
        {
            double digit=(abc%Math.pow(10,i)-abc%Math.pow(10,i-1))/Math.pow(10,i-1);
            System.out.println((int)digit);
        }


    }

}
