package com.company.arpit.recursion;

public class Basics1 {

    public static void main(String[] args) {
       /* int n=10;
        int result = fibonnai(n);
        System.out.println(result);*/
        /*int row=4;
        printStar(row,0);*/
       /* int n=10;
        int result=findSum(n);
        System.out.println(result);
*/
        int a = 5;
        int b = 5;

        /*int result = power(a, b);

        System.out.println(result);*/


        int result=path(a,b);
        System.out.println(result);
    }

    private static int path(int a, int b) {

        if(a==0 && b==0)
            return 0;

        if(a==1 || b==1)
            return 1;
        return path(a-1,b)+path(a,b-1);
    }

    private static int power(int a, int b) {

        if (b == 0)
            return 1;

        return power(a, b - 1) * a;


    }


    private static int findSum(int n) {

        if (n == 1)
            return 1;

        return findSum(n - 1) + n;
    }

    private static void printStar(int row, int helper) {

        if (row == 0)
            return;
        for (int j = 0; j < helper; j++)
            System.out.print(" ");
        for (int i = 0; i < row; i++) {
            System.out.print("*");
        }
        System.out.println();
        printStar(row - 1, helper + 1);

    }


    private static int fibonnai(int n) {

        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonnai(n - 1) + fibonnai(n - 2);
    }
}
