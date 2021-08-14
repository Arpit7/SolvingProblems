package com.company.arpit.misc;

public class Test {

    public static void main(String[] args) {

        int[] arr={1, 0, 2, 1, 0};

        DutchNationalFlag.sort(arr);
        for(int i:arr)
        {
            System.out.print(i);
            System.out.print("  ");
        }
    }
}
