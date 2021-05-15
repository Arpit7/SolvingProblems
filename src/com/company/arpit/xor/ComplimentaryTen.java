package com.company.arpit.xor;

/*
Every non-negative integer N has a binary representation, for example, 8 can be represented as “1000” in binary and 7 as “0111” in binary.

The complement of a binary representation is the number in binary that we get when we change every 1 to a 0 and every 0 to a 1. For example, the binary complement of “1010” is “0101”.

For a given positive number N in base-10, return the complement of its binary representation as a base-10 integer.
 */
public class ComplimentaryTen {

    public static void main(String[] args) {
        /*
            Input: 8
            Output: 7
            Explanation: 8 is 1000 in binary, its complement is 0111 in binary, which is 7 in base-10.
         */

        int input=8;
        int output= getComplimentaryNumber(input);
        System.out.println(output);

        /*
            Input: 10
            Output: 5
            Explanation: 10 is 1010 in binary, its complement is 0101 in binary, which is 5 in base-10.
        */
        int input1=10;
        int output1= getComplimentaryNumber(input1);
        System.out.println(output1);
    }

    private static int getComplimentaryNumber(int input) {

        int n=input;
        int bitCount=0;
        while(n>0)
        {
            bitCount++;
            n=n>>1;
        }

        int all_bit_set=(int)Math.pow(2,bitCount)-1;





        return input ^ all_bit_set;
    }


}
