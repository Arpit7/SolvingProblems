package com.company.arpit.recursion;

public class StringReversePart2 {

    public static void main(String[] args) {
        char[] chars = {'H', 'E', 'L', 'L', 'O', ' ', 'W', 'O', 'R', 'L', 'D'};

        getReverseString(chars);

        System.out.println(chars);


    }

    private static void getReverseString(char[] chars) {

        if (chars.length == 0 || chars.length == 1)
            return;
        reverseString(0, chars.length - 1, chars);


    }

    private static void reverseString(int start, int last, char[] chars) {


        if (start >= last)
            return;

        char temp = chars[start];
        chars[start] = chars[last];
        chars[last] = temp;
        reverseString(start + 1, last - 1, chars);


    }


}
