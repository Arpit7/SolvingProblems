package com.company.arpit.recursion;
/*Given n people and k people to skip return wining person left in end*/
public class JosephProblem {

    public static void main(String[] args) {
        int n=5;
        int k=2;

        int winner=joseph(n,k);
        System.out.println(winner);

    }

    private static int joseph(int n, int k) {

        if(n==1)
            return 0;

        return (joseph(n-1,k)+k)%n;
    }


}
